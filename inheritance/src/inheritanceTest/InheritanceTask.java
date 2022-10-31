package inheritanceTest;

class Car {
//	필드 구성(브랜드, 색상, 가격)
	String brand;
	String color;
	int price;

	public Car() {
		;
	}

	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	열쇠로 시동 킴
	void turnOn() {
		System.out.println("열쇠로 시동 킴");
	}

//	열쇠로 시동 끔
	void turnOff() {
		System.out.println("열쇠로 시동 끔");
	}

}

class SuperCar extends Car { // 부모 클래스인 Car의 필드도 자동으로 추가됨
//	필드 구성(모드) 
	String mode;

//	자식 기본 생성자는 부모의 기본 생성자를 호출한다.
//	부모에 기본 생성자가 없으면 자식의 기본 생성자는 오류가 발생한다.
	public SuperCar() {
		;
	}

	public SuperCar(String brand, String color, int price, String mode) {
//		부모의 생성자 중 3개의 값을 전달받는 생성자 호출
		super(brand, color, price); // 부모 클래스의 초기화 생성자에 있는 내용은 super괄호 안에 넣으면 된다.
		this.mode = mode;
	}

//	음성으로 시동 킴
	@Override
	void turnOn() { // 부모클래스 오버라이딩
		super.turnOn(); // 부모클래스의 turnOn 메소드 사용
		System.out.println("음성으로 시동 킴");
	}

//	음성으로 시동 끔
	@Override
	void turnOff() { // 부모클래스 오버라이딩
		System.out.println("음성으로 시동 끔");
	}

//	지붕 열기
	void openRoof() {
		System.out.println("지붕 열기");
	}

//	지붕 닫기
	void closeRoof() {
		System.out.println("지붕 닫기");
	}

}

public class InheritanceTask {

	public static void main(String[] args) {

		SuperCar sc = new SuperCar();

		sc.turnOn();
		sc.turnOff();

		sc.openRoof();
		sc.closeRoof();
	}

}
