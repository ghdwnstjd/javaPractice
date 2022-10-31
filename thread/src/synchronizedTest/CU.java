package synchronizedTest;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();
		//하나의 atm 객체를 공유하기 때문에 동기화가 필요하다.
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
	}
}
