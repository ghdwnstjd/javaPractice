package lambdaTest;

@FunctionalInterface //함수형 인터페이스
public interface PrintName {
//	성과 이름을 전달받은 후 String으로 리턴하는 추상메소드 선언
	public String getFullName(String firstName, String lastName); //함수형 인터페이스므로 추상메소드를 하나만 가질 수 있다.
}
