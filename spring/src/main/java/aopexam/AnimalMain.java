package aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext
				("aopexam/animal.xml");
		Animal [] ani = new Animal[3];
	    
		//ani[0] = factory.getBean("cat", Animal.class);
		ani[0] = (Animal)factory.getBean("cat");
        ani[1] = factory.getBean("dog", Animal.class);
	    ani[2] = factory.getBean("rabbit", Animal.class);
    
	    for(Animal a : ani) {
	    	String s = a.lunch();  //aspect-around일부-lunch-around나머지
	    	System.out.println(s);//null
	    }
	}
}


/* 오늘 점심에 뭐 먹었어요?
 * 생선을 먹었습니다.
 * 냥이-생선 먹었군요.
 * 
 * 오늘 점심에 뭐 먹었어요?
사료를 먹었습니다.
강아지-사료 먹었군요.

오늘 점심에 뭐 먹었어요?
당근를 먹었습니다.
토끼-당근 먹었군요.

1.animal.xml
2.AnimalAspect.java : 메소드이름, before+after=>around 자유롭다


 */

