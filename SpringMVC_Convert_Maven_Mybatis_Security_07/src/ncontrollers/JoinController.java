package ncontrollers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Member;
import dao.MemberDao;

@Controller
@RequestMapping("/joinus/") //   /joinus/join.htm
public class JoinController {
  
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="join.htm" , method=RequestMethod.GET)
	public String join(){
		System.out.println("회원가입 페이지 요청");
		
		//이전
		//return "join.jsp";
		
		//Tiles
		return "joinus.join"; //{1}.{2}
	}
	
	@RequestMapping(value="join.htm" , method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException{
		//가입처리 (DAO 단)
		System.out.println("회원가입");
		System.out.println(member.toString());
		memberDao.insert(member);
		return "redirect:../index.htm"; //수정 요망(주의 사항)
	}
	
	//login page
	@RequestMapping(value="login.htm" , method=RequestMethod.GET)
	public String login(){
		return "joinus.login";
	}
	
}
