package com.sds.date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	protected void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet");
		response.setCharacterEncoding("euc-kr");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		PrintWriter pw = response.getWriter();
		pw.write("<html><head><title> 서버측 시간을 얻어서 씁니다. </title></head></html>");
		pw.write("<body><h1>Hello sevelet</h1>");
		pw.write("<h2>현재 시간은");
		pw.write(Integer.toString(hour)+"시");
	}

}
