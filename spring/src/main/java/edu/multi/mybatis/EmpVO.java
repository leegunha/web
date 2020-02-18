package edu.multi.mybatis;

public class EmpVO {
// EMPLOYEES 테이블 1개 레코드 속한 컬럼들 저장
	int employee_id, manager_id, department_id;
	String first_name, last_name, email, phone_number, hire_date, job_id;
	double salary, commission_pct;
	public int getEmployee_id() {   //${vo.first_name}
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}
	//Object클래스 포함 메소드
	// 자바 모든 클래스(controller, dao, vo)는 Object 상속 하위클래스
	// toString() 오버라이딩 
	// s.o.p(vo)
	// ${vo}
	@Override
	public String toString() {
		return "EmpVO [employee_id=" + employee_id + ", manager_id=" + manager_id + ", department_id=" + department_id
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone_number="
				+ phone_number + ", hire_date=" + hire_date + ", job_id=" + job_id + ", salary=" + salary
				+ ", commission_pct=" + commission_pct + "]";
	}

	
}


