package synchronizedTest;

public class ATM implements Runnable {
	
	public int money;

	public ATM() {
		this(10000); //ATM 메소드 실행 시 디폴트 값으로 money가 10000이 들어간다.
	}

	public ATM(int money) {
		super();
		this.money = money;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdraw(1000);
			try{Thread.sleep(1000);} catch(InterruptedException e) {;}
		}
	}	
	
	public synchronized void withdraw(int money) { //메소드 전체에 동기화를 걸기
//		블럭
//		synchroized(mutex) : mutex : 동기화를 걸어줄 자원 객체
//		synchronized (this) { // 동기화가 필요한 부분에만 걸기
			this.money -= money;
//		}
		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
}
