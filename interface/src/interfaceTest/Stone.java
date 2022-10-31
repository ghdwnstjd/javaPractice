package interfaceTest;

public class Stone extends PetAdapter { //Pet이 아닌 PetAdapter를 부모클래스로 받았기 때문에 강제성이 없어져 추상클래스를 모두 재정의할 필요가 없다.

	
	@Override
	public void sitDown() {
		System.out.println("앉는다. ");
	}

	@Override
	public void waitNow() {
		System.out.println("기다린다. ");
	}



}
