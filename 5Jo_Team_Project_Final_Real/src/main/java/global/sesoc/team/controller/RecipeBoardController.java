package global.sesoc.team.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.team.dao.RecipeBoardRepository;
import global.sesoc.team.util.PageNavigator;
import global.sesoc.team.vo.RecipeBoard;
import global.sesoc.team.vo.RecipeBoard2;
import global.sesoc.team.vo.Wishlist;

@Controller
public class RecipeBoardController {
	private final int SUCCESS = 0;
	private final int FAIL = -1;
	
	@Autowired
	RecipeBoardRepository repository;
	
	//private final String uploadPath = "/uploadPath";
	
	@RequestMapping(value = "/receiptBoard", method = RequestMethod.GET)
	@ResponseBody public Map<String, Object> receiptBoard(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchItem", defaultValue = "material") String searchItem,
			@RequestParam(value = "searchWord", defaultValue = "") String searchWord){
			int totalRecordCount = repository.getTotalBoard(searchItem, searchWord);
			System.out.println(totalRecordCount);
			Map<String, Object> map = new HashMap<>();
			PageNavigator navi = new PageNavigator(currentPage, totalRecordCount);
			List<RecipeBoard> list = repository.select(searchItem, searchWord, navi.getStartRecord(), navi.getCountPerPage());
			System.out.println(list);
			if(list==null) {
				map.put("list", list);
				return map;
			};
			System.out.println("특산물"+navi.getStartRecord());
			System.out.println("특산물"+navi.getCountPerPage());
			System.out.println("특산물"+list);
	
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
	@RequestMapping(value = "/searchRecipe", method = RequestMethod.POST)
	@ResponseBody public RecipeBoard searchRecipe2(int boardNum) {
		
		RecipeBoard board =repository.selecOne(boardNum);
		
		return board;
	}
	@RequestMapping(value = "/searchRecipe", method = RequestMethod.GET)
	@ResponseBody public RecipeBoard2 searchRecipe(int boardNum) {
		
		RecipeBoard board =repository.selecOne(boardNum);
		
		String[] material = board.getMaterial().split(" ");//재료정보
		List<String> materiall = new ArrayList<String>();//맵생성
		for(int i =0; i<material.length ; i++) {
					materiall.add(material[i]);
		};
		
		String[] amount = board.getAmount().split(" ");//재료정보
		List<String> amountt = new ArrayList<String>();//맵생성
		for(int i =0; i<amount.length ; i++) {
			amountt.add(amount[i]);
		};
		
		String[] recipeHow = board.getRecipe().split(" ");//재료정보
		List<String> recipeHoww = new ArrayList<String>();//맵생성
		for(int i =0; i<recipeHow.length ; i++) {
			recipeHoww.add(recipeHow[i]);
		};
		System.out.println(recipeHoww);
		
		RecipeBoard2  board2= new RecipeBoard2();
		board2.setBoardNum(board.getBoardNum());
		board2.setAmount(amountt);
		board2.setBoardNum(board.getBoardNum());
		board2.setTitle(board.getTitle());
		board2.setMetarial(materiall);
		board2.setRecipe(recipeHoww);
		board2.setCategory(board.getCategory());
		board2.setHitcount(board.getHitcount());
		board2.setImglink(board.getImglink());
		board2.setTips(board.getTips());
		
		System.out.println("board2 정보"+board2);
		return board2;
	}
	@RequestMapping(value = "/addwishlist", method = RequestMethod.POST)
	@ResponseBody public int addwishlist(int boardNum,HttpSession session) { // 유저아이디도 받아와야함
		String userId = (String)session.getAttribute("loginId");///////////////////로그인 후 아이디 받아오기 ///////////////
		Wishlist wishlist = new Wishlist();
		wishlist.setBoardNum(boardNum);
		wishlist.setUserId(userId);////////////////////////////////////로그인 후 변경요함///////////////////////////////
		int result =repository.insertWishlist(wishlist);
		return result;
	}

	@RequestMapping(value = "/wishlistpage", method = RequestMethod.GET)
	public String wishlistpage(){ //유저아이디도 받아와야함
		return "page/wishlistpage";
	}
	
	@RequestMapping(value = "/showlist", method = RequestMethod.POST)
	@ResponseBody public List showlist(HttpSession session){ //유저아이디도 받아와야함
		String userId = (String)session.getAttribute("loginId");///////////////////로그인 후 아이디 받아오기 ///////////////
		List<RecipeBoard> recipeBoard = repository.selectAllWL(userId);
		return recipeBoard;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(int boardNum, Model model){
		RecipeBoard wishdetail = repository.selecOne(boardNum);
		model.addAttribute("wishdetail", wishdetail);
		return "index";
	}
	
	@RequestMapping(value = "/letsgit", method = RequestMethod.GET)
	public String test123(int boardNum,Model model){
		model.addAttribute("boardNum", boardNum);
		return "page/letsgit";
	}
	
	@RequestMapping(value = "/deleteWishList", method = RequestMethod.POST)
	@ResponseBody public int deleteList(int boardNum,HttpSession session){
		String userId = (String)session.getAttribute("loginId");///////////////////로그인 후 아이디 받아오기 ///////////////
		System.out.println("wishList삭제확인");
		Wishlist wishlist = new Wishlist();
		wishlist.setBoardNum(boardNum);
		wishlist.setUserId(userId);
		int result =repository.deleteWishlist(wishlist);
		System.out.println("wishList삭제확인"+result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectWishList", method = RequestMethod.GET)
	public int selectWishList(int boardNum,HttpSession session){
		String userId = (String)session.getAttribute("loginId");///////////////////로그인 후 아이디 받아오기 ///////////////
		if(userId==null) {
			return 404;
		}
		Wishlist wishlist = new Wishlist();
		wishlist.setBoardNum(boardNum);//위시리스트 번호
		wishlist.setUserId(userId);//로그인한 사용자 아이디
		Wishlist selectWish =repository.selectWishList(wishlist);
		System.out.println("wishList검색하기"+selectWish);
	
		if(selectWish == null)
		{
			repository.insertWishlist(wishlist);
			return SUCCESS;
		}
		return FAIL;
		
	}
	@ResponseBody
	@RequestMapping(value = "/gotWishList", method = RequestMethod.GET)
	public int gotWishList(HttpSession session){
		String userId = (String)session.getAttribute("loginId");///////////////////로그인 후 아이디 받아오기 ///////////////
		if(userId==null) {
			return 404;
		}
		return SUCCESS;	
	}
}