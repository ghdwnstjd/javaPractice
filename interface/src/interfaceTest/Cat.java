package interfaceTest;

public class Cat implements Pet { //Pet 인터페이스를 받아왔기 때문에 Pet 인터페이스의 추상 메소드를 모두 재정의해야한다.

	@Override
	public void bang() {
		System.out.println("안한다.");
	}

	@Override
	public void giveYourHand() {
		System.out.println("안한다.");
	}

	@Override
	public void bite() {
		System.out.println("문다.");
	}

	@Override
	public void sitDown() {
		System.out.println("지나간다.");
	}

	@Override
	public void waitNow() {
		System.out.println("안기다린다.");
	}

	@Override
	public void getNose() {
		System.out.println("나를 안본다.");
	}
}