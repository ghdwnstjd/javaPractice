package exceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			System.out.println(e);							// 어떤 오류인 지 알고 싶을 때 Exception 객체명 출력
			e.printStackTrace();								// 어디서 오류가 났는지 알려주는 메소드
		}
		System.out.println("반드시 실행되어야 하는 문장");
	}
}
