package aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {
	@Pointcut("execution (public String aopexam.*.lunch(..))")
	public void m() {  }
	
	@Around("m()")
 public Object around(ProceedingJoinPoint p) {
		Object o = null;
	try {
	 System.out.println("오늘 점심에 뭐 먹었어요?");
	 o = p.proceed();
	 System.out.println(o + " 먹었군요.");
	 }catch(Throwable e) {   }
	 return o;
	 
 }
 //@Before("m()")
 public void before() {
	 System.out.println("오늘 점심에 뭐 먹었어요?");
 }
 //@AfterReturning("m()")
 public void after(Object ret) { //<aop:after-returning
	 System.out.println(ret + " 먹었군요.");
 }
}
