package methodTest;

import java.util.Scanner;

import com.sun.net.httpserver.Authenticator.Result;

public class MyMethodTask {
	
//	1~10까지 println()으로 출력하는 메소드
	void numbering(){
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);
		}
	}
	
//	"홍길동"을 n번 println()으로 출력하는 메소드
	void gildongCall(int calling){
		for (int i = 0; i < calling; i++) {
			System.out.println("홍길동");
		}
	}
	
//	이름을 n번 println()으로 출력하는 메소드
	void nameCall(String name, int count){
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}
	
//	세 정수의 뺄셈을 해주는 메소드
	int threeMinus(int num1, int num2, int num3){
		int result = num1 - num2 - num3;
		return result;
	}
	
//	두 정수의 나눗셈을 해주는 메소드(몫과 나머지 둘 다)
	int[] division(int num1, int num2){
	
		//배열 만들기
		int[] divisionAr = new int[2];

		//분모가 0인 경우 예외처리
		if(num2==0) {
			System.out.println("분모는 0이 될 수 없습니다.");
		}
		//두 정수 나눗셈 진행
		else {
			int resultPortion = num1 / num2; // 몫
			int resultRemainder = num1 % num2; // 나머지
			divisionAr[0] = resultPortion; 
			divisionAr[1] = resultRemainder;
		}
		return divisionAr;
	}
//	=============================================
//	선생님이 푼 거
	int[] divide(int num1, int num2){
		int[] results = null;
		
		if(num2 !=0) {
			results = new int[2];
			
			results[0] = num1 / num2;
			results[1] = num1 % num2;
		}
		return results;
	}
	
//	=============================================
	
	
//	1~n까지의 합을 구해주는 메소드
	int sumNumber(int number){
		int total = 0;
		for (int i = 0; i < number; i++) {
			total += i+1;
		}
		return total;
	}
	
//	=============================================
	
//	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int changeNumber(int number){
		number +=1;
		return number;
	}
	
//	=============================================
	
//	문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String changeCapital(String word){
		String result = "";
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i); //문자열 나누기
			
			//대문자
			if(c >=65 && c <= 90) {
				result += (char)(c+32);
			}
			
			//소문자
			else if(c>=96 && c<=122){
				result += (char)(c-32);
			}
			//그 외
			else {
				result +=c;
			}
		}
		return result;
	}
	
//	=============================================
	
//	문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//	word는 원하는 문자를 뜻하는 것
	int countingWord(char word){
		
		String str = null, msg = "문자열 입력: ";
		int count = 0;
		
//		입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		str=sc.next();
		
		//입력받은 문자열(str)의 1차원 배열 길이 정하기
		int[] strNumber = new int[str.length()];
		
		//문자열을 각 자리별로 나누고 배열에 넣기
		for (int i = 0; i < str.length(); i++) {
			strNumber[i] = str.charAt(i); //문자열 나누고 배열에 넣기
		}
		
		//원하는 문자(word)와 일치하는 문자열(str)에서의 문자 개수 구하기
		for (int i = 0; i < strNumber.length; i++) {
			if(word == strNumber[i]) {
				count += 1;
			}
		}
		
		return count;
		
	}
	
//	=============================================
	
//	5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	void findingNumber(){
		
		String numberInput ="정수 입력 ", msg = "원하는 값의 순서를 입력하세요.";
		int result = 0;
		
		int[] numberHouse = new int[5];
		
		//5자리 배열 만들기
		numberHouse = new int[5];

		
		//배열 안에 5개의 정수 입력하기
		for (int i = 0; i < 5; i++) {
			System.out.print(numberInput +(i+1) + "번째: ");
			Scanner sc = new Scanner(System.in);
			numberHouse[i] = sc.nextInt();
		}
		
		//원하는 값 입력
		System.out.println(msg);
		Scanner scSecond = new Scanner(System.in);
		
		//리턴값
		result = scSecond.nextInt();
		if(result<=5&&result>=1) {
			result = numberHouse[result-1];
			System.out.println(result);
		}
		else {
			result = 0;
			System.out.println("1~5까지만 입력 가능합니다.");
		}
		
	}
	
//	=============================================
	
//	한글을 정수로 바꿔주는 메소드(일공이사 -> 1024), indexOf() 사용
	String changeStringToNumber(String stringNumber){
		String stringNumberSet = "공일이삼사오육칠팔구", realNumberSet = "0123456789", finalResult="";
		char result;
		int findingNumberLocation = 0;
		
//		입력한 숫자 배열로 만들어주기
		for (int i = 0; i < stringNumber.length(); i++) {
			findingNumberLocation = stringNumberSet.indexOf(stringNumber.charAt(i));  //입력한 글자의 각 숫자 위치 찾기
			
			// 위치에 맞는 실제 숫자 입력
			result = (char)realNumberSet.charAt(findingNumberLocation);
			finalResult += result;
		}		
		
		return finalResult;

	}
	
