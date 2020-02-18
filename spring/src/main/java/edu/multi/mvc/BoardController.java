//package edu.multi.mvc;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class BoardController{
//	@Autowired 
//	//1.<beans:bean id="dao" class="xxx.BoardDAO" 
//	//2. @Repository("dao") class BoardDAO
//	BoardDAO dao;
//
//	@RequestMapping("/boardlist")
//	public ModelAndView handleRequest
//	(HttpServletRequest request, HttpServletResponse response) 
//			throws Exception {
//        ModelAndView mv = new ModelAndView();
//        // board테이블 모든 게시물(model) :ArrayList<BoardVO>
//        ArrayList<BoardVO> list = dao.getList();
//       mv.addObject("list", list);
//       mv.setViewName("boardlist");
//        return mv;
//	}
//	
//	//1개 게시물 글쓰기 폼 화면
//	@RequestMapping(value="/boardinsert", method = RequestMethod.GET)
//    public String insertBoardForm() {
//    	return "boardinsertform";
//    }
//	//글쓴 내용 전달받아서 board 테이블 저장 
//	@RequestMapping(value="/boardinsert", method = RequestMethod.POST)	
//    public String insertBoardResult(@ModelAttribute("vo") BoardVO vo) {
//    		//System.out.println(vo.getContents());
//		    int result = dao.insertBoard(vo);//제목,내용,작성자,암호입력 저장 상태 객체
//		   if(result == 1) {
//			   System.out.println("정상 insert");
//		   }
//		   else {
//			   System.out.println("비정상 insert");
//		   }
//		    return "redirect:/boardlist";
//    }
//	//a href="http://localhost:8081/mvc/boarddetail?seq=${vo.seq }" >
//	@RequestMapping("/boarddetail")
//	public ModelAndView getBoardDetail(int seq){
//		BoardVO vo = dao.getBoardDetail(seq);//board테이블 seq컬럼 primary key(unique, not null)
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("detail", vo);
//		return mv;
//	}
//
//	@RequestMapping("/boardupdate")
//	public String updateBoard
//			//(BoardVO vo) 또는 (int seq, String title, String contents, String writer)  {
//			//dao.updateBoard(seq, title, contents, writer); 또는
//			//dao.updateBoard(vo);
//			return "redirect:/boardlist"; //update결과포함조회
////	sql
////	     update 테이블명 set 변경컬럼명=변경값 , , , 
////	     where 변경레코드조건식
////	     update board set title =? , contents=?, writer=? where seq=?
//	}
//	@RequestMapping("/boarddelete")
//	public String deleteBoard(int seq){
//	 dao.deleteBoard(seq);
//	 //  sql  delete board where seq=?
//	return "redirect:/boardlist"; //delete결과포함조회
//	}
//}