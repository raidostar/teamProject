package global.sesoc.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.team.vo.Board;
import global.sesoc.team.vo.MovieLike;

@Repository
public class MovieBoardRepository {

	@Autowired
	SqlSession session;
	
	public List<Board> selectAll(){
		MovieBoardMapper mapper = session.getMapper(MovieBoardMapper.class);
		List<Board> list= mapper.selectAll();
	
		return list;
	}
	
	public int insert(Board board) {
		MovieBoardMapper mapper = session.getMapper(MovieBoardMapper.class);
		int result = mapper.insert(board);
		
		return result;
	}
	
	public Board selecOne(int boardnum) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		Board board = mapper.selectOne(boardnum);
		return board;
	}
	
	public List<Board> select(String searchItem, String searchWord, int startRecord, int countPerpage){
		MovieBoardMapper mapper =session.getMapper(MovieBoardMapper.class);
		
		RowBounds rb = new RowBounds(startRecord, countPerpage);
		//offset 원점에서 얼마나 떨어져 있는가, limit 얼마만큼 갈건가,
		//전체 데이터에서 특정 포인트까지 자동으로 움직이는 기능
		
		Map<String, Object> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		System.out.println("2. repository");
		List<Board>list=mapper.select(map, rb);
		
		return list;
	}
	
	public int getTotalBoard(String searchItem, String searchWord) {
		
		int num=0;
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		Map<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		num=mapper.getTotalBoard(map);
		return num;
	}
	
	public int updatelike(Map<String, Object> updatepoint) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.updatelike(updatepoint);
		return result;
	}
	
	public int insertlike(MovieLike movielike) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.insertlike(movielike);
		return result;
	}
	
	public MovieLike selectlike(Map map){
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		MovieLike movielike = mapper.selectlike(map);
		return movielike;
	}
	
	public int deletelike(MovieLike movielike) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.deletelike(movielike);
		return result;
	}
	
/*	public int updatelikem(int boardNum) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.updatelikem(boardNum);
		return result;
	}*/
	
	public int updatehitcount(int boardNum) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.updatehitcount(boardNum);
		return result;
	}
	
	public int updateBoard(Board board) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.updateBoard(board);
		return result;
	}
	
	public int deleteBoard(int boardNum) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		int result = mapper.deleteBoard(boardNum);
		return result;
	}
	
	public MovieLike allpoint(int boardNum) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		MovieLike allpoint = mapper.allpoint(boardNum);
		return allpoint;
	}
	
	public Board selectOneMovie(int best) {
		MovieBoardMapper mapper=session.getMapper(MovieBoardMapper.class);
		Board board = mapper.selectOneMovie(best);
		return board;
	}
}
