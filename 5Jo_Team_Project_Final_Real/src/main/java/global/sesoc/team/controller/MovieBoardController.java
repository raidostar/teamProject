package global.sesoc.team.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.team.dao.MovieBoardRepository;
import global.sesoc.team.util.FileService;
import global.sesoc.team.util.PageNavigator;
import global.sesoc.team.vo.Board;
import global.sesoc.team.vo.MovieLike;

@Controller
public class MovieBoardController {
	
	@Autowired
	MovieBoardRepository repository;
	
	final String uploadPath = "/uploadPath";
	
	@RequestMapping(value = "/movieBoard", method = RequestMethod.GET)
	@ResponseBody public Map<String, Object> movieBoard(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchItem", defaultValue = "title") String searchItem,
			@RequestParam(value = "searchWord", defaultValue = "") String searchWord){
		
			int totalRecordCount = repository.getTotalBoard(searchItem, searchWord);
			System.out.println(totalRecordCount);//////////////////////
			Map<String, Object> map = new HashMap<>();
			PageNavigator navi = new PageNavigator(currentPage, totalRecordCount);
			List<Board> list = repository.select(searchItem, searchWord, navi.getStartRecord(), navi.getCountPerPage());
			System.out.println(navi.getStartRecord());
			System.out.println(navi.getCountPerPage());
			System.out.println(list);/////////////////////////
	
			map.put("navi", navi);
			map.put("totalRecordCount", totalRecordCount); // 총 페이지의 숫자
			map.put("currentPage", currentPage); // 지금 요청한 페이지
	
			map.put("list", list);// 전체 게시글 목록
	
			///////////// 검색어를 이용한 검색!//////////////////
			map.put("searchItem", searchItem); // 검색한 속성
			map.put("searchWord", searchWord); // 검색한 영역
			System.out.println(searchItem + ", " + searchWord); // 검색 잘 되는지 확인용
	
		//List<Board> list = repository.selectAll();
			System.out.println(map);
		
		return map;
	}
	
	@RequestMapping(value = "/MovieboardWrite", method = RequestMethod.GET)
	public String MovieboardWrite(){
		return "page/movieBoardWrite";
	}
	
