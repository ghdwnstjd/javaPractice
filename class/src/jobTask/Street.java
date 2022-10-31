package jobTask;

import java.util.Scanner;

public class Street {
   public static void main(String[] args) {
      OakSeller seller = new OakSeller(); //OakSeller 클래스의 seller 객체 생성(객체화, instance)
      Scanner sc = new Scanner(System.in);
      
      String msg = "1. 판매하기\n2. 승진하기\n3. 내 정보\n4. 나가기";
      int choice = 0, resultSold = 0;
      
      while(true) {
    	 System.out.println("■■■■■■■■■■■다단계 옥장판 판매 게임■■■■■■■■■■■■■");
         System.out.println(msg);
         choice = sc.nextInt();
         if(choice == 4) {break;}
         
         switch(choice) {
         case 1: //판매하기
            resultSold = seller.sell(); //sell 메소드 실행
            
            switch(resultSold) { //성공, 대성공, 실패에 따라 아래 메세지 출력
            case 0 : //성공
               System.out.println("휴~ 옥장판 판매 성공!");
               break;
            case 1 : //대성공
               System.out.println("아자뵤~! 옥장판 판매 대성공!");
               break;
            case -1 ://실패
               System.out.println("앗");
               if(seller.count == 3 && seller.positionNumber != 0) { //만약 연속 실패 횟수가 3이 되고, 직급이 사원(positionNumber=0)이 아닌 경우
                  seller.demote(); //demote 메소드 실행
                  System.out.println(seller.table[seller.positionNumber] + "으로 좌천되었습니다..."); //demote 메소드가 실행된 이후이므로 positionNumber를 그대로 사용해도 됨
               }
               break;
            }
            System.out.println("내 통장 잔고 : " + seller.income + "만원"); 
            
            break;
         case 2: //승진하기
            if(seller.positionNumber == 2) { // 다이아 직급일 경우 승진 불가
               System.out.println("승진하실 수 없습니다.");
               break;
            }
            if(seller.promote()) { //OakSeller 클래스의 seller 객체가 promote 메소드를 실행했을 때 return 값이 true인 경우,
               seller.count = 0; // 연속 실패 횟수(count) 0으로 초기화
               System.out.println(seller.table[seller.positionNumber] + "(으)로 승진하셨습니다!!!!"); //if의 조건식으로 promote가 실행되어 positionNumber가 이미 변경되었으므로 그대로 사용
               System.out.println("내 통장 잔고 : " + seller.income + "만원"); //마찬가지로 수중에 있는 현금도 변화했으므로 그대로 사용
               break;
            }// 승진 실패했을 경우
            System.out.println("승진 실패....");
            System.out.println("내 통장 잔고 : " + seller.income + "만원");
            break;
         case 3: //내 정보
            System.out.println("이름 : " + seller.name);
            System.out.println("직급 : " + seller.table[seller.positionNumber]);
            System.out.println("내 통장 잔고 : " + seller.income);
            System.out.println("판매 성공률 : " + seller.successRating + "%");
            break;
         }
      }
      
   }
}