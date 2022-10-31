package lambdaTest;

public class PrintNameTest{
// 외부에서 람다식으로 구현한 값을 name으로 전달받기
	public static void printFullName(PrintName name) { //PrintName 형식의 name 객체를 매개변수로 받는 printFullName 메소드
		System.out.println(name.getFullName("한", "동석")); //getFullName 메소드는 매개변수로 2개의 문자열을 받아야 하므로 매개변수도 2개를 적는다.
		System.out.println(name.getFullName("홍", "준성"));
	}
	
	public static void main(String[] args) {
//		매개변수 2개를 설정하고, 두 문자열을 연결하도록 구현한다.
		printFullName((f, l) -> f+l);
		printFullName((f, l) -> l+ f);
	}
}