	@RequestMapping(value="/boardWrite",method=RequestMethod.POST)
	public String boardWrite(Board board, MultipartFile upload, HttpSession session) {
	
		String userId = (String)session.getAttribute("loginId");
		System.out.println(board);
		
		if(!upload.isEmpty()){
			String saveFile = FileService.saveFile(upload, uploadPath);
			String originalFile = upload.getOriginalFilename();
			
			board.setUserId(userId); 
			board.setOriginalFile(originalFile);
			board.setSavedFile(saveFile);
		}
		repository.insert(board);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/MovieboardUpdate", method = RequestMethod.GET)
	public String MovieboardUpdate(int boardNum, Model model) {
		Board board = repository.selecOne(boardNum);
		
		model.addAttribute("board", board);
		
		return "page/movieBoardUpdate";
	}
	
	
	
	@RequestMapping(value = "/MovieboardDelete", method = RequestMethod.POST)
	@ResponseBody public int MovieboardDelete(int boardNum) {
		int result = repository.deleteBoard(boardNum);
		
		return result;
	}	
	
	
	
	@RequestMapping(value = "/MovieboardUpdate", method = RequestMethod.POST)
	public String MovieboardUpdate(int boardNum, String title, String content, MultipartFile upload) {
		Board board = new Board();
		System.out.println("1 :::::" + boardNum);

		board = repository.selecOne(boardNum);
		System.out.println("2:::::" + board);
		if (board.getSavedFile() != null) {
			String fullPath = uploadPath + "/" + board.getSavedFile();
			FileService.deleteFile(fullPath);
		} // 파일 삭제
		Board b = new Board();
		if (!upload.isEmpty()) {
			String savedFile = FileService.saveFile(upload, uploadPath);
			String originalFile = upload.getOriginalFilename();
			b.setSavedFile(savedFile);
			b.setOriginalFile(originalFile);
		}
		b.setBoardNum(boardNum);
		b.setTitle(title);
		b.setContent(content);
		
		System.out.println("3:::::::"+ board);
		
		System.out.println("updateForm 요청");
		System.out.println(boardNum);
		int result = repository.updateBoard(b);
		if (result == 1) {
			System.out.println("update성공!!");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/bestmovie", method = RequestMethod.GET)
	public String bestmovie(int best, HttpServletResponse response) {
		System.out.println("download"+best);
		Board board = repository.selectOneMovie(best);

		String originalfile = board.getOriginalFile();
		String fullPath = uploadPath + "/" + board.getSavedFile();

		try {
			response.setHeader("Content-Disposition",
					" attachment;filename=" + URLEncoder.encode(originalfile, "UTF-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		FileInputStream fin = null;
		ServletOutputStream fileout = null;
		
		try {
			fin = new FileInputStream(fullPath);
			fileout = response.getOutputStream(); 
			
			FileCopyUtils.copy(fin, fileout);

			fin.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(int boardNum, HttpServletResponse response) {
		System.out.println("download"+boardNum);
		Board board = repository.selecOne(boardNum);

		String originalfile = board.getOriginalFile();
		String fullPath = uploadPath + "/" + board.getSavedFile();

		try {
			response.setHeader("Content-Disposition",
					" attachment;filename=" + URLEncoder.encode(originalfile, "UTF-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		FileInputStream fin = null;
		ServletOutputStream fileout = null;
		
		try {
			fin = new FileInputStream(fullPath);
			fileout = response.getOutputStream(); 
			
			FileCopyUtils.copy(fin, fileout);

			fin.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	@RequestMapping(value = "/movieDtailOne", method = RequestMethod.POST)
	@ResponseBody public Board movieDtailOne(int boardNum) {
		System.out.println("moviedatail"+boardNum);
		repository.updatehitcount(boardNum);
		Board board5 = repository.selecOne(boardNum); //보드 받아옴
		
		return board5;
	}

	@RequestMapping(value = "/addlike", method = RequestMethod.POST)
	@ResponseBody public Board addlike(int boardNum,HttpSession session) {
		System.out.println(boardNum);
		
		MovieLike movielike = new MovieLike();
		movielike.setBoardNum(boardNum);
		String userId = (String)session.getAttribute("loginId");
		movielike.setUserId(userId);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardNum", boardNum);
		map.put("userId", userId);
		Map<String, Object> point = new HashMap<String, Object>();
		
		MovieLike selectmovie = repository.selectlike(map);
		
		System.out.println(selectmovie);
		
		if(selectmovie == null) { // 좋아요에 없다!
			movielike.setPoint(1);
			int insertresult = repository.insertlike(movielike); //1
			MovieLike like = repository.allpoint(boardNum);

			int likepoint = like.getPoint();
			point.put("boardNum", boardNum);
			point.put("point", likepoint);
			
			int result4 = repository.updatelike(point);
			System.out.println(result4);
			Board board = repository.selecOne(boardNum);
			System.out.println(board);
			
			board.setLike(false);
			
			return board;
			
		}else { // 좋아요에 있다!
			
			int result1 = repository.deletelike(movielike); // 테이블에서 삭제
			MovieLike like = repository.allpoint(boardNum);
			int likepoint = 0;
			
			if(like == null) {
				likepoint = 0;
				point.put("boardNum", boardNum);
				point.put("point", likepoint);
			}else {
				likepoint = like.getPoint();
				point.put("boardNum", boardNum);
				point.put("point", likepoint);
			}
			
			int result4 = repository.updatelike(point);
			System.out.println(result4);
			Board board = repository.selecOne(boardNum); // 그 테이블 검색 
			board.setLike(true);
			return board;
		}
	}
}