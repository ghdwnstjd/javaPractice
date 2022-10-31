package myClassTest;

import java.util.Scanner;

//모여라 셀럽동물
//※ 주의사항
//- 육식동물 금지
//
//이름, 나이, 먹이, 먹이개수, 생명 : 필드 사용   

class CelebrateAnimal {
	String name; // 이름
	int age; // 나이
	String food; // 먹이
	int foodCount; // 먹이개수
	int lifeCount; // 생명

	boolean isFood; // 먹이가 있는지 확인
	boolean isWalk; // 산책이 가능한 지 확인

	public CelebrateAnimal(String name, int age, String food, int foodCount, int lifeCount) {

		this.name = name;
		this.age = age;
		this.food = food;
		this.foodCount = foodCount;
		this.lifeCount = lifeCount;
	}

//	1. 먹기
//  먹이가 있다면,   <- 먹이가 있는지 일단 먼저 확인
//  먹이 1개 사용, 생명 1 회복

	void eatFood() {

		// 먹기
		if (!isFood) {
			foodCount --; // 먹이 한 개 감소
			lifeCount ++; // 생명 한 개 증가

			// 먹이가 있는지 없는 지 확인
			if (foodCount == 0) {
				isFood = true; // 먹이가 없다면 isFood는 true로 바꿔서 isFood if 문을 벗어남
			}
		}
	}

//  2. 자기
//  3초동안 생명 1 회복
	void sleep() {
		System.out.println("강제 취침모드 중(sleep으로 넘어가는지 테스트용)");
	}

//	3. 산책하기
//  무족건 생명 1 감소
//  랜덤(<-구글링)한 퀴즈를 출력하고 정답을 맞추면 먹이 2개 획득
//  오답 시 생명 1 감소 
//  생명이 0이 되었다면 강제로 잠재우기	

//	외부에서 모든 문제를 전달받는다.
//	전달받은 문제 중 랜덤한 한 개의 문제만 리턴한다.
	void walk() {
		// 만약 생명이 1이라면, 산책이 불가함
		
		if(!isWalk) {
			lifeCount --; //생명 1개 감소
			
			//랜덤 퀴즈 풀기
			MyQuiz qz = new MyQuiz();
			qz.test();
			if(qz.isCorrect) {
				foodCount = foodCount+2;
				System.out.println("먹이 두 개 증가\n현재 보유 먹이: " + foodCount);
			}
			if(!qz.isCorrect) {
				lifeCount--;
				System.out.println("오답. 생명이 한 개 감소합니다. \n현재 보유 생명: " + lifeCount);
			}
			
			if(lifeCount <= 0) { 
				sleep(); //생명이 0이 되었으므로 강제로 취침모드로 전환
				isWalk = true; // 더이상 산책을 할 수 없도록 변환
			}
		}
		else {
			sleep(); //생명이 0이 되었으므로 강제로 취침모드로 전환			
		}
	}
}

public class MyAnimal {
	public static void main(String[] args) {
		CelebrateAnimal ca = new CelebrateAnimal("토끼", 1, "당근", 2, 2);

		String choiceMsg = "1.먹기\n2.자기\n3.산책하기\n4.나가기\n선택: ";
		int choice = 0; // 첫 선택 시 사용할 변수

		// 먹기, 자기, 산책하기, 나가기 중 고르기
		while (choice != 4) {
			Scanner sc = new Scanner(System.in);
			System.out.print(choiceMsg);
			choice = sc.nextInt(); // 선택창
			switch (choice) {
			case 1: // 먹기
				// 먹이가 있는지 먼저 확인한 후, eatFood 메소드 실행
				if (!ca.isFood) {
					ca.eatFood();
					System.out.println("--------------------------------");
					System.out.println("먹이를 하나 먹었습니다.\n남은 먹이: " + ca.foodCount + "\n남은 생명: " + ca.lifeCount);
					break;
				} else {
					System.out.println("--------------------------------");
					System.out.println("더이상 먹이가 없습니다.\n남은 먹이: " + ca.foodCount + "\n남은 생명: " + ca.lifeCount);
					break;
				}
			case 2: // 자기
				ca.sleep();
				break;

			case 3: // 산책하기
				if(!ca.isWalk) {
					ca.walk();
					System.out.println("--------------------------------");
					System.out.println("산책을 했습니다.\n남은 생명: " + ca.lifeCount);
					if(ca.lifeCount ==0) {
						System.out.println("강제 취침 모드로 전환(테스트용)");
					}
					break;

				} else {
					System.out.println("--------------------------------");
					System.out.println("더이상 생명을 소진할 수 없어 산책이 불가합니다.\n남은 생명: " + ca.lifeCount);
					break;
				}
				
			case 4: //작별 인사하기
				System.out.println("게임 종료");
				break;
			}

		}

	}

}
