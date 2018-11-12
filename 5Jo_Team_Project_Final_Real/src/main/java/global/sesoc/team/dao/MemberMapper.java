package global.sesoc.team.dao;

import java.util.List;
import global.sesoc.team.vo.Member;

public interface MemberMapper {
	public int insertMember(Member member);
	public int updateMember(Member member);
	public Member selectOneMember(Member member);
	public Member idCheck(String userId);
	public int pointGet(String userId);
	public List<Member> ranking();
	public int verify(Member member);
}
