package empspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory= 
				new ClassPathXmlApplicationContext
				("empspring/emp.xml");
		
		// 스프링 xml 설정내용 객체생성 : 1개 공유 : singleton방식 
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		//dao.insertEmp();
		//2
		EmpDAO dao2 = factory.getBean("dao", EmpDAO.class);
		EmpDAO dao3 = factory.getBean("dao", EmpDAO.class);
		EmpDAO dao4 = factory.getBean("dao", EmpDAO.class);
		EmpDAO dao5 = factory.getBean("dao", EmpDAO.class);
	}

}





