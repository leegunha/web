package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
// a() + member.login() + b()
public class Common {
	long starttime =  System.currentTimeMillis(); //현재시각 ( 1/1000초 리턴)
 public void a() {// before
	 System.out.println("===메소드호출시각===" + new Date(starttime));
 }
 
 public void b() { //after
	 long endtime =  System.currentTimeMillis(); 
	 System.out.println("===메소드실행소요시간(1/1000초)===" 
	 + (endtime - starttime)  );
 }
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


