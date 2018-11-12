package global.sesoc.team.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.team.dao.StreamingRepository;
import global.sesoc.team.util.FileManager;
import global.sesoc.team.vo.Table;

@Controller
public class StreamController {
		@Autowired StreamingRepository repo;
		
		@RequestMapping(value = "/chatting", method = RequestMethod.POST)
		public String enter(HttpSession session,Model model, String userId, 
				@RequestParam (value="roomNo", defaultValue="1" )String roomNo){
			session.setAttribute("userId", userId);
			session.setAttribute("roomNo", roomNo);
			return "chatting";
		}
		
		@ResponseBody
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public ArrayList<String> insert(HttpSession session, Model model, @RequestBody Table table) {
			System.out.println(table.getuserId());
			table.setRoomnum(session.getAttribute("roomNo")+"");
			int result = repo.insertContent(table);
			if(result ==1) {
				ArrayList<Table> list = repo.getRoomContent(session.getAttribute("roomNo")+"");
				ArrayList<String> messageList = new ArrayList<String>();
				for(Table a : list) {
					messageList.add(a.toString());
				}
				return messageList;
			} else{
				return null;
			}
		}
		
		@RequestMapping(value = "/refresh", method = RequestMethod.POST)
		public @ResponseBody ArrayList<String> refresh(HttpSession session, Model model) {
			ArrayList<Table> list = repo.getRoomContent(session.getAttribute("roomNo")+"");
			ArrayList<String> messageList = new ArrayList<String>();
			for(Table a : list) {
				messageList.add(a.toString());
			}
			return messageList;
		}
		
		@RequestMapping(value="/streaming", method=RequestMethod.GET)
		public String streaming(HttpSession session) {
			String userId = (String)session.getAttribute("loginId");
			System.out.println("streaming 연결아이디::"+userId);
			return "page/streaming";
		}
}
