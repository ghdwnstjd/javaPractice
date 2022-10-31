package collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> bloodTypes = new HashSet<String>();
		ArrayList<String> bloodTypeList = null;
		
		bloodTypes.add("A");
		bloodTypes.add("B");
		bloodTypes.add("O");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");

		bloodTypeList = new ArrayList<String>(bloodTypes);
		
		System.out.println(bloodTypeList.get(0));
		
		
		
////		HashSet 에는 중복된 값을 저장하지 않는다.
//		System.out.println(bloodTypes);
//		
//		
////		HashSet에 들어간 것 하나씩 가져오기
//		Iterator<String> iter = bloodTypes.iterator();
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
	}
}
