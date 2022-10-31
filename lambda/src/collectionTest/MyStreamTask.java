package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStreamTask {
	public static void main(String[] args) {
		ArrayList<Integer> datas = new ArrayList<Integer>();
		
		
//		1~10까지 ArrayList에 담고 출력
//		IntStream.rangeClosed(1, 10).forEach(n -> datas.add(n));
//		System.out.println(datas);
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력	
//		IntStream.rangeClosed(1, 100).filter(n -> n%2 == 1).forEach(n -> datas.add(n));
//		System.out.println(datas);
		
//		ABCDEF를 각 문자별로 출력
//		IntStream.rangeClosed(65, 70).forEach(v -> System.out.println((char)v));
		
//		A~F까지 ArrayList에 담고 출력
//		ArrayList<Character> datas = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));
//		datas.forEach(System.out::println);
		
//		map
//		A~F까지 중 D제외하고 ArrayList에 담고 출력
		
		//		6번 반복
//		ArrayList<Character> cDatas = new ArrayList<Character>();
//		IntStream.rangeClosed(65,70).filter(n -> n!=68).forEach(v -> cDatas.add((char)v));
//		System.out.println(cDatas);
		
		//		5번 반복
//		ArrayList<Character> cDatas = new ArrayList<Character>();
//		IntStream.rangeClosed(65,69).map(n -> n > 67 ? n + 1 : n).forEach(v -> cDatas.add((char)v));
//		System.out.println(cDatas);
		
		
//		map
//		5개의 문자열을 입력받은 후 모두 소문자로 변경(String.toLowerCase())
//		ArrayList<String> arData = new ArrayList<String>(Arrays.asList("ABC", "BCD", "CDE", "DEF", "EFG"));
//		arData.stream().forEach(v -> System.out.println(v.toLowerCase()));
		
//		filter
//		Apple, banana, Melon 중 첫 번째 문자가 대문자인 문자열 출력
//		ArrayList<String> datas = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
//		datas.stream().filter(n -> (char)n.charAt(0) >=65 && (char)n.charAt(0) <=90).forEach(System.out::println);
		
//		chars, map, forEach
//		한글을 정수로 변경
//		String hangeul = "공일이삼사오육칠팔구";
//		String result = "일공이사";
//		result.chars().map(n -> hangeul.indexOf(n)).forEach(System.out::print);
		
//		정수를 한글로 변경
//		String hangeul = "공일이삼사오육칠팔구";
//		String number = "0123456789";
//		String result = "4128";
		// String number까지 만들어서 쓰는 방법		
//		result.chars().map(n -> hangeul.charAt(number.indexOf(n))).forEach(v -> System.out.print((char)v));
		
		// String number 안쓰고 하는 방법
//		result.chars().map(n -> n-48).forEach(v -> System.out.print(hangeul.charAt(v)));
	}
}
