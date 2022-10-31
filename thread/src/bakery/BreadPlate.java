package bakery;

// 싱글톤 패턴
// 객체는 무조건 한 개만 만들고 돌려 쓴다.
public class BreadPlate {

	public static BreadPlate breadPlate;
	
	public int breadCount; 
	public int eatCount;
	
//	싱글톤
	private BreadPlate() {;}
	
//	싱글톤으로 만들기 위한 getInstance메소드
	public static BreadPlate getInstance() {
		if(breadPlate == null) {
			breadPlate = new BreadPlate();
		}
		return breadPlate;
	}
	
//	빵 만들기
//	만든 빵이 9개가 넘어가면, 쓰레드를 멈춰준다.
	public synchronized void makeBread() { //wait을 쓰기 위해서는 어떤 것을 제어 중인지 확실히 해야한다. 그러기 위해서는 동기화를 해주어야 한다.
		if(breadCount >9) {
			System.out.println("빵이 가득 찼습니다.");
			try {wait();} catch (InterruptedException e) {BreadMaker.check = true;} //check를 true로 바꿔주면 BreadPlate에서 InterruptedException이 발생한다.
		} else {
			breadCount++;
			System.out.println("빵을 1개 만들었습니다. 현재 빵 개수 : " + breadCount + "개");
		}
	}
	
//	빵 먹기
//	만든 빵이 0개면 못 먹고, 먹은 빵이 20개면 못 먹는다.
//	만약 빵을 먹게 되면, 멈춰있던 쓰레드를 깨워준다.
	public synchronized void eatBread() { //notify로 wait을 깨워주기 위해 동기화가 필요
		if(eatCount == 20) {
			System.out.println("빵이 다 떨어졌습니다!");
		} else if(breadCount < 1) {
			System.out.println("🍞🍩빵을 만들고 있어요!");
		} else {
			eatCount++;
			breadCount--;
			System.out.println("빵을 1개 먹었습니다. 현재 빵 개수 : "+ breadCount + "개");
			notify(); //wait()메소드가 걸려있을 때 다시 실행하기 위한 장치, wait이 안걸려있어도 notify()메소드 실행에 문제는 없다.
		}
	}
}
