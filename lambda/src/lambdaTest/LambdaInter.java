package lambdaTest;

@FunctionalInterface  //함수형 인터페이스, 단 하나의 추상메소드만 선언할 수 있도록 제한된다.
public interface LambdaInter { 
	boolean checkMultipleOf10(int number); //boolean타입의 추상메소드, 함수형 인터페이스이기 때문에 더이상의 추상메소드는 구현할 수 없다.
}
