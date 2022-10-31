package casting;

class Car {

	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}

}

class SuperCar extends Car {
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
	}

	void openRoof() {
		System.out.println("지붕 열기");
	}
}

public class CastingTest {
	public static void main(String[] args) {
//		up casting
		Car noOptionFerrari = new SuperCar(); // 모든 자식은 부모와 타입이 같기 때문에 오류가 생기지 않는다.
		noOptionFerrari.engineStart();

//		down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;  // 다운캐스팅은 업캐스팅된 객체를 강제형변환하여 만든다.
		fullOptionFerrari.openRoof();
		
//		noOptionFerrari.openRoof(); 오류, noOptionFerrari 객체에는 SuperCar 클래스의 필드가 들어있지 않다.
//		SuperCar brokenFerrari = (SuperCar)new Car(); 오류, 부모는 자식과 타입이 다르기 때문에 오류가 생긴다.
//		SuperCar fullOptionFerrari = noOptionFerrari; 오류, 부모는 자식과 타입이 다르다
//		==================================
		
		
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();

		
//      matiz instanceof Car : true
      System.out.println(matiz instanceof Car);
//      matiz instanceof SuperCar : false
      System.out.println(matiz instanceof SuperCar);
//      ferrari instanceof Car : true
      System.out.println(ferrari instanceof Car);
//      ferrari instanceof SuperCar : true
      System.out.println(ferrari instanceof SuperCar);
//      noOptionFerrari instanceof Car : true
      System.out.println(noOptionFerrari instanceof Car);
//      noOptionFerrari instanceof SuperCar : true
      System.out.println(noOptionFerrari instanceof SuperCar);
//      fullOptionFerrari instanceof Car : true
      System.out.println(fullOptionFerrari instanceof Car);
//      fullOptionFerrari instanceof SuperCar : true
      System.out.println(fullOptionFerrari instanceof SuperCar);

		
	
		
	}
}
