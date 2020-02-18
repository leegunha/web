package annotation.empspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//<bean id="dao" class="EmpDAO" >

@Repository("dao")
public class EmpDAO {
//<proprty name="vo" ref="vo" 
	@Autowired
	EmpVO vo;
	
//new EmpDAO() 스프링 요청 XML 태그<bean id="" class="xxx.EmpDAO"
	EmpDAO(){
		System.out.println("EmpDAO 생성자 호출");
	}
	
	public void insertEmp() {
//spring 요청 - EmpVO 객체 1개 생성(김사원 10000 교육부)
      System.out.println(vo.getName() + " 사원은 " 
+ vo.getSalary() + " 급여를 받으며"
+ vo.getDeptname() + " 부서에 근무합니다.");
		
	}
}






