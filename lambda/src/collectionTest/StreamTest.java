package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
//		forEach()
//		여러 값을 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
//		forEach 메소드에는 Consumer 인터페이스 타입의 값을 전달해야 한다.
//		Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다.
//		매개변수에는 컬렉션 객체 안에 들어있는 값들이 순서대로 담기고,
//		화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
//		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>(); //String이 key값, Integer가 value값
//		ArrayList<Integer> datas = new ArrayList<Integer>();
//		
//		
//		chinaTown.put("자장면", 4500);
//		chinaTown.put("짬뽕", 5500);
//		chinaTown.put("탕수육", 14500);
		
//		forEach만 stream없이도 collection에서 바로 쓸 수 있다. (두 값은 같다)
//		chinaTown.values().stream().forEach(price -> System.out.println(price));
//		chinaTown.values().forEach(price -> System.out.println(price));
//		chinaTown.values().forEach(System.out::println);
		
		
//		따라서 arraylist에서도 forEach바로 쓸 수 있다.
//		datas.add(10);
//		datas.add(20);
//		datas.add(30);
//		datas.add(40);
		
//		datas.forEach(value -> {
//			
//		System.out.println(value);
//		System.out.println("안녕");
//		});
		
//		전달받은 매개변수를 그대로 메소드에 사용할 경우에는 참조형 문법을 사용할 수 있다.
//		소속::메소드명 --> 전달받은 값을 메소드의 매개변수로 바로 전달해준다.
//		datas.forEach(System.out::println);
		
//		IntStream.range(start, end) : start부터 end-1까지
//		IntStream.rageClosed(start, end) : start부터 end까지
//		1~9까지 출력
//		IntStream.range(1, 10).forEach(System.out::println);
		
//		1~10까지 출력
//		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
//		chars() : 문자열을 IntStream으로 변경
//		String data = "ABC";
//		data.chars().forEach(number -> System.out.println((char)number));  // chars도 IntStream이기 떄문에 그냥 출력을 하게 되면 문자가 아닌 숫자로 출력된다.
				
//		map() : 기존 값을 원하는 값으로 변경
//		String data = "ABC";
//		data.chars().map(number -> number +3).forEach(v -> System.out.println((char)v));
		
//		filter() : 조건식을 작성하여 false일 경우 제외시킨다.
//		IntStream.rangeClosed(1, 10).filter(n -> n%2 ==0).forEach(System.out::println);
		
//		sorted()
//		Integer[] arData = {10, 40, 20, 30};
		
//		배열을 Arraylist로 넣기
//		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(arData));
		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(10, 40, 20, 30));
//		System.out.println(datas);
		
//		오름차순
//		datas.stream().sorted().forEach(System.out::println); //오름차순 정렬
		
//		내림차순
//		datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println); //오름차순 정렬

//		collect() : 결과를 다양한 타입으로 리턴해준다.
		ArrayList<Integer> results = 
				(ArrayList<Integer>)datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(results);
		
		
//		Collectors.joining("구분점");
//		문자열 타입의 값을 원하는 구분점으로 연결하여 리턴한다.
//		문자열 타입이 아닌 값은 joining을 사용할 수 없다.c
//		여기서는 그래서 map을 통해 valueOf(박싱)을 하여 String 타입으로 바꾸었음
//		String result = datas.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
//		System.out.println(result);
		
	}
}
