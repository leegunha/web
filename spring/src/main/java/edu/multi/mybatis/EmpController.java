package edu.multi.mybatis;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
    @Autowired
	EmpDAO dao;
	
	@RequestMapping("/mybatis/emplist")
	public ModelAndView getAllEmp(){
		//employees 테이블 모든 레코드 조회
		//List<EmpVO>--MODEL
		//view 결정.
		List<EmpVO> list = dao.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/mybatis/detailemp")
	public ModelAndView getDetailEmp(int employee_id){
		EmpVO vo = dao.getOneEmp(employee_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", vo);
		
		return mv;
	}
	
	//새로운 사원 등록 , 수정 , 삭제
	
	
	@RequestMapping("/mybatis/pagingemplist")
	//employees 테이블 존재 레코드갯수 페이지번호들 생성
	//1. select count(*) from employees
	// mybatis - emp-mapping.xml
	public ModelAndView getCntEmp(){
		int count = dao.getCountEmp();
		int cntPerPage = 10;
		int totalPage = 0;
		if(count % cntPerPage == 0) {
			totalPage = count / cntPerPage;//  108 / 10 + 1
		}
		else {
			totalPage = count / cntPerPage + 1;// 100 / 10 + 1
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPage", totalPage);
		return mv;
	}

	@RequestMapping("/mybatis/pagingemplist2")
	public ModelAndView getPagingEmpList(int pagenum) {
		int cntPerPage = 10;
		int start = (pagenum-1) *cntPerPage + 1;
		int end = pagenum * cntPerPage;
		int param []  = new	int[2];
		param[0] = start;
		param[1] = end;
		List<EmpVO> paginglist = dao.pagingEmp(param);
		ModelAndView mv = new ModelAndView();
		mv.addObject("paginglist", paginglist);
		return mv;
	}

	@RequestMapping(value="/mybatis/login", method=RequestMethod.GET)
	public String loginform() {
		return "mybatis/loginform";
	}
	
	@RequestMapping(value="/mybatis/login", method=RequestMethod.POST)
	public String loginresult
	(HttpServletRequest request, int employee_id) {
		EmpVO vo = dao.getOneEmp(employee_id);
		HttpSession session = request.getSession();
		session.setAttribute("login", vo);
		return "mybatis/loginresult";
	}
	@RequestMapping(value="/mybatis/mypage")
	public String mypage() {

		return "mybatis/mypage";
	}
	@RequestMapping(value="/mybatis/logout")
	public String logout() {
       
		return "mybatis/logout";
	}
}





