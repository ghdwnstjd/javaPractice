package bank;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class MainTask {
	public static void main(String[] args) {

//	은행선택
		String msg = "1. 신한은행\n2. 국민은행 \n3. 하나은행\n4. 나가기";
		/*
		 * 1. 계좌개설 - 13자리 랜덤 계좌번호 - 기존 고객의 계좌번호와 중복이 없는 번호로 개설해야 한다. - 핸드폰 번호는 숫자만 입력하도록
		 * 하고, 문자가 포함되면 안되고 0~9사이의 정수여야 한다. - 비밀번호 4자리로만 입력하도록 한다. 2. 입금하기 - 계좌를 개설한
		 * 은행에서만 입금 가능 3. 출금하기 4. 잔액조회 5. 계좌번호 찾기 6. 나가기
		 */
		String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행선택메뉴로 이동";
		String account = "", accountName = null, phoneNumber = null, password = null;
		int bankNumber = 0, menuChoice = 0, money = 0;

		String[] bankName = { "신한은행", "국민은행", "하나은행" };

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Bank bank = null;

		while (true) {
			System.out.println(msg);
			bankNumber = sc.nextInt();
			if (bankNumber == 4) {
				break;
			}
			while (true) {
				System.out.print(menu);
				menuChoice = sc.nextInt();
				if (menuChoice == 6) {
					break;
				}
				switch (menuChoice) {
				case 1: // 계좌개설
					Bank[] arBank = { new Shinhan(), new Kookmin(), new Hana() };

					System.out.print("예금주: ");
					accountName = sc.next();

					while (true) {
						System.out.println("핸드폰 번호['-'제외]");
						phoneNumber = sc.next();
						int i = 0;
						for (i = 0; i < phoneNumber.length(); i++) {
							char c = phoneNumber.charAt(i);
							if (c < 48 || c > 57) {
								break;
							}
						}
						if (i != phoneNumber.length()) {
							System.out.println("숫자만 입력해주세요.");
							continue;
						}

						if (phoneNumber.length() != 11) {
							System.out.println("11자리의 숫자를 모두 기재해주세요.");
							continue;
						}

						if (!phoneNumber.startsWith("010")) {
							System.out.println("010으로 시작해야합니다.");
							continue;
						}
						if (Bank.checkPhoneNumber(phoneNumber) != null) {
							System.out.println("중복된 핸드폰 번호입니다.");
							continue;
						}
						break;
					}
					System.out.println("핸드폰 번호가 저장되었습니다.");
					arBank[bankNumber - 1].setPhoneNumber(phoneNumber);

					// 비밀번호
					password = "";
					while (true) {
						System.out.print("비밀번호: ");
						password = sc.next();
						if (password.length() != 4) {
							System.out.println("비밀번호는 4자리로 입력해야 합니다.");
						}
						arBank[bankNumber - 1].setPassword(password);
						System.out.println("비밀번호가 설정되었습니다.");
						break;
					}

					// 계좌번호 제공
					while (true) {
						account = "";
						for (int i = 0; i < 12; i++) {
							account += r.nextInt(10);
						}
						account = bankNumber - 1 + account;
						if (Bank.checkAccount(account) == null) {
							break;
						}
					}
					arBank[bankNumber - 1].setAccountNumber(account);

					Bank.arrBankInfo[bankNumber - 1][Bank.arCount[bankNumber - 1]] = arBank[bankNumber - 1];
					Bank.arCount[bankNumber - 1]++;

					System.out.println("축하합니다. 감사합니다. 사랑합니다.");
					System.out.println("당신을 위한 " + bankName[bankNumber - 1] + "이 되겠습니다.");
					System.out.println("고객님의 계좌번호는 " + account + "입니다. ");
					System.out.println("분실 시 계좌번호 찾기 서비스를 이용해주세요.");
					break;

				case 2: // 입금하기
//					계좌번호
					System.out.print("계좌번호: ");
					account = sc.next();

//					비밀번호
					System.out.print("비밀번호: ");
					password = sc.next();

					bank = Bank.login(account, password);
					if (bank == null) {
						System.out.println("아이디나 비밀번호를 확인해주세요.");
						break;
					}
//					입금액
					System.out.print("입금액: ");
					money = sc.nextInt();
					if (money < 0) {
						System.out.println("입금액을 다시 한 번 확인해주세요.");
						break;
					}
					bank.deposit(money);
					System.out.println("입금 성공! " + money + "원을 입금하였습니다.");
					break;

				case 3: // 출금하기
//					계좌번호
					System.out.print("계좌번호: ");
					account = sc.next();

//					비밀번호
					System.out.print("비밀번호: ");
					password = sc.next();

					bank = Bank.login(account, password);
					if (bank != null) {
						System.out.print("출금액: ");
						money = sc.nextInt();
						if (money < 0) {
							System.out.println("출금액을 다시 한 번 확인해주세요.");
							break;
						}
						if (bank instanceof Kookmin) {
							money *= 1.5;
						}
						if (bank.showBalance() - money < 0) {
							System.out.println("출금액이 초과되었습니다.");
							break;
						}
						bank.withdraw(money);
						break;
					}
					System.out.println("계좌번호나 비밀번호를 다시 확인해주세요.");
					break;
				case 4: // 잔액 조회
					System.out.print("계좌번호: ");
					account = sc.next();
					System.out.println("비밀번호: ");
					password = sc.next();

					bank = Bank.login(account, password);
					if (bank != null) {
						System.out.println("귀하의 잔액은 " + bank.showBalance()+"원 입니다.");
					}
					break;

				case 5: // 계좌번호 찾기
					System.out.print("핸드폰 번호: ");
					phoneNumber = sc.next();
					bank = Bank.checkPhoneNumber(phoneNumber);
					if (bank != null) {
						System.out.print("비밀번호: ");
						password = sc.next();
						if (bank.getPassword().equals(password)) {
							while (true) {
								account = "";
								for (int i = 0; i < 12; i++) {
									account += r.nextInt(10);
								}
								account = bankNumber - 1 + account;
								if (Bank.checkAccount(account) == null) {
									break;
								}
							}
							bank.setAccountNumber(account);
							System.out.println("고객님의 계좌번호를 새롭게 발급해드렸습니다.");
							System.out.println("고객님의 새로운 계좌번호는 " + account + "입니다.");
							System.out.println("분실 시 계좌번호 찾기 서비스를 다시 이용해주세요~!");
						}
					}
					break;

				}
			}
		}

	}

}
