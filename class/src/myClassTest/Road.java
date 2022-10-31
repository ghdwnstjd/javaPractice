package myClassTest;

class Car {
	String brand;
	String color;
	int price;

//	Alt + Shift + S 하고 O 누르면 자동으로 생성됨
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public Car(String color) {
		brand = "자동차"; //겹치는 이름이 없기 때문에 this가 생략 가능하다.
		this.color = color;
	}

	void engineStart() {
		System.out.println(brand + " 시동 켜기");
	}

	void engineStop() {
		System.out.println(brand + " 시동 끄기");
	}
}

public class Road {
// 실행 프로그램을 만들어주는 메소드
	public static void main(String[] args) {
		Car momCar = new Car("Benz", "Black", 10_000);
		Car dadyCar = new Car("BMW", "Blue", 8_000);
		Car myCar = new Car("Red");

		momCar.engineStart();
		dadyCar.engineStart();
		myCar.engineStart();
	}
}
