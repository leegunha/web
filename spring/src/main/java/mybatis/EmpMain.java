package mybatis;

// 브라우저 내부 여러 서블릿/jsp 객체 공유 : session(HttpSession타입) 
// spring mvc : session

//mybatis : SqlSession타입 = (jdbc Connection)

// db 
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {
		//1.
		SqlSessionFactoryBuilder builder
		= new SqlSessionFactoryBuilder();
		//2. SqlSessionFactory = 연결 설정파일 읽어라 
		// sql 매핑 파일명
		SqlSessionFactory factory
		= builder.build
		(
		Resources.getResourceAsReader("mybatis/mybatis-config.xml")
		);
		//3. SqlSession = jdbc Connection 유사 = 연결 생성
		//SqlSession session = factory.openSession();
		//1. 자동 commit처리 x
		
		SqlSession session = factory.openSession(true);
		//2. insert -- 자동 commit 처리 o
		
		System.out.println(session.getConnection().getAutoCommit());
		 ////////////////////////////////////////////
		 EmpDAO dao = new EmpDAO();
		 dao.setSession(session);
		 

		 
		 //test1: 여러개 레코드 리턴 조회
//		 List<EmpVO> list = dao.getAllEmp();
//		 for(EmpVO vo : list) {
//			 System.out.println
//			 (vo.getEmployee_id() +":" + vo.getFirst_name());
//		 }

		 //test2: 1개 레코드 리턴 조회: 200 사번 
//		EmpVO vo = dao.getOneEmp(200);
//		 System.out.println
//		 (vo.getEmployee_id() +":" + vo.getFirst_name());

//		 //test3: 0~n개 레코드 리턴 조회: 이름 Steven 사원
//		 List<EmpVO> list = dao.getNameEmp("Steven");
//		 for(EmpVO vo : list) {
//			 System.out.println
//			 (vo.getEmployee_id() +":" + vo.getFirst_name());
//		 }
		 
		 //test4 : cdata 섹션 실행
//		 List<EmpVO> list = dao.getIdEmp();
//		 for(EmpVO vo : list) {
//			 System.out.println
//			 (vo.getEmployee_id() +":" + vo.getFirst_name()
//			 +":"+vo.getHire_date());
//		 }	 
		 
		 //test5 : 새로운 사원 등록 : insert
		 // 1000 , 홍길동, gil@multi.com, sysdate, 'IT_PROG'
//		 EmpVO vo = new EmpVO();
//		 vo.setEmployee_id(1001);//중복x(오라클규칙)
//		 vo.setFirst_name("길동");//null 허용
//		 vo.setLast_name("홍");
//		 vo.setEmail("gil2@multi.com");//중복x(오라클규칙)
//		 vo.setJob_id("IT_PROG"); //SQL 대소문자구분X( 문자열값대소문자구분)
//		// ?<-select
//		 // insert / delete / update = DML
//		 dao.insertEmp(vo); //insert sql ( 자동 commit )
//		 
//		 //session.commit();  //commit
//		 System.out.println("신규 사원을 등록했습니다.");
		 
		 //test6: 1001 사번 이름 석천 , 이메일 변경 hong@multi.com
//		 EmpVO vo = new EmpVO();
//		 vo.setEmployee_id(1001);
//		 vo.setFirst_name("석천");
//		 vo.setEmail("hong@multi.com");
//		 int row = dao.updateEmp(vo);
//		 System.out.println(row + " 개의 레코드가 수정 완료되었습니다.");
//		<update id="updateemp" parameterType="String,String,int" >
//		 update employees
//		set first_name=#{} , email=#{}
//		where employee_id=#{}
	
		 //test7: 삭제 1001 사번 삭제
//		 int id = 1001;
//		 int row= dao.deleteEmp(id);
//		 System.out.println(row + " 개의 행이 삭제되었습니다.");

	//test8 : 페이징처리
	int pagenum = 2;// 현재페이지
	int cnt = 10; //한페이지에 목록 갯수
	int param [] = new int[2];
	param[0] = (pagenum-1) * cnt + 1;
	param[1] = (pagenum) * cnt;
	List<EmpVO> list = dao.pagingEmp(param);
	for(EmpVO vo : list) {
		System.out.println(vo.getFirst_name()+":"+vo.getHire_date());
	}
	}//main end
}// class end




