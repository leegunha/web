package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//Command패턴
public class HelloController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		ModelAndView mv = new ModelAndView();
		//controller ---> jsp 데이터 전달=공유==Model(뷰 보여줄 데이터)용어
		mv.addObject("model", "Hello Spring");//Model 세팅
		mv.setViewName("hello");// view 세팅
		return mv;
	}

}






