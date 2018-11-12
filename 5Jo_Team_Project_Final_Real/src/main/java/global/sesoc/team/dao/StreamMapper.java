package global.sesoc.team.dao;

import java.util.ArrayList;

import global.sesoc.team.vo.Table;

public interface StreamMapper {

	public ArrayList<Table> getRoomContent(String roomNo);

	public int insertContent(Table table);

}
