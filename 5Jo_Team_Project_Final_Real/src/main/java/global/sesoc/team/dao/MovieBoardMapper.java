package global.sesoc.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.team.vo.Board;
import global.sesoc.team.vo.MovieLike;

public interface MovieBoardMapper {
	public List<Board> selectAll();
	public int insert(Board board);
	public Board selectOne(int boardnum);
	public List<Board> select(Map<String, Object> map, RowBounds rb);
	public int getTotalBoard(Map<String, String> map);
	public int updatelike (Map<String, Object> updatepoint);
	public int insertlike (MovieLike movielike);
	public MovieLike selectlike(Map<String, Object> map);
	public int deletelike (MovieLike movielike);
	/*public int updatelikem(int boardNum);*/
	public int updatehitcount(int boardNum);
	public int updateBoard(Board board);
	public int deleteBoard(int BoardNum);
	public MovieLike allpoint(int boardNum);
	public Board selectOneMovie(int best);
}