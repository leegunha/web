package annotation.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext
				("annotation/aop1/aop.xml");
		Member m = factory.getBean("member", Member.class);
		Board b = factory.getBean("board", Board.class);
		
		//공통관심=횡단관심=aspect클래스(스프링 aop : 자동 같이 실행)
		//Common c = factory.getBean("common", Common.class);

		m.login("spring");

		b.insertBoard(100);

		b.getList();

		m.logout();
		
	}

}







