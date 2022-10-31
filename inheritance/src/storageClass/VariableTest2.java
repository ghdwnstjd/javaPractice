package storageClass;

public class VariableTest2 {
	public static void main(String[] args) {
		VariableTest vt = new VariableTest();
		
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt = new VariableTest();   //새롭게 초기화가 된다. 
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
		
		
//		정적변수
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		vt = new VariableTest();  //정적변수는 새롭게 초기화가 되지 않는다. -> 정적변수는 }가 끝나야 초기화가 되기 때문
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		vt.increaseData_s();
		
		//정적변수는 어차피 한 개밖에 존재할 수 없기 때문에 클래스명 뒤에 바로 붙어도 주소값이 나와 이런 식으로 작성할 수 있다.
		System.out.println(VariableTest.data_s); 
	}
}
