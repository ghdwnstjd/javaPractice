package ambiguityTest;

public interface InterA {
	default void printData() { //자바에서는 다중상속이 불가하기 때문에 default 메소드를 통해 다중상속 기능을 구현한다.
		System.out.println("InterA");
	}
}
