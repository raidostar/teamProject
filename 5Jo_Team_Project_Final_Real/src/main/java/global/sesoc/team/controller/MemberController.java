package global.sesoc.team.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.team.dao.GoogleMapRepository;
import global.sesoc.team.dao.MemberRepository;
import global.sesoc.team.util.GoogleGeocoding;
import global.sesoc.team.util.MailHandler;
import global.sesoc.team.vo.Member;

@Controller
public class MemberController {
		
	@Autowired
	MemberRepository repository;
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	GoogleMapRepository mapRepository;
	
			//아이디 중복 검사
			@ResponseBody
			@RequestMapping(value="idCheck", method=RequestMethod.GET)
			public int idCheck(String userId) {
				Member memberCheck=repository.idCheck(userId);
				if(memberCheck==null) {
					return 0;
				} else {
					return 1;
				}
			}
			
			//회원가입 처리
			@ResponseBody
			@RequestMapping(value="/join", method=RequestMethod.POST)
			public int insertMember(@RequestBody Member member, HttpSession session) throws Exception {
				System.out.println("주강호 멤버::"+member);
				int result = repository.insertMember(member);
				System.out.println("회원가입되냐::"+result);
				if(result==1) {
					session.setAttribute("loginId", member.getUserId());
					session.setAttribute("loginName", member.getUserName());
					
					MailHandler sendMail = new MailHandler(mailSender);
					sendMail.setSubject("이메일 인증");
					sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
							.append("<a href='http://localhost:8888/team/verify?emailAccount="+member.getEmailAccount()
							+"&emailDomain="+member.getEmailDomain()+"' target='_blenk'> 이메일 인증 확인</a>").toString());
					sendMail.setFrom("radiostar243@google.com", "radiostar243");
					sendMail.setTo(member.getEmailAccount()+"@"+member.getEmailDomain());
					sendMail.send();
					return 1;
				}
				else {
					System.out.println("회원가입실패");
					return 0;
				}
			}
			
			//로그인 처리 요청
			@ResponseBody
			@RequestMapping(value="login", method=RequestMethod.POST)
			public int login(@RequestBody Member member, boolean saveid, HttpServletResponse response, HttpSession session, Model model) {
				//아이디 저장하기
				if(saveid == true) {
					Cookie cookie = new Cookie("saveid", member.getUserId());
					cookie.setMaxAge(7*24*60*60);
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("saveid", null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				//DB에서 해당 사용자가 있는지 여부체크
				Member m = repository.login(member);
				System.out.println(m);
				if(m.getVerify()=='y') {
					session.setAttribute("loginId", m.getUserId());
					session.setAttribute("loginName", m.getUserName());				
					return 1;
				} else {
					return 0;
				}
			}
			
			//로그아웃
			@ResponseBody
			@RequestMapping(value="logout", method=RequestMethod.GET)
			public String logout(HttpSession session) {
				session.invalidate();
				session=null;
				return "1";
			}
			
			//링크를 눌렀을 때 처리
			@RequestMapping(value="verify", method=RequestMethod.GET)
			public String signSuccess(@RequestParam String emailAccount, @RequestParam String emailDomain) {
				System.out.println("이메일 인증 기능 처리");
				Member member = new Member();
				member.setEmailAccount(emailAccount);
				member.setEmailDomain(emailDomain);
				repository.verify(member);
				return "index";
			}

}
