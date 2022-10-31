package inheritanceTest;

class A {
	String name = "A";
	int data = 10;
	
	void printName() {
		System.out.println(name);
	}
}

class B extends A {

	public B() {
		name = "B";
	}

	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
//		자식 생성자만 있어도 부모 생성자를 호출할 수 있고(super()), 부모 생성자가 먼저 코드 진행이 된 후 자식 생성자가 진행이 된다.
//		super()는 부모 생성자로 자식 생성자의 맨 위에 기재함 -> 자식 클래스 타입의 객체로 부모 필드 접근 가능
		B b = new B(); 
		b.printName();
		b.printData();
	}
}
