package mybatis.copy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAO {
	@Autowired
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<EmpVO> getAllEmp(){
		List<EmpVO> list = session.selectList("allemp");
		return list;
	}

	 public EmpVO getOneEmp(int id) {
		 EmpVO vo = session.selectOne ("oneemp", id);
		 return vo;
	 }

	 public List<EmpVO> getNameEmp(String name){
		 List<EmpVO> list = session.selectList("nameemp", name);
		 return list;
	 }
	 
	 public List<EmpVO> getIdEmp(){
		 List<EmpVO> list = session.selectList("idemp");
		 return list;
	 }
	 
	 public void insertEmp(EmpVO vo){
		 session.insert("newemp", vo);
		 //<insert id="newemp" parameterType="emp" > inserrt... </insert>
	 }
	 
	public int updateEmp(EmpVO vo) {
		int row = session.update("updateemp", vo );
		return row;
	}
	
	public int deleteEmp(int id) {
		int row = session.delete("deleteemp", id);
		return row;
	}
	
	public List<EmpVO> pagingEmp(int [] param) {
		List<EmpVO> list = session.selectList("pagingemp", param);
		return list;
	}
}	 










