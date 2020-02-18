package nonspring;

public class Main {

	public static void main(String[] args) {
		// 객체 변경시 코드 수정 불가피 = 결합도 높다 . coupling 높다(나쁜코드)
		// tv변수 생성 객체가 MultiTV, OtherTV 2개중1개
		// dependency: 직접 객체 생성--> 위임(다른 객체로부터 전달)
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV(args[0]);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();

	}

}