//	=============================================
	
//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	int[] findMaxMinNumber(){
		String inputMessage="번 째 정수 입력: ";
		int maxNumber =0, minNumber = 0;
		
//		배열만들기
		int[] numberAr = new int[5];
		
		//5개 정수 입력받기
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) { // 숫자를 5개만 받기 위해 length가 아닌 상수 5를 기재함
			System.out.print(i+1 + inputMessage);
			numberAr[i] = sc.nextInt();   //배열에 입력한 정수 추가
		}
		
//		숫자 비교, 만약 초기화된 상태로 대소비교를 한다면, 음수만 입력했을 경우 최대값이 0으로 고정되고, 
//		양수만 입력했을 경우 최소값이 0으로 고정되기 때문에 배열의 첫 값으로 임의지정하고 대소 비교를 진행한다.
		maxNumber = numberAr[0];
		minNumber = numberAr[0];		
		for (int i = 0; i < numberAr.length; i++) {
			if(maxNumber<numberAr[i]) {
				maxNumber = numberAr[i];
			}
			if(minNumber>numberAr[i]) {
				minNumber = numberAr[i];
			}
		}
		
//		최대값과 최소값을 받을 배열 추가
		int[] resultAr = new int[2];
		resultAr[0] = maxNumber;
		resultAr[1] = minNumber;
		
		return resultAr;
	}
	
//	=============================================
	
//	-------------------어려운 버전-------------------
//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력없이 사용하는 부분에 결과를 전달한다.)
	void findMaxMinNumberHarVersion() {
		String inputMessage="번 째 정수 입력: ";
		int maxNumber =0, minNumber = 0;
		
//		배열만들기
		int[] numberAr = new int[5];
		
		//5개 정수 입력받기
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) { // 숫자를 5개만 받기 위해 length가 아닌 상수 5를 기재함
			System.out.print(i+1 + inputMessage);
			numberAr[i] = sc.nextInt();   //배열에 입력한 정수 추가
		}
		
//		숫자 비교, 만약 초기화된 상태로 대소비교를 한다면, 음수만 입력했을 경우 최대값이 0으로 고정되고, 
//		양수만 입력했을 경우 최소값이 0으로 고정되기 때문에 배열의 첫 값으로 임의지정하고 대소 비교를 진행한다.
		maxNumber = numberAr[0];
		minNumber = numberAr[0];		
		for (int i = 0; i < numberAr.length; i++) {
			if(maxNumber<numberAr[i]) {
				maxNumber = numberAr[i];
			}
			if(minNumber>numberAr[i]) {
				minNumber = numberAr[i];
			}
		}
		
//		최대값과 최소값을 받을 배열 추가
		int[] resultAr = new int[2];
		resultAr[0] = maxNumber;
		resultAr[1] = minNumber;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
////		1번
////		heap 할당
//		MethodTask firstAnswer = new MethodTask();
//		firstAnswer.numbering();

////		2번
////		heap 할당
//		MethodTask secondAnswer = new MethodTask();
//		secondAnswer.gildongCall(3);
		
		
////		3번
////		heap 할당
//		MethodTask thirdAnswer = new MethodTask();
//		thirdAnswer.nameCall("홍준성", 3);
		
		
////		4번
////		heap 할당
//		MethodTask fourthAnswer = new MethodTask();
//		int result = fourthAnswer.threeMinus(3, 4, 5);
//		System.out.println(result);
		
		
////		5번
////		heap 할당
//		MethodTask fifthAnswer = new MethodTask();
//		int[] result = fifthAnswer.division(2, 0);
//		System.out.println("몫: " + result[0]);
//		System.out.println("나머지: " + result[1]);

////	==========선생님이 푼 거===========================
//		MethodTask mt = new MethodTask();
//		int[] results = mt.divide(10,0);
//		String msg = null;
//		msg = results == null ? "0으로 나눌 수 없습니다." : "몫 : " + results[0] + "\n나머지 : " + results[1];
//		
//		System.out.println(msg);
//		=============================================
		
		
		MyMethodTask mt = new MyMethodTask();
//		1번
//		int result = mt.sumNumber(5);
//		System.out.println(result);
		
////		2번
//		int result = mt.changeNumber(3);
//		System.out.println(result);
		
////		3번
//		String result = mt.changeCapital("abcDDeS123@@#!");
//		System.out.println(result);
		
////		4번
//		int result = mt.countingWord('a');
//		System.out.println(result);
		
////		5번
//		mt.findingNumber();
		
////		6번
//		String result = "";
//		result = mt.changeStringToNumber("삼일구오");
//		System.out.println(result);
		
		
////		7번
//		int[] result = null;
//		result = mt.findMaxMinNumber();
//		System.out.println("--------------------------");
//		System.out.println("최대값: " + result[0]);
//		System.out.println("최소값: " + result[1]);
		
//		8번
				
	}
}
