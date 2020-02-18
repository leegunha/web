package edu.multi.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.BoardVO;

@Controller
public class AjaxController {
	@RequestMapping("/ajax/list")
	public ModelAndView getMap() {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		//list.add(new BoardVO(1, "제목1","내용1","kitri","2020-01016" ,1234,0));
		//list.add(new BoardVO(2, "제목2","내용2","kitri","2020-01016" ,1234,0));
		//list.add(new BoardVO(3, "제목3","내용3","kitri","2020-01016" ,1234,0));

		mav.addObject("list", list);
		return mav;

	}
	@RequestMapping(value="/ajax/detail"
			,
			 produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public BoardVO getDetail(int seq) {
		System.out.println(seq+" 값 확인");
		return new BoardVO();
		//return new BoardVO(1, "제목1","내용1","kitri","2020-01016" ,1234,0);
	}
}
