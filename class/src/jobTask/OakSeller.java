package jobTask;

import java.util.Random;

public class OakSeller {
	
//	옥장판 판매원 게임
//	1. 옥장판 판매
//		1. 판매 성공 : 성공 시 각 직급별 1000만원, 3,000만원, 9,000만원 현금 증가, 처음 성공 확률: 50%, 성공 시 성공 확률 2% 감소
//		2. 대성공 : 성공 금액의 3배 현금 증가, 성공확률 5% 증가, 성공 시 대성공으로 이어질 확률 20%
//		3. 실패 : 현금 -2000만원 감소, 실패 확률 50%
//
//	2. 승진 
//		사원 : 초기 직급 
//		팀장 : 1억 소요, 30% 확률로 성공
//		다이아, 10억 소요, 10% 확률로 성공
//		3번 연속 판매 실패 시 직급 1개 강등, 사원일 경우 강등 없음

   String[] table = {"사원", "팀장", "다이아"};  //String 타입의 table 배열 생성 -> 이 배열에는 직급을 묶어둠
   int[] pay = {0, 10_000, 100_000}; // int 타입의 pay 배열 생성 -> 승진을 위해 소요되는 금액, 사원은 초기 직급이며 제일 낮은 직급이기 때문에 0이 들어간다.  
   int[] incomes = {1_000, 3_000, 9_000}; // int 타입의 incomes 배열 생성 -> 판매 성공 시 벌 수 있는 금액, 사원: 1,000만원, 팀장: 3,000만원, 다이아: 9,000만원
   
//   필드
   String name;			//판매원 게임 진행자의 이름
   int positionNumber;   //직급을 배열의 순서에 따라 기재하기 때문에 int형태로 받음. 
   int successRating;    //성공확률
   int income;				//수입
   int count;				//실패 시 count 추가, 성공 시 count 초기화
   
   Random r = new Random(); //객체 r에 Random 생성자를 집어넣음
   
   public OakSeller() { //Oakseller 생성자
      this("박재흠", 0); //OakSeller 생성자의 매개변수에 아무것도 넣지 않고 실행하면, name에 한동석, positionNumber에 0이 들어가 이름: 한동석, 직급은 사원으로 나오게 된다.
      						//여기서 this를 사용하면 필드의 주소값으로 아래에 기재한 OakSeller 생성자가 사용된다.
   }
   
   public OakSeller(String name, int positionNumber) { //OakSeller 생성자
      this.name = name;
      this.positionNumber = positionNumber;
      this.successRating = 50; //성공확률 50%를 디폴트로 추가한다.
   }
   
   int sell() { //성공 : 0, 대성공 : 1, 실패 : -1
      if(rate(successRating)) { //성공  -> rate 메소드 참고
         count = 0; //count 초기화, 3번 연속 
         if(rate(20)) { //대성공
            income += incomes[positionNumber] * 3; // 대성공시 얻는 현금은 기존의 3배 
            successRating += 5; //성공확률 5 증가
            return 1; // 대성공이므로 1 리턴
         }
         income += incomes[positionNumber]; // 일반 성공 현금 증가
         successRating -= 2; //성공확률 2 감소
         return 0; // 0 리턴
      }
      //실패
      count++; //실패 count 1 증가
      income -= 2_000; //현금 2,000 감소
      return -1; //-1 리턴
   }
   
   void demote() { //강등
      positionNumber--; //positionNumber 를 한 개 뺌으로서 배열에서 위치를 앞쪽으로 변경
      						   //사원일 경우 강등이 없지만, 이러한 조건은 메인 메소드에서 진행하면 된다. -> demote 메소드에서는 직급이 떨어진다는 것만 진행하면 됨
   }
   
   boolean promote() { //승진 성공 실패가 있으므로 return 값을 논리형으로 받는다.
      income -= pay[positionNumber+1];  // 승진을 위한 현금 감소 -> 현재 직급에서 다음 직급으로 승진하기 위해 필요한 금액에 맞게 배열 위치를 선택
      if(positionNumber == 0 ? rate(30) : rate(10)) { //직급이 사원이라면, 30% 성공확률, 아니라면(팀장이라면) 10% 성공확률 -> 이 확률이 맞게 되면 if문 안으로 들어온다. 
         positionNumber++; // 승진이 되어 positionNumber 1 증가
         return true; //true 리턴
      }
      return false; //승진 실패로 false 리턴
   }
   
   boolean rate(int rating) { // int 값을 매개변수로 받는 rate 메소드
      int[] percent = new int[100]; 	//100칸짜리 정수형 배열 percent 생성
      for (int i = 0; i < rating; i++) {percent[i] = 1;} //매개변수의 값에 따라 0이 1로 바뀌기 때문에, 1단위로 확률을 기재할 수 있다. 즉, rate(숫자) 에서 숫자의 값이 확률값이다. 숫자는 1~100까지 기재 가능
      
      return percent[r.nextInt(percent.length)] == 1; // 리턴값은 boolean 형태로 percent[r.nextInt(percent.length)] 가 1이 나오면 true, 0이면 false를 리턴한다.
   }
}
