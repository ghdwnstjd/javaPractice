package threadTest2;

import java.util.Scanner;

public class ThreadMain {
   public static void main(String[] args) {
      int[] arInput = new int[3];
      Thread[] arThread = new Thread[arInput.length];
      ThreadTask threadTask = new ThreadTask();
      Scanner sc = new Scanner(System.in);
      
      for (int i = 0; i < arThread.length; i++) {
         arThread[i] = new Thread(threadTask); //3개의 쓰레드를 가진 arThread 배열 생성
      }
      
      System.out.print("입력 : ");
      for (int i = 0; i < arThread.length; i++) {
         arInput[i] = sc.nextInt(); //입력한 3개의 숫자를 arInput 배열에 담는다.
//         입력한 순서대로 쓰레드의 이름으로 설정한다.
//         여기에 입력해 저장한 값(setName)이 run의 switch문에 getName으로 들어간다.
         arThread[i].setName(String.valueOf(arInput[i]));
      }
      
      for (int i = 0; i < arThread.length; i++) {
         arThread[i].start();
//         하나씩 실행하기 위해 join을 걸어준다.
         try {arThread[i].join();} catch (InterruptedException e) {;}
      }
   }
}