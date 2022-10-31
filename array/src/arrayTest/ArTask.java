package arrayTest;

import java.util.Iterator;
import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
				
//	브론즈
//	1~10까지 배열에 담고 출력
//		// 배열 만들기
//		int[] arDataBronzeOne = new int[10];
//		
//		// 배열에 담기
//		for (int i = 0; i < arDataBronzeOne.length; i++) {
//			arDataBronzeOne[i] = i+1;
//		}
//		
//		// 출력
//		for (int i = 0; i < arDataBronzeOne.length; i++) {
//			System.out.println(i+1 + ". " + arDataBronzeOne[i]);
//		}
		
//	10~1까지 중 짝수만 배열에 담고 출력
//		//배열 만들기
//		int[] arDataBronzeTwo = new int[5];
//		
//		//배열에 담기
//		for (int i = 0; i < arDataBronzeTwo.length; i++) {
//			arDataBronzeTwo[i] = (5-i) * 2;
//		}
//		
//		
//		//출력
//		for (int i = 0; i < arDataBronzeTwo.length; i++) {
//			System.out.println(i+1 + ". " + arDataBronzeTwo[i]);
//		}
		
//	1~100까지 배열에 담은 후 홀수만 출력
//		//배열 만들기
//		int[] arDataBronzeThree = new int[100];
//		
//		//배열에 담기
//		for (int i = 0; i < arDataBronzeThree.length; i++) {
//			arDataBronzeThree[i] = i+1;
//		}
//		
//		//출력
//		for (int i = 0; i < arDataBronzeThree.length; i++) {
//			if(arDataBronzeThree[i]%2==0) {
//				continue;
//			}
//			
//			System.out.println(arDataBronzeThree[i]);
//			
//		}
		
//	실버
//	1~100까지 배열에 담은 후 짝수의 합 출력
//		//합을 구할 변수 
//		int sum= 0;
//		//배열 만들기
//		int[] arDataSilverOne = new int[100];
//				
//		//배열에 담기
//		for (int i = 0; i < arDataSilverOne.length; i++) {
//			arDataSilverOne[i] = i+1;
//		}
//				
//		//출력
//		for (int j = 0; j < arDataSilverOne.length; j++) {
//			if(arDataSilverOne[j]%2==0) {
//				sum += arDataSilverOne[j];
//			}
//		}
//		System.out.println("1~100까지 짝수의 합: " + sum);

		
//	A~F까지 배열에 담고 출력
//		//배열 만들기
//		char[] arDataSilverTwo = new char[6];
//				
//		//배열에 담기
//		for (int i = 0; i < arDataSilverTwo.length; i++) {
//			arDataSilverTwo[i] = (char)(65+i);
//		}
//		
//		//출력
//		for (int i = 0; i < arDataSilverTwo.length; i++) {
//			System.out.println(arDataSilverTwo[i]);
//		}
		
		
//	A~F까지 중 C제외하고 배열에 담은 후 출력
//		//배열 만들기
//		char[] arDataSilverThree = new char[5];
//		
//		//배열에 담기
//		for (int i = 0; i < arDataSilverThree.length; i++) {
//			if(i >= 2) {
//				arDataSilverThree[i] = (char)(66+i);
//			}
//			else {
//				arDataSilverThree[i] = (char)(65+i);
//			}
//		}
//		
//		//출력
//		for (int j = 0; j < arDataSilverThree.length; j++) {
//			System.out.println(arDataSilverThree[j]);
//		}
		
//		2번째 방법
//		char[] arData = new char[5];
//		for(int i =0; i<arData.length; i++) {
//			arData[i] = (char)(i>1?66+i : 65+i);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		
//	골드
//	5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		
//		int max = 0, min = 0;
//		String msg = "5개의 정수 입력: ";
//		
//		int[] arData = new int[5];
//		Scanner sc = new Scanner(System.in);
//		
//		
//		//5개 정수 입력받기
//		System.out.print(msg);
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = sc.nextInt();
//		}
//		
//		//최대값, 최소값 구하기
//		max = arData[0];
//		min = arData[0];
//		for (int i = 0; i < arData.length; i++) {
//			if(max<arData[i]) {
//				max = arData[i];
//			}
//			if(min>arData[i]) {
//				min = arData[i];
//			}
//		}
//		
//		System.out.println("최대값: "+max);
//		System.out.println("최소값: "+min);
		
		
		
		//============선생님이 푼 것================		
//		int[] arData = new int[5];
//		Scanner sc = new Scanner(System.in);
//		String msg = "5개의 정수를 입력하세요.";
//		int max = 0, min = 0;
//		
//		//정수 입력하기
//		System.out.println(msg);
//		for(int i = 0; i<arData.length;i++) {
//			arData[i] = sc.nextInt();
//		}
//		
//		max = arData[0];
//		min = arData[0];
//		
//		//출력하기
//		for (int i = 0; i < arData.length; i++) {
//			if(max < arData[i]) {
//				max=arData[i];
//			}
//			if(min>arData[i]) {
//				min=arData[i];
//			}
//		}
//		
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
		
//	다이아
//	사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		
//		int[] arData = null;
//		Scanner sc = new Scanner(System.in);
//		
//		String numberMakingMsg = "입력할 정수의 개수 : ", numberingMsg = "번째 정수 : ";
//		int total = 0;
//		double avg = 0.0;
//		
//		//입력할 정수의 개수만큼 배열 만들기
//		System.out.println(numberMakingMsg);
//		arData = new int[sc.nextInt()];
//		
//		//정수 입력하기
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(i+1+numberingMsg);
//			arData[i] = sc.nextInt();
//		}
//		
//		//입력받은 정수의 총합 구하기
//		for (int i = 0; i < arData.length; i++) {
//			total += arData[i];
//		}
//		
//		//평균 구하기
//		avg = (double)total / arData.length;
//		avg = Double.parseDouble(String.format("%.2f", avg));
//		System.out.println("평균 값 : " + avg);
		
		
		
		//============선생님이 푼 것================
//		int[] arData = null;
//		Scanner sc = new Scanner(System.in);
//		String countingMsg = "입력할 정수의 개수 : ", msg = "번째 정수: ";
//		int total= 0;
//		double avg= 0.0;
//		System.out.println(countingMsg);
//		
//		// 배열의 길이 입력
//		arData = new int[sc.nextInt()];
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.print(i+1+msg);
//			arData[i]=sc.nextInt();
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			total += arData[i];
//		}
//		
//		avg = (double) total / arData.length;
//		avg = Double.parseDouble(String.format("%.2f", avg));
//		System.out.println("평균값: " + avg);
		
	}
}
