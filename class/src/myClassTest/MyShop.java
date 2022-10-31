package myClassTest;

import java.util.Scanner;

class MySuperCar {
// 브랜드, 색상, 가격
	String brand, color;
	String passwordMsg, passwordCheckMsg, passwordCheckErrorMsg;
	int price, password, passwordCheckCount;

	boolean check;

	public MySuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	시동켜기
//	시동의 상태를 확인하고 
//	이미 시동이 꺼져있다면, "시동 켜기" 출력
//	이미 시동이 켜져있다면, "이미 시동이 켜져있습니다" 출력 
	void engineStart() {
		if (check) {
			System.out.println(brand + " 이미 시동이 켜져있습니다.");
		} else if (!check) {
			System.out.println(brand + " 시동 켜기");
			check = true;
		}
	}

//	시동끄기
//	시동의 상태를 확인하고 
//	이미 시동이 켜져있다면, "시동 끄기" 출력
//	이미 시동이 꺼져있다면, "이미 시동이 꺼져있습니다" 출력 
	void engineStop() {
		if (check) {
			System.out.println(brand + " 시동 끄기");
			check = false;
		} else if (!check) {
			System.out.println(brand + " 이미 시동이 꺼져있습니다.");
		}
	}

//	[심화]
//	시동을 켜기 위해서는 비밀번호 4자리를 입력해야한다.
//	입력한 비밀번호가 3회 연속 실패하면 "경찰 출동"메세지를 출력한다.

	void passwordMaking() {
		passwordMsg = "비밀번호를 설정하세요.";
		Scanner sc = new Scanner(System.in);
		System.out.println(passwordMsg);
		password = sc.nextInt();
	}

//	비밀번호 입력하기
//	시동 상태 먼저 확인한 후, 비밀번호 입력
	void passwordCheck() {
		if (!check) {
			while (passwordCheckCount != 3) {
				passwordCheckMsg = "패스워드를 입력하세요.";
				passwordCheckErrorMsg = "패스워드가 틀렸습니다.";
				System.out.println(passwordCheckMsg);
				Scanner sc = new Scanner(System.in);
				if (sc.nextInt() != password) {
					passwordCheckCount++;
					System.out.println(passwordCheckErrorMsg + "(" + passwordCheckCount + "회)");
				} else {
					System.out.println("비밀번호 확인, 시동 켜기");
					check = true;
					break;
				}
			}

		} else if (check) {
			System.out.println("이미 시동이 켜져 있습니다.");
		}
		
		if(passwordCheckCount==3) {
			System.out.println("경찰출동");
		}

	}
}

public class MyShop {
	public static void main(String[] args) {

		MySuperCar myCar = new MySuperCar("SONATA", "silver", 3_000);
	
		myCar.engineStart();
		myCar.engineStart();
		myCar.engineStop();
		myCar.engineStop();
		myCar.passwordMaking();
		myCar.passwordCheck();
		myCar.engineStart();

	}
}
