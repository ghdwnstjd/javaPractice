package interfaceTest;

public interface Pet {
	final static int eyes =2; // 인터페이스에 있는걸 쓰기 위해선 final static이 있어야 함(final static은 인터페이스에서 생략된다.)
	int nose = 1; // 인터페이스에서는 final static이 생략되기 때문에 이렇게 쓸 수 있다.
	
	
	//인터페이스는 상수와 추상메소드만 선언 가능하기 때문에 abstract를 생략하고 써도 일반 메소드가 아닌 
	//추상메소드로 인식이 되기 때문에 오류가 나지 않는다.
	public void bang(); 
	public void giveYourHand();
	public void bite();
	public void sitDown();
	public void waitNow();
	public void getNose();
}
