package edu.multi.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JQUERYController {
	@Autowired
	BoardDAO dao;
	
  @RequestMapping("/jquerytest")
  public String jquerytest() {
	  return "jquery";
  }
  
  @RequestMapping("/ajaxtest")
  public String ajaxtest() {
	  return "ajax";
  }
 
  @RequestMapping("/ajaxlogin")
  public String ajaxlogin(String id , String pw) {
//	  if(id.equals("ajax") && pw.equals("ajax")) {
//		  
//	  }
	  return "ajaxsuccess";
  }
  //AJAX요청 처리 응답시 강제 한글인코딩 UTF-8 설정
  @RequestMapping(value="/ajaxlogin2", 
	produces={"application/json; charset=UTF-8"}   )
  @ResponseBody  //{}
  public String ajaxlogin2(String id, String pw) {
	  boolean status = false;
	  String logintime="-";
	  if(id.equals("ajax") && pw.equals("ajax")) {
		  status = true;
		  logintime=new java.util.Date().toLocaleString();
		  
	  }
	  return 
	  "{ \"status\" :"  + status + ", \"time\":\"" + logintime + "\"}";
  }
@RequestMapping("/ajaxboard")
@ResponseBody  //모든 객체 -- JSON형식 변경 api
public BoardVO ajaxboard(int seq){
	BoardVO vo = dao.getBoardDetail(seq);
	return vo;
}

}





