package nonspring;

public class MultiTV implements TV {
//전원켜다/끄다
	public void powerOn() {
		System.out.println("멀티tv:전원켜다");
	}
	public void powerOff() {
		System.out.println("멀티tv:전원끄다");
	}	
//볼륨 업 / 다운
	public void soundUp() {
		System.out.println("멀티tv:볼륨높이다");
	}
	public void soundDown() {
		System.out.println("멀티tv:볼륨낮추다");
	}
}






