package classTest;

import java.util.Random;

public class Animal {

   String name;
   int age;
   String feed;
   int feedCount;
   int life;
   
   public Animal() {;} // 기본 생성자
   
   public Animal(String name, int age, String feed, int feedCount, int life) { //초기화 생성자
      this.name = name; //동물 이름
      this.age = age; // 나이
      this.feed = feed; // 먹이
      this.feedCount = feedCount; //먹이 개수
      this.life = life; // 생명
   }

   void eat() { //eat 메소드로 들어올 경우 먹이개수가 1개 줄고, 생명이 한 개 증가한다.
      feedCount--; 
      life++;
   }
   
   void sleep() { //sleep 메소드로 들어올 경우 생명이 한 개 증가한다.
      life++;
   }
   
//   외부에서 모든 문제를 전달받는다.
//   전달받은 문제 중 랜덤한 한 개의 문제만 리턴한다.
   Quiz walk(Quiz[] quizes) { // Quiz클래스의 필드를 사용하여 Zoo클래스에 만든 Quiz 배열 quizes를 매개변수로 사용한다.
      life--; //산책 시 생명 하나 감소
      
      Random r = new Random(); // 랜덤으로 퀴즈를 제공하기 위한 랜덤 함수 사용하여 r객체 생성
      Quiz quiz = null; //Quiz 클래스에 quiz 객체 생성 
      int[] percent = new int[10]; // percent라는 길이 10개짜리 배열 생성, 잭팟 문제가 10% 확률로 나오기 때문에 10개짜리 배열을 초기화
      int rating = 10; //10%의 확률이므로 상수로 10을 제공
      
//      잭팟 문제, 확률은 10%
//      확률이 10단위라면 10칸 배열을, 1단위라면 100칸 배열을 선언한다.
//      int배열로 선언한 뒤 사용자가 원하는 확률 만큼 1로 값을 바꿔준다.
      
//      예) 30% 확률이라면 10칸 배열에 3개의 값만 1로 바꿔준다.
//      따라서 원하는 확률 / 10 을 하여 반복횟수를 결정해주고,
//      그 만큼 1이 들어가게 된다.
      
//      위의 배열이 완성되었으면 랜덤한 인덱스번호로 값에 접근하여
//      1이 나왔을 때에는 원하는 확률로 성공한 것이고,
//      0이 나왔을 때에는 실패한 것이다.
      
      for (int i = 0; i < rating / 10; i++) {  // '원하는 확률 / 10 을 하여 반복횟수를 결정해주고'가 이걸 뜻하는 것
         percent[i] = 1; // 반복문을 통해 percent[0]만 1로 바꿔주고, 나머지는 초기화한 상태 그대로이기 때문에 만약 1이 뽑힌다면 10%의 확률이 만들어짐
      }
      
      if(percent[r.nextInt(percent.length)] == 1) { //random.nextInt(0부터 나올 수 있는 숫자 범위-1) 이므로, percent[0]부터 percent[9]까지 나올 수 있다. 그 중 percent[0]만 1이므로 10%확률로 if문이 true가 된다.
         for (int i = 0; i < quizes.length; i++) { // 퀴즈 문제 랜덤으로 돌리기 위해 전체 길이로 i의 범위 설정
            if(quizes[i].jackpot) { // jackpot은 boolean 타입이므로 잭팟 문제가 맞을 경우 true로 바뀐다. 잭팟문제만 boolean이 들어가있는 오버로딩을 이용.
               return quizes[i]; // jackpot 문제가 맞을 경우 해당 문제가 포함된 배열을 리턴한다. 
            }
         }
      }
      // 잭팟 문제가 아닌 일반 문제일 경우
      // 여기서 랜덤으로 뽑은 배열이 또 잭팟문제일 수도 있기 때문에, 잭팟 문제가 나올 경우 다시 일반 문제가 나오도록 반복문을 돌린다.
      while(true) { 
         quiz = quizes[r.nextInt(quizes.length)]; //quiz 변수 = 랜덤으로 뽑은 문제 배열 중 하나
         if(!quiz.jackpot) {break;} //만약 잭팟 문제가 아닐 경우 끝, 
      }
      
      return quiz; //일반 문제를 리턴한다.
   }
}