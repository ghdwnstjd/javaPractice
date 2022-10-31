package classTest;

import java.util.Scanner;

public class Zoo {
   public static void main(String[] args) {
      Animal[] animals = { // Animal클래스의 초기화 생성자를 이용하여 animals 배열을 만든다.
            new Animal("코끼리", 120, "풀", 2, 8),
            new Animal("토끼", 3, "당근", 8, 3000),
            new Animal("타조", 5, "지렁이", 5, 5)
      };
      
      Quiz[] quizes = { //Quiz 클래스의 초기화 생성자를 이용하여 quizes 배열을 만든다.
            new Quiz("Q. 바나나를 엄마가 사왔어요!\n형이 3개 먹고 내가 5개를 먹었더니 한 개가 남았어요.\n엄마가 사온 바나나는 총 몇 개였을까요?", "9", 10),
            new Quiz("Q. 다음 어린이 중 누가 착한 행동을 했을까요?\n1. 요구르트를 훔친 철수\n2. 친구를 바닥에 눕힌 영희\n3. 늦게왔으면서 수업에 딴짓까지 해버리는 동석\n4. 엄마 어깨를 안마해주는 유리", "4", 2),
            new Quiz("Q. 횡단보도를 건널 수 있는 방법을 고르세요.\n1. 빨간불일 때 건넌다.\n2. 뛰어간다\n3. 손을 들고 초록불에 건넌다.\n4. 핸드폰을 보면서 건넌다.", "3", 5),
            new Quiz("Q. 다음 중 프로그래밍 언어가 아닌 것은?\n1.C언어\n2.JAVA\n3.파이썬\n4.망둥어", "4", 3000, true) // 잭팟 문제로, Quiz클래스에서 오버로딩을 통해 논리형을 추가, Animal 클래스에서 잭팟 문항을 거르기 위해 사용
      };
      
      Scanner sc = new Scanner(System.in);
      
      String title = "★▒ 모여라 셀럽동물 ▒★";
      String menuMessage = "안녕하세요 어린이 여러분!\n 동물친구를 선택해보세요!\n1.코끼리\n2.토끼\n3.타조\n4.나가기";
      String actionMessage = "1.먹기\n2.잠자기\n3.산책하기\n4.내 정보\n5.작별인사하기";
      int characterNumber = 0, actionChoice = 0;
      
      while(true) {
         System.out.println(title);
         System.out.println(menuMessage);
         characterNumber = sc.nextInt();
         if(characterNumber == 4) {break;} //4를 선택하면 종료
         
         while(true) {
            System.out.println(actionMessage);
            actionChoice = sc.nextInt();
            if(actionChoice == 5) {break;} //5를 선택하면 가장 바깥쪽의 while문으로 이동(현재 while문 종료)
            
            Animal animal = animals[characterNumber - 1]; //Animal 클래스의 객체 animal에 animals 배열을 animal에 담는다. -> 객체화(instance)
            															   //characterNumber -1 인 이유는 배열은 0부터 시작하고, 캐릭터 선택창은 1부터 시작하기 때문
            
            switch(actionChoice) {	// "1.먹기\n2.잠자기\n3.산책하기\n4.내 정보\n5.작별인사하기" 선택창 중 하나를 골랐을 때
            case 1: //먹기
               if(animal.feedCount > 0) { //보유한 먹이가 0개 초과일 경우
                  animal.eat();	//eat 메소드 실행, animal객체에 animals 배열 정보 중 하나를 넣었기 때문에, 해당 배열에 속한 animal을 움직인다고 생각하면 되고, Animal 클래스의 메소드를 사용할 수 있다.
                  System.out.println("냠냠 맛있어!");
                  System.out.println(animal.name + "의 체력 : " + animal.life);
                  System.out.println(animal.name + "의 먹이 개수 : " + animal.feedCount + "개");
                  break;
               }
               
               System.out.println(animal.feed + "이(가) 부족해요ㅠㅠ\n퀴즈를 풀어서 먹이를 획득하세요!"); // 보유한 먹이가 0개일 경우
               
               break;
            case 2: //잠자기
               System.out.print(animal.name + "이(가) 자는 중");
               for (int i = 0; i < 3; i++) { 
                  try {Thread.sleep(1000);} catch (InterruptedException e) {;} //3초간 정지
                  System.out.print("."); //for문으로 반복이 되므로, 1초당 "."이 한 번씩 나와 총 3개가 나온다.
               }
               animal.sleep(); //sleep 메소드 실행
               System.out.println(); 
               
               break;
            case 3: //산책하기
               if(animal.life > 1) { // 생명이 1개 초과, 즉 2개 이상일 때부터만 산책이 가능하다. 산책 시 무조건 생명 1개 감소, 퀴즈 틀리면 생명이 1개 감소되므로
                  Quiz quiz = animal.walk(quizes); //Quiz 클래스의 quiz를 Animal 클래스의 quizes 배열을 매개변수로 가지고 있는 walk 메소드로 전환한다.
                  if(quiz.jackpot) { //만약 잭팟 문제가 선택되었다면
                     System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
                     System.out.println("!!!!!!!!!!!!떳다!!!!!!!!!!!!");
                     System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
                  }
                  System.out.println(quiz.question);
                  
                  if(quiz.answer.equals(sc.next())) { //정답을 맞췄을 때
                     System.out.println("정답!!!!!!!");
                     animal.feedCount += quiz.feedCount; //먹이 개수 증가
                     System.out.println(animal.feed + " " + quiz.feedCount + "개 획득!");
                     System.out.println(animal.feed + " 개수 : " + animal.feedCount + "개");
                     break;
                  }
                  
                  System.out.println("오답이에요 ㅠㅠ");
                  animal.life--; //오답 시 생명 1개 감소
                  
                  if(animal.life == 0) { //생명이 0이 되었을 경우
                     System.out.print(animal.name + "이(가) 자는 중");
                     for (int i = 0; i < 3; i++) {
                        try {Thread.sleep(1000);} catch (InterruptedException e) {;}
                        System.out.print("."); 
                     }
                     animal.sleep(); //3초간 강제 sleep메소드 진행
                     System.out.println();
                  }
                  break;
               }
               
               System.out.println("체력이 부족해요 ㅠㅠ 잠을 자고 오세요!"); //만약 남은 생명이 1개 이하일 경우
               
               break;
            case 4:
               System.out.println("이름 : " + animal.name);
               System.out.println("나이 : " + animal.age + "살");
               System.out.println("먹이 : " + animal.feed);
               System.out.println("먹이 개수 : " + animal.feedCount);
               System.out.println("체력 : " + animal.life);
               break;
            default: //1~4가 아닌 다른 것을 입력했을 경우
               System.out.println("다시 입력해주세요!"); 
               break;
            }
         }
      }
   }
}









