package nonspring;

public class OtherTV implements TV{
//전원켜/끄/볼륨
	public void powerOn() {
		System.out.println("othertv:전원켜다");
	}
	public void powerOff() {
		System.out.println("othertv:전원끄다");
	}	
	public void soundUp() {
		System.out.println("othertv:볼륨높이다");
	}
	public void soundDown() {
		System.out.println("othertv:볼륨낮추다");
	}
}





