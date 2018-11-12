 package global.sesoc.team.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoogleGeocoding {
      private final static String apiURL = "https://maps.googleapis.com/maps/api/geocode/json";

      /**
       * 
       * @param address : 주소
       * @return 좌표 (34.34234,127.234234 형식), , return null : 에러
       */
      public String getLocationByAddress(String address) {
         StringBuffer inputData = null;
         try {
            URL url = new URL(
                  apiURL + "?address=" + URLEncoder.encode(address, "UTF-8") + "&language=ja" + "&key=" + "AIzaSyAH0Ga4D-X-QGWG0g97rhSk6UIbSdUd8Vc");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(false);
            con.setDoInput(true);
            con.setUseCaches(false);
            InputStream ist = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(ist));
            String input = "";
            inputData = new StringBuffer();
            while ((input = in.readLine()) != null) {
               inputData.append(input);
            }
            in.close();
            con.disconnect();
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         String json = inputData.toString();
         JsonObject root = new JsonParser().parse(json).getAsJsonObject();
         if (root.get("status").getAsJsonPrimitive().getAsString().equals("OK")) {
            JsonObject location = root.get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
            String lat = location.get("lat").getAsJsonPrimitive().getAsString();
            String lng = location.get("lng").getAsJsonPrimitive().getAsString();
            return lat + "," + lng;
         } else {
            System.out.println("GoogleGeocoding Error :" + root.get("status").getAsJsonPrimitive().getAsString());
            return null;
         }
      }
   }