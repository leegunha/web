package test2;

public class EmpVO2 {
	int emp_id;
	String name;
	String phone;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmpVO2 [emp_id=" + emp_id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
