package test2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
	@Autowired
	EmpService service ;//@Service("service")
	
//mybatis emp2.selectall 매핑 sql 실행:List<EmpVO2>
	@RequestMapping("/getall_emp2")
	public ModelAndView getAllEmp2() {
		
		//프로퍼티 정보 확인
//	    Properties sysprops = System.getProperties();
//	    for (Enumeration e = sysprops.propertyNames(); e.hasMoreElements();) {
//	      String key = (String) e.nextElement();
//	      String value = sysprops.getProperty(key);
//	      System.out.println(key + "=" + value);
//	    }


	
	
		//로그기록위한 부분
		//log4j.properties 경로를 절대경로로 구현
//		File home = new File("G:/backup/kitri_2019/workspace-home");
//		File target = new File(home, "/myspring/src/main/java/log4j.properties");
//		System.out.println(target.exists());	
//		System.out.println(target.getAbsolutePath());
//		PropertyConfigurator.configure(target.getAbsolutePath());
		
		
		System.out.println(111);
		List<EmpVO2> list = service.getEmpList2();
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp2list", list);
		mav.setViewName("/mybatis/getall_emp2");
		return mav;
	}
	
//	@RequestMapping(value="/insertemp", 
//			method=RequestMethod.GET)
	//메소드:last_name(not null),
	//email(unique),
	//job_id,department_id:JOBS, DEPARTMENTS 테이블 참조
	//form 생성:jsp
	
//	@RequestMapping(value="/insertemp", 
//	method=RequestMethod.POST)
	//메소드:  emp.insertWithSelectKey id 매핑 sql 실행
	// @RequestMapping("/getall_emp2") 메소드 리다이렉트 
	
	/*bluejeansh@hanmail.net
	MyController.java + mybatis/xxxx.jsp 
	==> spring_mybatis.zip 
	으로 압축하여 
	bluejeansh@hanmail.net로 전송
	*/
}





