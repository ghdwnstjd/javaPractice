package objectTest;

import java.util.Random;

class Student {
	   int number;
	   String name;
	   
	   public Student() {;}

	   public Student(int number, String name) {
	      super();
	      this.number = number;
	      this.name = name;
	   }
	   
	   @Override
	   public String toString() {
	      return number + ", " + name;
	   }
	}

	public class ToStringTest {
	   public static void main(String[] args) {
	      Random r = new Random();
	      System.out.println(r.toString());

//		-------------------------------
		  														//Override 안한다면 출력값은 objectTest.Student@41a4555e 가 나옴
		Student std = new Student(1, "한동석"); //Override됐기 때문에 재정의 된 리턴값으로 나오게 된다.
		System.out.println(std);					  //재정의 했기 때문에 true 
	}
}
