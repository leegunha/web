package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardlistController implements Controller {

	@Override
	public ModelAndView handleRequest
	(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
        ModelAndView mv = new ModelAndView();
        // board테이블 모든 게시물(model) :ArrayList<BoardVO>
        BoardDAO dao = new BoardDAO();
        ArrayList<BoardVO> list = dao.getList();
       mv.addObject("boardlist", list);
       mv.setViewName("boardlist");
        return mv;
	}

}





