package global.sesoc.team.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.team.dao.GoogleMapRepository;
import global.sesoc.team.util.GoogleGeocoding;

@Controller
public class HomeController {
	@Autowired
	GoogleMapRepository mapRepository;
	
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Model model) {
	 /*  String location = "1830045";
	   String loc = new GoogleGeocoding().getLocationByAddress(location);
	   String[] coord = loc.split(",");
	   model.addAttribute("coord0", coord[0]);
	   model.addAttribute("coord1", coord[1]);*/
/*		String loginId = (String)session.getAttribute("loginId");
		System.out.println("로그인하자"+loginId);
		  String location = mapRepository.userHome(loginId);
		  String loc = new GoogleGeocoding().getLocationByAddress(location);
		  String[] coord = loc.split(",");
		  model.addAttribute("coord0", coord[0]);
		  model.addAttribute("coord1", coord[1]);*/
	 

      return "index";
   }
   
   @RequestMapping(value="/showMap", method=RequestMethod.GET)
   String showMap(Model model, HttpSession session) {
/*	   String location = "1830045";
	   String loc = new GoogleGeocoding().getLocationByAddress(location);
	   String[] coord = loc.split(",");
	   model.addAttribute("coord0", coord[0]);
	   model.addAttribute("coord1", coord[1]);*/
		String loginId = (String) session.getAttribute("loginId");
		System.out.println("로그인하자" + loginId);
		String location = mapRepository.userHome(loginId);
		String loc = new GoogleGeocoding().getLocationByAddress(location);
		String[] coord = loc.split(",");
		model.addAttribute("coord0", coord[0]);
		model.addAttribute("coord1", coord[1]);
	   
	   return "page/page5";
   }
}