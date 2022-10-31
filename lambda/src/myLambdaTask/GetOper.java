package myLambdaTask;


// 전체 식을 전달받은 후 String[]로 리턴하는 getOper 추상메소드 선언(함수형 인터페이스 제작)
@FunctionalInterface
public interface GetOper {
//	전체 식을 전달받아서 연산자만 쏙쏙 분리해주는 메소드
	public String[] checkOpers(String expression); 
}



