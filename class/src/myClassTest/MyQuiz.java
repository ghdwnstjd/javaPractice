package myClassTest;

import java.util.Scanner;

public class MyQuiz {
	
	String question;
	String answer;
	int foodCount;
	int questionNumber;
	
	boolean isCorrect;

//	기본 생성자
	public MyQuiz() {;}
	
//	초기화 생성자
	public MyQuiz(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	boolean test() {
		//퀴즈 리스트 넣기
		MyQuiz[] quizList = null; 
		quizList = new MyQuiz[10];
		
		quizList[0] = new MyQuiz("내 이름은?", "홍준성");
		quizList[1] = new MyQuiz("내 핸드폰 뒷자리 번호는?", "1601");
		quizList[2] = new MyQuiz("내 나이는?", "31");
		quizList[3] = new MyQuiz("내 성은?", "홍");
		quizList[4] = new MyQuiz("내가 사는 곳은?", "분당");
		quizList[5] = new MyQuiz("내가 사는 주거 형태는?", "아파트");
		quizList[6] = new MyQuiz("나의 성별은?", "남");
		quizList[7] = new MyQuiz("1 더하기 1은?", "2");
		quizList[8] = new MyQuiz("1 더하기 2는?", "3");
		quizList[9] = new MyQuiz("1 더하기 3은?", "4");
		
		//랜덤으로 문제 넣기
		questionNumber = (int)(Math.random()*10+1); // 1~10 중 랜덤한 숫자가 나옴
		
		Scanner sc = new Scanner(System.in);
		System.out.println("★★★★★★돌발퀴즈★★★★★★\n" + quizList[questionNumber-1].question); //질문 나오기
		
		answer = sc.next(); // 내가 작성한 답안
		if(answer.equals(quizList[questionNumber-1].answer)) {
			System.out.println("정답!!!!!!!!!!!!!");
			isCorrect = true;
			return true;
		} isCorrect = false;
		return false;
	}
	
	//문제, 정답, 먹이개수
	public static void main(String[] args) {

		MyQuiz a = new MyQuiz();
		
		a.test();
		
		

	}
}
