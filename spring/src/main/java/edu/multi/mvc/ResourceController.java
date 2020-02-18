//package edu.multi.mvc;
//
//import java.util.Date;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class ResourceController {
//@RequestMapping("/resourcetest")
//public String test() {
//	return "resource";
//}
//
//@RequestMapping("/ajaxlogin")
//@ResponseBody
//public String ajaxlogin(String id, String pw) {
//	if(id.equals("ajax")&&pw.equals("ajax")) {
//	String now = new Date().toString();
//	return "{\"status\":true, \"time\":\""+now+"\"}";
//	}
//	return "{\"status\":false, \"time\":\"==\"}";
//}
//
//@RequestMapping("/ajaxboard")
//@ResponseBody
//public BoardVO ajaxboard(int seq) {
//BoardDAO dao = new BoardDAO();
//BoardVO vo = dao.getBoardDetail(seq);
//return vo;
//}
//}
//
//
//
//
//
//
