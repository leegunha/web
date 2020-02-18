package test2;

import java.util.List;
import java.util.Map;

public interface EmpService {
	public List<EmpVO> getEmpList();
	public List<EmpVO> getEmpWhereList();
	public EmpVO getEmpOne();
	public void insertEmp(EmpVO vo);
	public void updateEmp(EmpVO vo);
	public void deleteEmp(int id);
	public void insertEmpWithSelectKey(EmpVO vo);
	public void updateWithMap(Map map);
	public List<EmpVO> selectList(int id);
	public List<EmpVO> selectWithArray(int[] arr);
	public List<EmpVO> selectWithRownumArray(int[] arr);
	public List<EmpVO> selectWithList(List list);
	public List<EmpVO> selectWithMap(Map map);
	public List<EmpVO2> getEmpList2();
}


