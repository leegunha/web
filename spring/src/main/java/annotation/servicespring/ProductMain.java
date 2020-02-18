package annotation.servicespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext
				("annotation/servicespring/product.xml");
	//no sale
		ProductService service = factory.getBean("service1", ProductService.class);
		ProductVO vo = service.sell();
        System.out.println(vo);
  //12월
		ProductService service2 = factory.getBean("service2", ProductService.class);
		ProductVO vo2 = service2.sell();
        System.out.println(vo2);
    //5월    
		ProductService service3 = factory.getBean("service3", ProductService.class);
		ProductVO vo3 = service3.sell();
        System.out.println(vo3);
	}

}
