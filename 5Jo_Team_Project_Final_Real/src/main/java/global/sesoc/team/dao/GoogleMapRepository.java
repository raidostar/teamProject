package global.sesoc.team.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoogleMapRepository {
	@Autowired
	SqlSession sqlSession;

	public String userHome(String loginId) {
		GoogleMapMapper mapper = sqlSession.getMapper(GoogleMapMapper.class);
		String location = mapper.userHome(loginId);
		System.out.println(location);
		
		return location;
	}
	
}
