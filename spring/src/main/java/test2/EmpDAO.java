package test2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDAO {
	@Autowired
	SqlSession session;

	//spring mvc에서는 필요없으나 main을 위해 남김
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<EmpVO> getEmpList(){
		return session.selectList("emp.selectAll");
	}
	
	public List<EmpVO> getEmpWhereList(){
		return session.selectList("emp.selectWhere");
	}
	
	public EmpVO getEmpOne() {
		//where upper(last_name) = #{a}
		EmpVO vo = 
		session.selectOne("emp.selectOne" , "BELL");
		return vo;
	}
	public void insertEmp(EmpVO vo) {
		//메인 스캐너 키보드 입력 데이터 EmpVO-inssert 
		session.insert("emp.insertEmp", vo);
	}
	
	public void updateEmp(EmpVO vo) {
		session.update("emp.updateEmp", vo);
	}
	
	public void deleteHistory(int id) {
		session.delete("deleteHistory", id);
		System.out.println("histosy 테이블에서 삭제");
	}
	
	public void deleteEmp(int id) {
		session.delete("deleteEmp", id);
		System.out.println("employees 테이블에서 삭제");
	}
	
	public void insertEmpWithSelectKey(EmpVO vo) {
		session.insert("insertEmpWithSelectKey", vo);
	}
	
	public void updateWithMap(Map map) {
		session.update("updateWithMap", map);
	}
	
	public List<EmpVO> selectList(int id){
		return session.selectList("selectList", id);
	}
	
	public List<EmpVO> selectWithArray(int[] arr){
		return session.selectList
				("selectWithArray", arr);
	}

	public List<EmpVO> selectWithRownumArray(int[] arr){
		return session.selectList
				("selectWithRownum", arr);
	}
	
	//map 전달위해 멤버변수화
	Map testmap;
	public List<EmpVO> selectWithMap(Map map){
		testmap = map;
		return session.selectList("selectWithMap", testmap);
	}

	public List<EmpVO> selectWithList(List list){
		return session.selectList
				("selectWithList", list);
	}
	
	public List<EmpVO2> getEmpList2(){
		return session.selectList("emp2.selectAll");
	}
	
}



//dao - 1개 매핑 sql 실행

//public List<EmpVO> getEmpWithArray
//(int[] param){
//	return session.selectList
//	("multi.selectEmpWithArray", param);
//}
//public List<EmpVO> getEmpWithList
//(List<Integer> param){
//	return session.selectList
//	("multi.selectEmpWithList", param);
//}