package exceptionTest;

import java.util.Scanner;

public class MyExceptionTask {
	
	
	public static void main(String[] args) {
//	5개의 정수만 입력받기
//	- 무한 입력 상태로 구현
//	- q 입력 시 나가기
//	- 5개의 정수는 배열에 담기
//	- if 문은 딱 한 번만 사용하기

		String quit = "", msg = "배열에 들어갈 정수를 입력해주세요.(나가기: q)";
		int count = 0, number = 0;

		int[] arNumber = new int[5];

		Scanner sc = new Scanner(System.in);

		System.out.println(msg);
		while (true) {

			quit = sc.next();

			if (quit.equals("q")|| quit.equals("ㅂ")) { // q 클릭 시에 종료 진행
				System.out.println("===================종료===================");
				break;
			}
			try {
				number = Integer.parseInt(quit); // q와 숫자를 다 넣어야하므로 parseInt로 number 조정
				arNumber[count] = number; // 배열에 숫자를 넣을 수 있다면 빈 위치부터 하나씩 추가
			} catch (ArrayIndexOutOfBoundsException e) { // 배열 이상의 숫자가 들어갔을 경우 생기는 오류
				System.out.println("===================");
				System.out.print("더이상 배열을 추가할 수 없습니다.\n현재 배열에 들어있는 숫자: ");
				for (int i = 0; i < arNumber.length; i++) {
					System.out.print(arNumber[i] + " "); // 배열에 속한 숫자 출력
				}
				System.out.println();
				System.out.println("===================");
				System.out.println(msg);
			} catch (Exception e) { // 그 외 오류
				System.out.println("알 수 없는 오류");
				System.out.println("--------------------");
				e.printStackTrace(); // 오류 위치 찾기
				System.out.println("--------------------");
			}
			count++; // 숫자 추가할 배열 위치 하나씩 증가
		}
	}

}
