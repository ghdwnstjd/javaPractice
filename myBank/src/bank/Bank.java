package bank;

public class Bank {

//	은행이 3개, 각 은행별 고객 100명씩 유지 가능
//	은행별 고객 정보는 한 번에 취합하기 때문에 static을 써야한다.
// 은행 3개고 각 고객 100명까지 취합 가능하므로 배열은 [3][100]으로 한다.
	public static Bank[][] arrBankInfo = new Bank[3][100];
	public static int[] arCount = new int[3];

//	필드명: 예금주, 계좌, 핸드폰번호, 비밀번호, 통장 잔고
	private String name;
	private String accountNumber;
	private String phoneNumber;
	private String password;
	private int money;

	public Bank() {
		;
	}

	public Bank(String name, String accountNumber, String phoneNumber, String password, int money) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

//출금
	public void withdraw(int money) {
		this.money -= money;
	}

//입금
	public void deposit(int money) {
		this.money += money;
	}

//잔액조회
	public int checkAccount() {
		return money;
	}

//계좌번호 중복검사
	public static Bank checkAccount(String accountNumber) {
		Bank bank = null;
		for (int i = 0; i < arrBankInfo.length; i++) {
			int j = 0;
			for (j = 0; j < arCount[i]; j++) {
				if (arrBankInfo[i][j].accountNumber.equals(accountNumber)) {
					bank = arrBankInfo[i][j];
					break;
				}
			}
			if (j != arCount[i]) {
				break;
			}
		}
		return bank;
	}

//핸드폰 번호 중복검사
	public static Bank checkPhoneNumber(String phoneNumber) {
		Bank bank = null;
		for (int i = 0; i < arrBankInfo.length; i++) {
			int j = 0;
			for (j = 0; j < arCount[i]; j++) {
				if (arrBankInfo[i][j].phoneNumber.equals(phoneNumber)) {
					bank = arrBankInfo[i][j];
					break;
				}
			}
			if (j != arCount[i]) {
				break;
			}
		}
		return bank;
	}

//로그인
	public static Bank login(String accountNumber, String password) {
		Bank bank = checkAccount(accountNumber);
		if (bank != null) {
			if (bank.password.equals(password)) {
				return bank;
			}
		}
		return null;
	}
	
//	계좌 조회
	public int showBalance() {
		return money;
	}
}
