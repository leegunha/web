package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Command패턴
public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		//servlet ---> jsp 데이터 전달=공유
		request.setAttribute("model", "Hello Spring");
		return "/hello.jsp";
		//request.getAttribute("model")
		//${model}
	}

}






