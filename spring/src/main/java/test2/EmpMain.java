package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

	
//mybatis.jar + ojdbc6.jar
public class EmpMain {
public static void main(String args[]) throws Exception {
	//con생성==MYBATIS 커넥션풀- CON 빌려-반납
	//pt생성:sql정의==XML 파일 ID값
	//XML : RESULTTYPE="...EmpVO"
	
	//로그기록위한 부분
	//log4j.properties 경로를 절대경로로 구현
//File f = new File("src/main/java/log4j.properties");
//	System.out.println(f.exists());	
//	System.out.println(f.getAbsolutePath());
//	PropertyConfigurator.configure(f.getAbsolutePath());

		
	SqlSessionFactoryBuilder builder
	= new SqlSessionFactoryBuilder();

	// connectionpool객체, sql-mapping파일객체
	SqlSessionFactory factory =	builder.build
	(
	Resources.getResourceAsReader
	("mybatis/mybatis-config.xml")
	);

	//environment 여러개면 factory도 여러개
/*	SqlSessionFactory factory =	builder.build
	(
	Resources.getResourceAsReader
	("mybatis/mybatis-config.xml"), "다른 environemt 설정이름"
	);
*/	
	SqlSession session = factory.openSession();//Connection
	//true : auto commit, false 또는 없으면  수동 commit
	System.out.println(session.getConnection().getAutoCommit());
	////////////////////////////////////////////
	// 스프링 di : 생성자 매개변수 객체 전달 
	// 멤버변수 객체 선언 / setter 메소드 매개변수 전달
	
	EmpDAO dao = new EmpDAO();
	dao.setSession(session);
	EmpService service = new EmpServiceImpl();
	((EmpServiceImpl)service).setDao(dao);

	//test1:모든 테이블 레코드 리스트 리턴 조회
//	List<EmpVO> list = service.getEmpList();
//	
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}
	
	//test1-2:테이블 where절에 > 포함 조회	
//	List<EmpVO> list = service.getEmpWhereList();
//	
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}

	// SQL 특수기호"< >"  원래 의미 사용:cdata섹션
//	List<EmpVO> list = service.selectList(200);
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}
	
	
	//test2:조건 만족 레코드 조회
//	EmpVO vo = service.getEmpOne();
//	System.out.println(vo);
	
	//test3 : EmpVO(=emp) 객체 저장
/*	EmpVO vo = new EmpVO();
	vo.setEmployee_id(1001);//PK
	vo.setLast_name("도경석");
	vo.setEmail("do2@kitri.com");//유니크
	//vo.setHire_date(hire_date);
	vo.setJob_id("IT_PROG");//JOBS테이블존재
	vo.setDepartment_id(50);//departments테이블존재
	service.insertEmp(vo);
	session.commit(); //수동 커밋이므로 commit 해야 함
	System.out.println("===insert 완료===");*/
	
	//test4: 1000번 사번 사원   
	//부서코드:50->80
	//이메일 : do@kitri.com->kyung@korea.com
	//update 파라미터객체 vo2
/*	EmpVO vo2 = new EmpVO();
	vo2.setEmployee_id(1000);
	vo2.setDepartment_id(80);
	vo2.setEmail("kyung@kore.com");
	service.updateEmp(vo2);
	//service.메소드추가
	//public void updateEmp(EmpVO vo)
	session.commit();
	System.out.println("===update 완료===");*/
	
	//test5 : delete
	//1000 사번 삭제
	//emplolyees 테이블 사원 등록 : 
	// job_history 테이블 등록 :부서 변경 
	//1000 사번 : employees / job_history 테이블
	// 1> job_history 테이블 1000번 삭제:자식
	// 2> employees 테이블 1000번 삭제:부모
	
/*	service.deleteEmp(1000);
 *  session.commit();
	System.out.println("===delete 완료===");*/
	
	//test6 : 시퀀스 자동증가값 insert
/*	EmpVO vo3 = new EmpVO();
	//employee_id:자동증가(103-104), hire_date:sysdate
	vo3.setLast_name("주");
	vo3.setEmail("joo1@aaa.com");//중복x
	vo3.setJob_id("IT_PROG");
	vo3.setDepartment_id(100);
	
	service.insertEmpWithSelectKey(vo3);
	session.commit();
	System.out.println("===insert(자동증가키) 완료===");*/
	
	//test7 : 
	//parameterType="int"
	//parameterType="string"
	//parameterType="EmpVO"-여러개 파라미터 VO 변수들 
	// VO 사용하지 않고 INT 여러개 
	// 배열/List/Map : collection
	
/*	Map map = new  HashMap();
	map.put("a", "김경석");
	map.put("b", 1001);
	map.put("c", 1002);
	service.updateWithMap(map);
	session.commit();
	System.out.println("===update 완료===");*/
	
	
	//employees 테이블 급여 많은 순서로 정렬했을 때
	//6-10번 사원 조회
//	int[] array = {6, 10};
//	List<EmpVO> list = service.selectWithRownumArray(array);
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}
    

	
	// forEach 태그 사용 예제
//	int[] array = {20, 80, 50};
//	List<EmpVO> list = service.selectWithArray(array);
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}
	
//	List<Integer> intList = new ArrayList<Integer>();
//	intList.add(20);
//	intList.add(50);
//	intList.add(80);
//	List<EmpVO> list = service.selectWithList(intList);
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}
	
	//if 태그 조건문 예제 실습
//	Map<String, String> map = 
//			new HashMap<String, String>();
//	map.put("column_name", "last_name");
//	//map.put("column_name", "first_name");//으로도 변경하여 테스트
//	map.put("column_value", "Bell");
//	//where last_name = 'Bell'
//	List<EmpVO> list = service.selectWithMap(map);
//	for(EmpVO vo : list) {
//		System.out.println(vo);
//	}

	//Map  예제 실습 2
	Map<String, ArrayList<String>> map = 
			new HashMap<String, ArrayList<String>>();
	
	ArrayList<String> namelist = new ArrayList<String>();
	namelist.add("last_name");
	namelist.add("first_name");
	map.put("column_name", namelist);
	
	ArrayList<String> valuelist = new ArrayList<String>();
	valuelist.add("Bell");
	valuelist.add("King");
	map.put("column_value", valuelist);

	List<EmpVO> list = service.selectWithMap(map);
	for(EmpVO vo : list) {
		System.out.println(vo);
	}
	
	//EmpVO2 객체 SQL 실행 결과 매핑 예제
//	List<EmpVO2> list = service.getEmpList2();
//	
//	for(EmpVO2 vo2 : list) {
//		System.out.println(vo2);
//	}
}
}









