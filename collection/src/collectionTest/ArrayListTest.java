package collectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	
//	public static void ArrayIndex(ArrayList<Integer> datas, int a) {
//		datas.indexOf(a);
//	}
	
	public static void main(String[] args) {
//		<?> : 제네릭(이름이 없는)
//		객체화 시 타입을 지정하는 기법
//		설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용한다.
//		따로 다운캐스팅을 할 필요가 없다.
//		지정할 타입에 제한을 줄 수 있다. 예) public class ArrayaList <E extends Number>  -> Number타입 외에는 못 씀
		ArrayList<Integer> datas = new ArrayList<>();
		
		datas.add(70);
		datas.add(10);
		datas.add(20);
		datas.add(30);
		datas.add(40);
		datas.add(50);
		datas.add(60);
		datas.add(70);
		datas.add(80);
		datas.add(90);
		datas.add(100);
		datas.add(110);
		

//		System.out.println(datas.size());
		
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.print(datas.get(i)+ " ");
//		}
		
//		↑↑↑↑↑↑↑↑↑↑↑이렇게 할 필요가 없음
		
		System.out.println("ArrayList : " + datas); // datas는 객체로 값이 아닌 주소값이기 때문에 정렬이 된 것으로 출력된다.
		
		Collections.sort(datas);  //오름차순 정렬
		System.out.println("sort: " + datas); // datas는 객체로 값이 아닌 주소값이기 때문에 정렬이 된 것으로 출력된다.
		
		Collections.reverse(datas); // ArrayList의 값을 거꾸로 뒤집는 것(내림차순이라고 하면 안된다!)
		System.out.println("reverse: " + datas);
		
		Collections.shuffle(datas);  // ArrayList값을 섞는거
		System.out.println("shuffle: " + datas);
		
		System.out.println("------------------------");
		
//		추가(삽입)
//		50뒤에 500 삽입
		if(datas.contains(50)) {
			datas.add(datas.indexOf(50)+1, 500);
			System.out.println("50뒤에 500 삽입 : " + datas);
		}
		
		
//		수정
//		90을 9로 수정
		if(datas.contains(90)) {
			datas.set(datas.indexOf(90), 9);
			System.out.println("90을 9로 수정 : " + datas);
		}
//		삭제
//		80삭제
//		1. 인덱스로 삭제
		
//		if(datas.contains(80)) {
//			datas.remove(datas.indexOf(80));
//			System.out.println("인덱스로 80 삭제 : " + datas);
//		}
		
//		2. 값으로 삭제
		if(datas.remove(Integer.valueOf(80))) { //Auto Boxing을 해버리면 int값이 되기 때문에, Object로 타입을 바꾸기 위해 박싱을 해준다.
															  // (주의) Integer는 int와 관련이 없다. Integer의 부모 개념은 Object이기 때문에 Integer타입으로 박싱을 하면 Object가 나온다.
			System.out.println("값으로 80 삭제 : " + datas);
		}
	}
}
