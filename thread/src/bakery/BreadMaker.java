package bakery;

public class BreadMaker implements Runnable{
	
	public static boolean check;

	@Override
	public void run() {
//		빵을 20개 만든다.	
		int i = 0;
		for (i = 0; i < 20; i++) {
//			makeBread메소드를 하나만 실행하기 위해 싱글톤객체 사용
			BreadPlate.getInstance().makeBread();
			if(check) {break;} // BreadPlate에서 InterruptedException을 발생시키기 위함
			try {Thread.sleep(1000);} catch (InterruptedException e) {break;}
		}
		if(i != 20){
			System.out.println("안녕히 가세요");
			return;
		}
		System.out.println("재료 소진");
	}
}
