package aop1;

public class Member {
 public void login(String id) {
	 System.out.println(id + " 회원님이 로그인하셨습니다.");
 }
 public void logout() {
	 System.out.println("회원님이 로그아웃하셨습니다.");
 }
}
