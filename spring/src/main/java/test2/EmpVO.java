package test2;
// 1. db 테이블 설계  2. VO 설계
// DB 테이블 : 내친구 -- VO : 나

//import org.apache.ibatis.type.Alias;
//@Alias("emp")

/* xml파일에는
 <typeAliases>
<package name="domain.blog"/>
</typeAliases>
선언할 것
*/
public class EmpVO {//db 테이블 컬럼명 = 변수명 동일 
	private int employee_id; 
	private int department_id;
	private String last_name;// last_name컬럼값 저장 변수
	private String job_id;
	private String email;
	private String hire_date;
	//setter/getter
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	//toString
	@Override
	public String toString() {
		return "EmpVO [employee_id=" + employee_id + ", department_id=" + department_id + ", last_name=" + last_name
				+ ", job_id=" + job_id + ", email=" + email + ", hire_date=" + hire_date + "]";
	}
}
