package lambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
		LambdaInter lambdaInter1 = (number) -> number % 10 == 0; //LambdaInter 인터페이스의 객체 lambdaInter1은 매개변수 number를 가지며, 매개변수 나누기 10한 값이 0이 되는지 논리값을 저장한다.
		boolean result = lambdaInter1.checkMultipleOf10(10);		// 논리타입의 result 변수는 LambdaInter 인터페이스의 객체 lambdaInter1의 추상메소드 값을 저장한다. 매개변수 number의 값은 10 
		System.out.println(result); //true 또는 false 출력
		
		
		LambdaInter lambdaInter2 = (n) -> { //LambdaInter 인터페이스 의 객체 lambdaInter2와 매개변수 n -> int number, 함수형 인터페이스는 추상메소드를 하나만 받을 수 있기 때문에 추상메소드의 이름이 필요없다.
			System.out.println("10의 배수 검사");
			return n % 10 == 0;			//LambdaInter의 추상메소드 타입이 boolean이기 때문에 return값은 true 또는 false가 나온다.
		};
		boolean result2 = lambdaInter2.checkMultipleOf10(20); //boolean타입의 변수 result2는 LambdaInter 인터페이스의 객체 lambdaInter2가 실행한 추상메소드의 값을 저장한다.
		System.out.println(result2); //true 또는 false 출력

	}
}
