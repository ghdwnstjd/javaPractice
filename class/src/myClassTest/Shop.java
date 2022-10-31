package myClassTest;

import java.util.Scanner;

class SuperCar {
//   브랜드, 색상, 가격
	String brand;
	String color;
	int price;

	String password;

	boolean check;

	public SuperCar() { // 매개변수가 아래와 다르기 때문에 이름이 같아도 오류가 나지 않음
		password = "0000"; // 기본 패스워드를 0000으로 설정
	}

	public SuperCar(String password) { // 매개변수가 아래와 다르기 때문에 이름이 같아도 오류가 나지 않음
		this.password = password; // this.password = 전역변수의 password
	}

	public SuperCar(String brand, String color, int price, String password) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.password = password;
	}

//   시동 켜기
//   시동의 상태를 확인하고 
//   시동이 꺼져있다면, "시동 켜기" 출력
//   이미 시동이 켜져있다면, "시동이 이미 켜져있습니다" 출력
	boolean engineStart() { // return 값이 true(논리형)이기 때문에 boolean을 리턴한다.
		if (!check) { // check가 false일 경우, 시동이 꺼져있을 경우
			check = true; // 시동 켜기
			return true; // true값을 리턴한다 -> 시동 켜는 것을 성공했다는 것(engineStart가 true)
		}
		return false; // check가 true일 경우, false를 리턴한다. ->false를 리턴한다는 것은 시동 켜기가 이미 되었기 때문에 다시 켜는 것이
						// 실패했다는 것을 의미
	}

//   시동 끄기
//   시동의 상태를 확인하고 
//   시동이 켜져있다면, "시동 끄기" 출력
//   이미 시동이 꺼져있다면, "시동이 이미 꺼져있습니다" 출력
	boolean engineStop() {
		if (check) { // check가 true일 경우 = 시동이 켜있을 경우
			check = false; // check를 false로 변경 = 시동을 끈다.
			return true; // 시동이 꺼진 상황이 true -> 다시 말해 engineStop()이 true일 때 시동이 꺼진 상황이다.
		}
		return false; // check가 false일 경우, false를 리턴한다. -> 시동 끄는 것을 실패한 상황이 false
	}

//   [심화]
//   시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
//   입력한 비밀번호가 3회 연속 실패하면 "경찰 출동" 메세지를 출력한다.
	boolean checkPassword(String password) { // 패스워드 확인을 위해 boolean 메소드를 구현(패스워드의 부합여부를 확인하기 때문에 논리형)
		return this.password.equals(password); // equals는 문자가 같은지 확인을 할 때 사용한다. return값은 전역변수인 password와 매개변수(지역변수)로 직접
												// 입력한 password가 같은지 논리값으로 확인한다.
	}
}

public class Shop {
	public static void main(String[] args) {
		SuperCar ferrari = new SuperCar(); // SuperCar 클래스의 객체 ferrari를 구현(객체화(instance))

		String msg = "1.시동켜기\n2.시동끄기", pwMsg = "비밀번호 : ", pw = null;
		Scanner sc = new Scanner(System.in);
//      choice: 사용자가 입력한 메뉴 번호
//      count: 비밀번호 오류 횟수
		int choice = 0, count = 0;
//      FLAG : 해당 영역에서 연산된 결과를 다른 영역에서 사용하고자 할 때 
		boolean stopedEngine = false;

		do { // 무조건 처음에 한 번은 실행하기 위해 do-while 을 사용한다.
			System.out.println(msg); // 시동 켜기와 끄기 질문
			choice = sc.nextInt(); // choice 변수에 1 또는 2를 넣는다.

			switch (choice) { // 1번 또는 2번을 골랐을 때 경우의 수를 고르면 되기 때문에 switch문을 사용한다.
			case 1: // 시동 켜기
				if (!ferrari.check) { // ferrari객체의 check(시동)이 false라면(꺼져있다면)
					System.out.print(pwMsg); // 비밀번호 입력창을 띄운다.
					pw = sc.next(); // pw 변수에 사용자가 입력한 비밀번호를 대입시킨다.
					if (ferrari.checkPassword(pw)) { // 만약 실제 패스워드와 입력한 패스워드가 같다면
						ferrari.engineStart(); // 시동 걸기 성공
						count = 0; // 시동 실패 횟수를 0으로 초기화한다. -> 만약 이게 없다면, 비밀번호 실패 횟수를 연속해서 3번이 아닌, 누적 3번 오류 시 경찰 출동
									// 메세지가 나오게 된다.
						System.out.println("시동 켜짐");
					} else { // 만약 실제 패스워드와 입력한 패스워드가 다르다면
						count++; // 비밀번호 오류 횟수 1회 추가
						System.out.println("비밀번호 오류 " + count + "회");
						if (count == 3) { // 만약 비밀번호 오류 횟수가 3회가 되었다면
							System.out.println("경찰 출동"); // 경찰출동 메세지 출력
						}
					}
					break; // 즉시 탈출
				}

				System.out.println("이미 시동이 켜져있습니다."); // ferrari객체의 시동이 이미 켜져있기 때문에 if문에 들어가지 않고 해당 메세지 출력
				break; // 여기서 break를 걸지 않으면 case 2(시동끄기)도 실행됨
			case 2: // 시동 끄기
//        	 시동 끄기를 시도한 결과를 soptedEngine Flag에 담아준다.
				if (stopedEngine = ferrari.engineStop()) { // 만약 ferrari의 시동이 켜져있다면, -> stopedEngine은 false로 초기화해놨기 때문에
					System.out.println("시동 꺼짐");
					break; // 즉시 탈출
				}
				System.out.println("이미 시동이 꺼져있습니다."); // ferrari객체의 engineStop이 true(
				break; // case 2가 끝났으므로 break
			}
		} while (!stopedEngine && count != 3); // count(비밀번호 오류)가 3회가 되지 않았거나, stopEngine이 true가 되지 않았을 경우 반복을 지속한다.
												// !stopedEngine =true 는 시동 끄기를 성공했을 때를 의미
												// 비밀번호 입력이 3번 연속 실패했거나, 시동을 껐을 경우에 반복문을 탈출한다.
	}
}
