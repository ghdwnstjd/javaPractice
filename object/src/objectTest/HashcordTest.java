package objectTest;

import java.util.Random;

public class HashcordTest {
	public static void main(String[] args) {
		
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		
//		값이 똑같다.
//		String클래스에서 hashCode를 문자열 값의 주소로 재정의했기 때문
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
	}
}
