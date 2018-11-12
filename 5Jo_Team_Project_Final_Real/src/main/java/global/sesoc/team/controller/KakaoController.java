package global.sesoc.team.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import global.sesoc.api.NaverAPI;
import global.sesoc.team.dao.RecipeBoardRepository;
import global.sesoc.team.vo.RecipeBoard;

@RestController
public class KakaoController {

	@Autowired
	RecipeBoardRepository repository;

	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public String kakaoAPIinit() {
		JSONObject jObject = new JSONObject();
		jObject.put("type", "text");
		return jObject.toString();
	}
	

	@RequestMapping(value = "/message", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String message(@RequestBody String content) {
		
		//papago 번역부분
		NaverAPI nAPI = new NaverAPI(); 
        String result = nAPI.APITranslateNMT(content);
    
        int result2 = result.lastIndexOf(":");
        int result3 = result.lastIndexOf("\\");
        
        String result4 = result.substring(result2+3, result3);

        
		JSONObject jobjText = new JSONObject();
		JSONObject jobjRes = new JSONObject();
		
		//재료로 레시피 검색
		RecipeBoard Lboard= repository.selectchatOne(result4);
		System.out.println(Lboard);
		
		if (Lboard != null) {
			System.out.println(Lboard.sendResult());
			jobjText.put("text", Lboard.sendResult());
			
		} if(Lboard == null) {
			jobjText.put("text", "레시피가 존재하지 않아요!ㅜ3ㅜ");
		}
		
		//안녕하면 대답하기!
/*		if (content.contains("안녕")) {
			jobjText.put("text", "안녕 하세요.");
		} if(!content.contains("안녕")) {
			jobjText.put("text", "반갑습니다.");
		}*/
		
		
		jobjRes.put("message", jobjText);
		return jobjRes.toString();
	}
}
