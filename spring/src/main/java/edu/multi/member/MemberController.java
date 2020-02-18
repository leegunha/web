package edu.multi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
//메인화면
	@RequestMapping("/session")
	public String main(){
		return "mybatis/main";
	}
	
//로그인폼
	@RequestMapping("/session/login")
	public String loginform(){
		return "mybatis/login";
	}
//로그인폼 입력 - db member 테이블 존재 - 세션 저장	
	@RequestMapping("/session/loginprocess")
	public String loginprocess(HttpServletRequest request, String userid, String password){
		MemberVO vo = dao.selectMember(userid, password);
		HttpSession session = request.getSession();
		session.setAttribute("member", vo);
		return "mybatis/loginprocess";
	}
	@RequestMapping("/session/mypage")
	public String getMyPage() {
		
		return "mybatis/mypage";
	}
//로그아웃
	@RequestMapping("/session/logout")
	public String logout(HttpSession session) {
		//HttpSession객체 저장 정보 삭제
		//HttpSession session = request.getSession();
		//session.removeAttribute("member");
		return "mybatis/logout";
	}
//회원가입
	@RequestMapping("/session/add")
	public String add(){
		return "mybatis/add";
	
	}
	
//회원가입폼 입력
	@RequestMapping("/session/addprocess")
	public String addprocess(MemberVO vo){
		
		try{
			dao.insertMemeber(vo);
			return "mybatis/success";
		}catch (Exception e) {
			return "mybatis/fail";
		}
		
	}

//회원가입 성공
	@RequestMapping("/session/success")
	public String success(){
		return "mybatis/success";
	}
//회원가입 실패
	@RequestMapping("/session/fail")
	public String fail(){
		return "mybatis/fail";
	}

	
	
}


