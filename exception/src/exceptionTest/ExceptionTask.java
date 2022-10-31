package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//	5개의 정수만 입력받기
//	- 무한 입력 상태로 구현
//	- q 입력 시 나가기
//	- 5개의 정수는 배열에 담기
//	- if 문은 딱 한 번만 사용하기

		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];
		String msg = "번째 정수 : ", temp = null;
		int i = 0;

		while (true) {
			System.out.print(++i + msg);
			temp = sc.next();
			if (temp.equals("q")) {
				break;
			}

			try {
				arData[i - 1] = Integer.parseInt(temp);
			} catch (NumberFormatException e) { // 정수가 아닌
				System.out.println("정수만 입력해주세요.\n입력하기 전에 생각이란 걸 해봤나요? 제대로 입력하세요.");
				i--;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("5개만 입력가능합니다.");
				for (int j = 0; j < arData.length; j++) {
					System.out.print(arData[j] + " ");
				}
				break;
			} catch (Exception e) {
				System.out.println("?");
				i--;
			}
		}
	}
}
