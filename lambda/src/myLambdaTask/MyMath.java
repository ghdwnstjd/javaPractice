package myLambdaTask;

import java.util.Scanner;

//* 몇 개의 정수를 받는지 상관없고, 덧셈, 뺄셈의 개수에 따라 배열의 길이가 결정됨 -> calc 추상메소드 선언(함수형 인터페이스 제작) 
//1) 계산식을 입력받는다			-> 전체 식을 전달받은 후 String[]로 리턴하는 getOpers 추상메소드 선언(함수형 인터페이스 제작)
//2) 정수만 문자열 배열로 담는다.		-> split 사용
//3) 담은 문자열 배열을 정수형으로 바꾼다	-> 함수형 인터페이스를 리턴하는 static 메소드 선언(람다식 리턴)
//4) 계산한다				-> main메소드에 getOper를 람다식으로 구현
//5) 출력한다 

public class MyMath {

	public static Calc calculator(String oper) { //	외부에서 연산자를 한 개 전달받는다.
//		이 메소드는 덧셈, 뺄셈을 하나는게 아니라 계산을 할 준비가 되었다는 것
		Calc c = null;
		switch(oper) {
		case "+" :
			c = (n1, n2) -> n1 + n2;
			break;
			
		case "-" :
			c = (n1, n2) -> n1 - n2;
			break;
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		
		String[] calculateResult = null, stringCalc=null;
		String operResult = "";
		int[] check = null;
		int n=0, num1 =0, num2 =0;
		
		GetOper getOper = (ex) -> { 
//		식 전체를 문자열 배열로 리턴 받음
//		getOper.checkOpers(ex)[0] = "+"
//		getOper.checkOpers(ex)[1] = "-"
			return "+-".split(""); 
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("계산할 식을 입력해주세요.(띄어쓰기 금지)");
		String calculate = sc.next();
		
		calculateResult = getOper.checkOpers(calculate); // +, -가 하나씩 담김
		
		check = new int[2]; 
		
//		2중 for문을 돌려서 동일한 게 있는지 확인하고(중간에 끊기 금지-> 연산자가 1개가 아닐 수도 있기 때문)
		for (int i = 0; i < calculateResult.length; i++) { //+, - 니까 i는 0, 1 두 개
			char b = calculateResult[i].charAt(0); //b에는 + 또는 -가 담긴다.
			for (int j = 0; j < calculate.length(); j++) { //입력한 수식 길이만큼 담긴다.
				char c = calculate.charAt(j);    // 계산하고자 하는 전체 수식이 c에 한 글자씩 담긴다.
				if(b==c) { //입력한 수식에 기재한 + 또는 - 연산자를 찾았을 때
					check[i]++; //check[0]에 1이 더해지면 +, check[1]에 1이 더해지면 -
				}
			}
		}
		
//		두 정수를 저장할 변수(배열)
		stringCalc = new String[2]; // 두 정수의 합을 구하는 식이므로 길이가 2인 배열을 설정한다.
		
//		split 기준이 +일 때
		if(check[0] == 1) { //첫 숫자가 음수여도 +부호 기준으로 숫자가 나뉘어서 상관없다. 
			stringCalc = calculate.split("\\+"); // +기호를 기준으로 두 정수를 나눈다.
			operResult = "+"; 
		} 
//		split 기준이 - 일 때(첫 숫자가 음수일 때 포함)
		else if(check[1] >=1) { // - 기호가 1개 이상 나올 때
			stringCalc = calculate.split("\\-"); // -기호를 기준으로 두 정수를 나눈다.
			operResult = "-";
		}
		
		if(check[1]>1) { //-부호가 2개 이상일 때
			System.out.println(stringCalc[0]);
			n++; //n에 1을 더한다. -> 첫 글자가 -면 배열의 첫 값은 없는 것으로 나오고 숫자가 있는 공간은 1칸 씩 뒤로 밀린다. 
			num1 = -Integer.parseInt(stringCalc[n]);
			num2 =  Integer.parseInt(stringCalc[n+1]);
		} else {
			num1 = Integer.parseInt(stringCalc[n]);
			num2 = Integer.parseInt(stringCalc[n+1]);			
		}
		
		System.out.println(calculator(operResult).calc(num1, num2));
		
	}
}