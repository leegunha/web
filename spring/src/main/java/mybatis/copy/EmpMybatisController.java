package mybatis.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpMybatisController {
	@Autowired
	EmpDAO dao ;
	
	@RequestMapping("/mybatis/emplist")
public ModelAndView getAllEmp() {
	ModelAndView mv= new ModelAndView();
	List<EmpVO> list = dao.getAllEmp();
	mv.addObject("list", list);
	return mv;
}
}
