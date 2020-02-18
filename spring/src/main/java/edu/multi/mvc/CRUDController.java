package edu.multi.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {
	Map<String, String> map = new HashMap<String, String>();
	
	@RequestMapping(value="/crud/start")
	public void start() {
		System.out.println("===홈페이지 첫 화면을 보여줍니다===");
		map.put("kitri", "김유정");
		map.put("hr", "오정임");
		map.put("spring", "신용권");	
		//뷰 url동일
	}
	
	@RequestMapping(value="/crud/list")
	public ModelAndView listMember() {
		System.out.println("===회원 리스트입니다===");
		ModelAndView mv = new ModelAndView();
		mv.addObject("members", map);
		return mv;// 뷰는 url동일
	}
	
@RequestMapping(value="/crud/add")
public String addMember() {
	System.out.println("===회원가입합니다===");
	map.put("new", "신규회원");
	return "crud/addview";
}

@RequestMapping(value="/crud/delete")
public String deleteMember() {
	System.out.println("===회원 탈퇴합니다===");
	map.remove("kitri");
	//return "crud/list";//url 그대로.
	return "redirect:/crud/list";//url도 변경.
}

@RequestMapping(value="/crud/update")
public  Map<String, String>  updateMember() {//파라미터들을 map형태로 저장
	System.out.println("===회원  정보 수정합니다===");
	//map.put(id, name);
	
	Map<String, String> modelMap = new HashMap<String, String>();
	modelMap.put("id", "수정할 id를 입력하세요.");
	modelMap.put("name", "수정할 이름을 입력하세요");			
	modelMap.put("email", "수정할 이메일은 xxx@yyy.com의 형식입니다.");			
	return modelMap;// 뷰는 url동일
}

//@ModelAttribute("loginid")
//public LoginVO getID() {
//	return new LoginVO("기본","기본");
//}
//
////  id 파라미터 미입력시에도 "로그인회원님"
//@RequestMapping("/login")
//public void login(LoginVO vo) {
//	System.out.println(getID() == vo);
//}
}