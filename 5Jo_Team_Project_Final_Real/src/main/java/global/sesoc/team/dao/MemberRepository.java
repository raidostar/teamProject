package global.sesoc.team.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.team.vo.Member;

@Repository
public class MemberRepository {

	@Autowired
	SqlSession session;
	
			//회원가입
			public int insertMember(Member member) {
				//sqlSession필요
				MemberMapper mapper = session.getMapper(MemberMapper.class);
				int result = mapper.insertMember(member);
				System.out.println("회원가입여부를 가림::"+result);
				return result;
			}
			//회원정보수정
			public int update(Member member) {
				MemberMapper mapper = session.getMapper(MemberMapper.class);
				int result = mapper.updateMember(member);
				return result;
			}
			//아이디 중복 체크
			public Member idCheck(String userId) {
				MemberMapper mapper = session.getMapper(MemberMapper.class);
				Member idCheck= mapper.idCheck(userId);
				return idCheck;
			}
			//로그인
			public Member login(Member member) {
				MemberMapper mapper = session.getMapper(MemberMapper.class);
				Member m= mapper.selectOneMember(member);					
				return m;
			}
			//포인트 획득
			public int pointGet(String userid) {					
				MemberMapper mapper = session.getMapper(MemberMapper.class);					
				int result = mapper.pointGet(userid);					
				return result;
			}
			//이메일인증
			public int verify(Member member) {
				MemberMapper mapper = session.getMapper(MemberMapper.class);
				int result = mapper.verify(member);
				return result;
			}
}
