package storageClass;

public class VariableTest {
	int data = 10;					// 전역변수
	static int data_s = 10;		// 정적변수
	
	
	void increaseData() { //전역변수 출력하는 메소드 -> 생성자로 할당됨
		System.out.println(++data);
	}
	
	static void increaseData_s() { //정적변수 출력하는 메소드 -> 컴파일러로 할당됨
		System.out.println(++data_s);
	}
}
