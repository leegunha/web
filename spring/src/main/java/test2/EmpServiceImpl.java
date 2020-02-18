package test2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao ;
	
	//spring mvc에서는 필요없으나 main을 위해 남김	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmpVO> selectWithMap(Map map) {
		return dao.selectWithMap(map);
	}

	@Override
	public List<EmpVO> selectWithArray(int[] arr) {
		return dao.selectWithArray(arr);
	}

	public List<EmpVO> selectWithRownumArray(int[] arr){
		return dao.selectWithRownumArray(arr);
	}
	//java.util.List
	public List<EmpVO> selectWithList(List list){
		return dao.selectWithList(list);
	}
	
	@Override
	public List<EmpVO> selectList(int id) {
		return dao.selectList(id);
	}
	//select * from employees
	public List<EmpVO> getEmpList() {
		return dao.getEmpList();
	}

	
	@Override
	public List<EmpVO> getEmpWhereList() {
		return dao.getEmpWhereList();
	}

	@Override
	public EmpVO getEmpOne() {
		return dao.getEmpOne();
	}

	@Override
	public void insertEmp(EmpVO vo) {
		dao.insertEmp(vo);
	}
	
	@Override
	public void updateEmp(EmpVO vo) {
		dao.updateEmp(vo);
	}

	@Override
	public void deleteEmp(int id) {
		//service메소드1개-dao메소드2개호출
		dao.deleteHistory(id);
		dao.deleteEmp(id);
	}

	@Override
	public void insertEmpWithSelectKey(EmpVO vo) {
		dao.insertEmpWithSelectKey(vo);
	}

	@Override
	public void updateWithMap(Map map) {
		dao.updateWithMap(map);
		
	}	
	
	public List<EmpVO2> getEmpList2() {
		return dao.getEmpList2();
	}
	
}



