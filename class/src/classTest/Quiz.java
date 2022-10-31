package classTest;

public class Quiz {
//   문제, 정답, 먹이개수
   String question;
   String answer;
   int feedCount;
   boolean jackpot;
   
   
   public Quiz() {;}

   
   public Quiz(String question, String answer, int feedCount) {
      super();
      this.question = question;
      this.answer = answer;
      this.feedCount = feedCount;
   }

   public Quiz(String question, String answer, int feedCount, boolean jackpot) { //오버로딩, 잭팟 문제만 이걸로 들어옴
      this.question = question;
      this.answer = answer;
      this.feedCount = feedCount;
      this.jackpot = jackpot;
   }
}