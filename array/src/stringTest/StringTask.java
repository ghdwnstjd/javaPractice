package stringTest;

import java.util.Iterator;
import java.util.Scanner;

public class StringTask {
	public static void main(String[] args) {
////		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
////		대문자는 모두 소문자로 변경한다.
////		
//		String msg = "문자열 입력 : ", msgResult = "";
//		char word;
//		int msgNumber = 0;
//
//		// 입력하기
//		Scanner sc = new Scanner(System.in);
//		System.out.print(msg);
//		
//		msgResult = sc.next();
//		
//		//출력하기
//		for (int i = 0; i < msgResult.length(); i++) {
//			if(msgResult.charAt(i)>=97&&msgResult.charAt(i)<123) {
//				word = (char)(msgResult.charAt(i) - 32);
//				
//			}
//			
//			else if(msgResult.charAt(i)>=65&&msgResult.charAt(i)<91) {
//				word = (char)(msgResult.charAt(i) + 32);
//				System.out.print(word);
//			}
//		// 특수문자에 대한 예외처리가 없음. else로 추가해야함
//			else {
//				word = msgResult.charAt(i);
//				
//			}
//		System.out.print(word);
//		}
		
		
//		// ==========================================================
//		// 선생님이 푼 것
//		Scanner sc = new Scanner(System.in);
//		String str = null, result = "", msg = "문자열 : "; // 누적 연결을 할 때는 ""(빈 문자열)로 초기화, 대입을 할 때는 null로 초기화
//		
//		System.out.print(msg);
//		str = sc.nextLine();
//		
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if(c >=65 && c <= 90){ //대문자
//				result += (char)(c + 32); //result가 빈문자열로 초기화되어 있기 때문에 string과 char가 연결이 된다.
//			}
//			else if(c>=96 && c<=122){ //소문자
//				result +=(char)(c-32);
//			} else {
//				result +=c;
//			}
//		}
//		
//		System.out.println(result);
//			
//		// ==========================================================
//		
//		
//		
////		정수를 한글로 변경
////		예)1024 -> 일공이사
//		
//		// 한글로 정수 집어넣기
//		String[] hangleNumberData = {"공","일","이","삼","사","오","육","칠","팔","구"}; 
//		String msg = "숫자를 입력하세요.", num = "", result = "", resultLater = "";
//		int numConvert = 0;
//		
//		// 입력하기
//		Scanner sc = new Scanner(System.in);
//		System.out.println(msg);
//		
//		// 입력한 정수 num에 저장(String형태로)
//		num = sc.next();
//		
//		// 입력값 자리수별로 각 위치 찾기
//		numConvert = Integer.parseInt(num);
//		for (int i = 0; i < num.length(); i++) {
//			//2~n번째 자리 숫자
//			if(numConvert/10 != 0) {
//				resultLater = hangleNumberData[numConvert%10];
//				numConvert = numConvert/10;
//				result = resultLater + result;
//			}
//			//일의 자리 숫자
//			else {
//				resultLater = hangleNumberData[numConvert%10];
//				result = resultLater+result;
//			}
//		}
//		System.out.println(result);
		
//		// ==========================================================
//		// 선생님이 푼 것1
//		
//		int number = 0;
//		Scanner sc = new Scanner(System.in);
//		String msg = "정수 : ", hangle = "공일이삼사오육칠팔구", result = "";
//		
//		System.out.print(msg);
//		number = sc.nextInt();
//		
//		//몇 자리 수인지 모르기 때문에 while문으로 사용
//		while(number != 0) {
//			result = hangle.charAt(number%10) + result;
//			number /= 10;
//		}
//		
//		System.out.println(result);
//
//		// ==========================================================
//		// 선생님이 푼 것2. 문자열로 풀기
		Scanner sc = new Scanner(System.in);
		String msg = "정수 : ", hangle = "공일이삼사오육칠팔구", result = "", number=null;
		
		System.out.print(msg);
		number = sc.next();
		
		for (int i = 0; i < number.length(); i++) {
			result += hangle.charAt(number.charAt(i) - 48); //한글 인덱스 번호를 숫자로 바꿔주기 위해 48을 뺌(아스키코드) 
		}
		
		System.out.println(result);
//
//		// ==========================================================
	}
}
