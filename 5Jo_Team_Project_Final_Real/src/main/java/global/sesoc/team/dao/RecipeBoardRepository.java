package global.sesoc.team.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.team.vo.RecipeBoard;
import global.sesoc.team.vo.Wishlist;

@Repository
public class RecipeBoardRepository {
	
	@Autowired
	SqlSession session;

	public int getTotalBoard(String searchItem, String searchWord) {
		int num=0;
		RecipeBoardMapper mapper=session.getMapper(RecipeBoardMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		num=mapper.getTotalProductsBoard(map);
		return num;
	}

	public List<RecipeBoard> select(String searchItem, String searchWord, int startRecord, int countPerPage) {
		RecipeBoardMapper mapper =session.getMapper(RecipeBoardMapper.class);
		System.out.println("특산물정보");
		RowBounds rb = new RowBounds(startRecord, countPerPage);	
		List<RecipeBoard> list = new ArrayList<RecipeBoard>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		System.out.println("2. repository");
		list=mapper.selectAll(map, rb);
		System.out.println(list +":  특산물정보");
		
		return list;
	}

	
	public RecipeBoard selecOne(int boardNum) {
		RecipeBoardMapper mapper =session.getMapper(RecipeBoardMapper.class);
		RecipeBoard board = mapper.selectOne(boardNum);
		System.out.println(board);
		return board;
	}
	
	//////////////////////////////////////강나연_0919////////////////////////////////////////////
	public int insertWishlist(Wishlist wishlist) {
		RecipeBoardMapper mapper =session.getMapper(RecipeBoardMapper.class);
		int result = mapper.insertWishlist(wishlist);
		return result;
	}
	
	public List<RecipeBoard> selectAllWL(String userId) {
		RecipeBoardMapper mapper = session.getMapper(RecipeBoardMapper.class);
		List<RecipeBoard> recipeBoard = mapper.selectAllWL(userId);
		return recipeBoard;
	}
	
	public RecipeBoard selectchatOne(String result){
		RecipeBoardMapper mapper = session.getMapper(RecipeBoardMapper.class);
		RecipeBoard chatlist = mapper.selectchatOne(result);
		return chatlist;
	}
	public int deleteWishlist(Wishlist wishlist) {
		RecipeBoardMapper mapper =session.getMapper(RecipeBoardMapper.class);
		int result = mapper.deleteWishlist(wishlist);
		return result;	
	}

	public Wishlist selectWishList(Wishlist wishlist) {
		RecipeBoardMapper mapper =session.getMapper(RecipeBoardMapper.class);
		Wishlist selectWish = mapper.selectWishList(wishlist);
		return selectWish;	
	}
	

}
