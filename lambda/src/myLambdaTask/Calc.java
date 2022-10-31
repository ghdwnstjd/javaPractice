package myLambdaTask;


@FunctionalInterface
public interface Calc {
//	두 정수를 전달받은 후 더하거나 빼서 리턴한다.
//	더할 지 뺄 지 모르니까 추상메소드, 이걸 가지고 어떻게 활용하느냐는 나중에 추가한다.
	public int calc(int firstInt, int secondInt);
}
