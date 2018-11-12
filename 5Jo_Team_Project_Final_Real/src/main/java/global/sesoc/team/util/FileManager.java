package global.sesoc.team.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


public class FileManager {
//	@Autowired private ServletContext servletcontext;
	
	public static String UPLOADPATH = "";
	public FileManager() {
//		UPLOADPATH = servletcontext.getRealPath("/resources/images");
//		System.out.println(UPLOADPATH);
//		File f = new File(UPLOADPATH);
//		if(f.isDirectory()) {
//			f.mkdir();
//		}
	}
	
	public FileManager(ServletContext servletcontext) {
		UPLOADPATH = servletcontext.getRealPath("/resources/images");
		System.out.println(UPLOADPATH);
		File f = new File(UPLOADPATH);
		if(f.isDirectory()) {
			f.mkdir();
		}
	}
	
	
	public void test() {
//		UPLOADPATH = servletcontext.getRealPath("/");
		System.out.println(UPLOADPATH);
	}
	/**
	 * Return originalFileName and savedFileName
	 * when file uploading is completed 
	 * @param MultipartFile
	 * @return String[]
	 */
	public String[] uploadFile(MultipartFile uploadFile) {
		String OriginalFileName = uploadFile.getOriginalFilename();
		String savedFileName = UUID.randomUUID()+"_"+OriginalFileName;
		File saveFile = new File(UPLOADPATH, savedFileName);
		String[] temp = new String[2];
		try {
			uploadFile.transferTo(saveFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			temp[0] = OriginalFileName;
			temp[1] = savedFileName;
		}		
		return temp;
	}
	
	/**
	 * 배열의 첫 번째 는 OriginalFileName, 두 번째는 SavedFileName이 요구됨
	 * @param HttpServletResponse, String[]	 * 
	 * @return boolean
	 **/
	public boolean downloadFile(HttpServletResponse response, String[] fileName) {
		// 첫 번째 배열은 original 두 번째 배열은 saved
		boolean result = false;
		FileInputStream fis = null;
		ServletOutputStream out = null;
		
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName[0], "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fullPath = UPLOADPATH+fileName[1];
		
		try {
			fis = new FileInputStream(fullPath);
			out = response.getOutputStream();
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) try {fis.close();} catch (IOException e) {}
			if(out != null) try {out.close();} catch (IOException e) {}
			result = true;
		}
		return result;
	}
}
