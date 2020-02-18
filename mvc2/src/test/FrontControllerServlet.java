package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/front")  3.0이상 
public class FrontControllerServlet extends HttpServlet {
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//web.xml : '/'  -> FrontControllerServlet
		// 1.모든 요청 FrontControllerServlet
		// 2. uri 가장 뒤 요소 분석 http:...../hello
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> FrontControllerServlet </h1>");
		out.println(request.getRequestURL());
		out.println(request.getRequestURI());
		String s[] = request.getRequestURI().split("/");
		out.println("<h1>"+s[s.length-1]+"</h1>");
		//3. hello - -MVC--> SPRING 내부환경 이해 로직 
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(s[s.length-1]);
		String viewname = controller.handleRequest(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher
				          (viewname);
		rd.forward(request, response);
	}

}







