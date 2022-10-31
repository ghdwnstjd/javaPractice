package objectTest;

import java.util.Random;

class Employee{
	   int number;
	   String name;
	   
	   public Employee() {;}

	   public Employee(int number, String name) {
	      super();
	      this.number = number;
	      this.name = name;
	   }
	   
	   @Override
	   public boolean equals(Object obj) {   //equals 메소드 재정의 equals의 매개변수 Object 타입의 obj
	      //주소 비교
	      if(this == obj) {			// equals 메소드의 Object 타입 주소와 매개변수의 주소가 같다면
	         return true;			// true 리턴
	      }
	      
	      //타입 비교
	      if(obj instanceof Employee) {	//매개변수가 Employee 타입이라면 
	         //Object에 up casting되었기 때문에 Employee에 새롭게 만든 number와 name은 Object에 없다.
	         Employee anotherEmployee = (Employee)obj; //Employee 객체 anotherEmployee는 매개변수를 Employee 타입으로 down casting 한다
	         if(this.number == anotherEmployee.number) { // 만약 Employee타입의 number 값과 Employee 객체 anotherEmployee의 number 값이 같다면
	            return true;		//true 리턴한다.
	         }
	      }
	      return false;		// 그 외에는 false 를 리턴한다.
	   }
	}

public class EqualsTest {
	public static void main(String[] args) {
//		Random r1 = new Random();
//		Random r2 = new Random();
//	
//		System.out.println(r1==r2); 			// false
//		System.out.println(r1.equals(r2));	// false
//	
//		r1=r2;
//		System.out.println(r1==r2);			// true
//		System.out.println(r1.equals(r2));	// true

//		============================================================
		
//		String data1 = "ABC";
//		String data2 = "ABC";
//		String data3 = new String("ABC");
//		String data4 = new String("ABC");
//
//		System.out.println(data1 == data2); // true
//		System.out.println(data1.equals(data2)); // true
//
//		
////		data3과 data4는 new를 써서 필드의 주소를 저장했기 때문에 
////		==는 data3과 data4의 필드 주소값을 비교해 false가 나온다.
//		
////		equals는 값비교를 하기 때문에 true가 나온다.
//		System.out.println(data3 == data4); // false
//		System.out.println(data3.equals(data4)); // true
		
	      Employee han = new Employee(1, "한동석");
	      System.out.println(han.equals(new Employee(1, "한동석")));  //false가 나옴. 두 값의 주소값이 다르기 때문
		
	}
}
