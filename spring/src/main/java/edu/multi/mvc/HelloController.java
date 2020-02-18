package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//<beans:bean id="hc" class="xxxx.HelloController" />
public class HelloController{
	@RequestMapping("/hello")
	//<beans:prop key="/hello">hc</beans:prop>
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		ModelAndView mv = new ModelAndView();
		//controller ---> jsp 데이터 전달=공유==Model(뷰 보여줄 데이터)용어
		mv.addObject("model", "Hello Spring (어노테이션)");//Model 세팅
		mv.setViewName("hello");// view 세팅
		return mv;
	}

}






