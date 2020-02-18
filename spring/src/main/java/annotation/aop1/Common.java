package annotation.aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
// a() + member.login() + b()
import org.springframework.stereotype.Component;

@Component  //<bean id="common" class="Common" 
@Aspect         //<aop:aspect id="c" ref="common"
public class Common {
	//<aop:pointcut expression="execution (public * aop1.*.*(..))"
	//  id="pc" >
	@Pointcut("execution (public * annotation.aop1.*.*(..))")
	public void pc() {  }
	
	long starttime =  System.currentTimeMillis(); //현재시각 ( 1/1000초 리턴)
	
	//@Before("pc()") // <aop:before method="a" ref-pointcut="pc">
	public void a() {// before
	 System.out.println("===메소드호출시각===" + new Date(starttime));
	}
 
	//@After("pc()")
	public void b() { //after
	 long endtime =  System.currentTimeMillis(); 
	 System.out.println("===메소드실행소요시간(1/1000초)===" 
	 + (endtime - starttime)  );
	}
	@Around("pc()")
 public void c(ProceedingJoinPoint joinpoint) { //round: before+???? +after
	 try {
		 System.out.println("메소드수행이전");
		 Object returnvalue = joinpoint.proceed(); //pointcut 문법 선택 핵심관심 메소드 수행
		 System.out.println("리턴값=" + returnvalue);
		 
		 System.out.println("" + joinpoint.getTarget());
		 System.out.println("" + joinpoint.getArgs());
		 System.out.println("" + joinpoint.toLongString());
		 
		 System.out.println("메소드수행이후");
	 }catch(Throwable e) {
		 e.printStackTrace();//예외발생추적출력
	 }
 }
}


