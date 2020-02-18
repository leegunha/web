package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 객체 변경시 코드 수정 불가피 = 결합도 높다 . coupling 높다(나쁜코드)
		// tv변수 생성 객체가 MultiTV, OtherTV 2개중1개
		// dependency: 직접 객체 생성--> 위임(다른 객체로부터 전달)
		//--> 위임(스프링)
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext
				("tvspring/tv.xml")  ; 

		//<bean id="tv" class="tvspring.OtherTV" />
		TV tv = factory.getBean("tv", TV.class);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();

		TV tv2 = factory.getBean("tv2", TV.class);
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
	}

}
