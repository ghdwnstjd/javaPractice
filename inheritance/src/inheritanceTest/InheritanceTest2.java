package inheritanceTest;

class Human {
	void eat() {
		System.out.println("먹기");
	}

	void sleep() {
		System.out.println("잠자기");
	}

	void walk() {
		System.out.println("두 발로 걷기");
	}
}

class Monkey extends Human {
	void 이잡아라() {
		System.out.println("이잡기");
	}
	
	@Override	//@는 어노테이션이라고 읽는다.
	void walk() { // 오버라이딩 - 부모클래스의 메소드를 재정의(메소드 이름이 부모와 같음)
		super.walk(); // 부모의 코드를 그대로 사용하고자 할 때 
		System.out.println("네 발로 걷기");
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Monkey kingkong = new Monkey();
		kingkong.walk();
	}
}
