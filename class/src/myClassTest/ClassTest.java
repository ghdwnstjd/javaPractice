package myClassTest;

class A {
	int data;
	
	A(int data){
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(10);
//		System.out.println(a.data);
//		a.data=10;
		a.printData();
	}
}
