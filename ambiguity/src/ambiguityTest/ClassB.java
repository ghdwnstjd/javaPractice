package ambiguityTest;

public class ClassB extends ClassA implements InterA { //ClassA 클래스, InterA와 타입이 같다.
	@Override
	public void printData() {//부모 클래스의 메소드와 인터페이스의 디폴트 메소드의 이름과 매개변수가 똑같이 선언되어 있다.
		super.printData();   //부모클래스가 더 상위개념. ClassA의 printData 실행됨
		InterA.super.printData(); //InterA의 printData 실행됨
	}
}
