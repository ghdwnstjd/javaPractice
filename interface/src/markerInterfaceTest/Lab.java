package markerInterfaceTest;

public class Lab {

//	외부에서 모든 동물을 받아와서
//	초식동물인지 육식동물인지 그리고 잡식 동물인지 구분하는 메소드
//	초식동물: Herbivore
//	육식동물: Carnivore
	
	public void checkKinds(Animal[] animals) { 
//		외부에서 Animal 타입의 배열을 전달받고
//		Instanceof를 사용하여 종을 검사한다.
		for (int i = 0; i < animals.length; i++) {
			//마커 인터페이스로 클래스를 묶어 타입을 같게 만들었기 때문에 instanceof로 초식동물과 육식동물에 속한 클래스를 선별할 수 있다.
			if(animals[i] instanceof MarkerHerbivore) { 
				System.out.println("초식동물입니다.");
			}else if(animals[i] instanceof MarkerCarnivore) {
				System.out.println("육식동물입니다.");
			} else { //두 마커인터페이스에 속하지 않은 클래스가 잡식 동물
				System.out.println("잡식동물입니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		Lab l = new Lab(); //Lab 클래스의 l 객체화
		Animal[] animals = {  // Animal타입의 배열 animals에 Bear클래스, Cow클래스, Dog클래스, Tiger 클래스를 받아와 배열로 저장, 타입을 통해 동물의 종을 검사할 수 있도록 한다.
				new Bear(),
				new Cow(),
				new Dog(),
				new Tiger()
		};
		l.checkKinds(animals);
	}
	
}
