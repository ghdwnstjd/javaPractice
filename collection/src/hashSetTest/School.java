package hashSetTest;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
//		Student han = new Student(1, "한동석");
//		System.out.println(han.equals(new Student(1, "한동석"))); //true (equals 재정의)
		
		HashSet<Student> stds = new HashSet<Student>();
		stds.add(new Student(1, "한동석"));
		stds.add(new Student(1, "한동석"));
		
		System.out.println(stds.size()); //해시코드를 재정의하지 않으면 2가 나옴
		
	}
}
