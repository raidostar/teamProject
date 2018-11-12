package global.sesoc.team.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.team.vo.Table;

@Repository
public class StreamingRepository {
	@Autowired SqlSession session;

	public ArrayList<Table> getRoomContent(String roomNo) {
		ArrayList<Table> list = null;
		StreamMapper map = null;
		try {
			map = session.getMapper(StreamMapper.class);
			list = map.getRoomContent(roomNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertContent(Table table) {
		StreamMapper map = null;
		int re = 0;
		try {
			map = session.getMapper(StreamMapper.class);
			re = map.insertContent(table);
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return re;
	}	
}
