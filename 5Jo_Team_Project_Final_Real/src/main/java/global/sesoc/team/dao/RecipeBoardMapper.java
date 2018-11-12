package global.sesoc.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.team.vo.RecipeBoard;
import global.sesoc.team.vo.Wishlist;

public interface RecipeBoardMapper {

	public int getTotalProductsBoard(Map<String, String> map);

	public List<RecipeBoard> selectAll(Map<String, Object> map, RowBounds rb);

	public RecipeBoard selectOne(int boardNum);

	public int insertWishlist(Wishlist wishlist);

	public List<RecipeBoard> selectAllWL(String userId);
	
	public RecipeBoard selectchatOne(String result);
	
	public int deleteWishlist(Wishlist wishlist);

	public Wishlist selectWishList(Wishlist wishlist);

}