package tvspring;

//모든 tv 들은 메소드 공통 약속 : 구현방법 다르다
// 상속 다른 클래스 "의무적 " 메소드 OVERRIDING
public interface TV {
  public void powerOn() ;
  public void powerOff() ;  
  public void soundUp() ;
  public void soundDown() ;  
}
