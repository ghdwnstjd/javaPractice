package ambiguityTest;

public class ClassC implements InterA, InterB{ //인터페이스는 2개 이상을 implements 할 수 있다.

	@Override
	public void printData() { //두 개의 인터페이스 내에 이름과 매개변수가 똑같은 메소드가 선언되어 있다.
		InterA.super.printData();   //InterA를 쓰겠다고 선언하는 것. 굳이 메소드 내용을 재정의할 필요가 없음
	}
	
}
