package arrayListTask;

import java.util.ArrayList;
import java.util.Collections;

public class DateApp {
	
//	이상형 정보를 담을 DB
	public static ArrayList<Love> loves = new ArrayList<>();
	
//	이상형 추가
	public void addType(Love love) {
		loves.add(love);
	}
	
//	사용자가 입력한 나이인 이상형 목록 조회
	public ArrayList<Love> typeCheck(int age) {
		ArrayList<Love> selectTypes = new ArrayList<>();
		for (Love love : loves) {
			if(love.getAge() == age) {
				selectTypes.add(love);
			}
		}
		return selectTypes;
	}
	
		
//	이상형의 나이 수정
//	이상형의 번호를 추가하고 번호로 조회한다.
	public void ageChange(Love love) {
		for (Love db : loves) {
			if(db.getNumber() == love.getNumber()) {
				db.setAge(love.getAge()); //1번 방법, 필드만 수정하는 방법 -> 이게 더 쉬우니까 이걸로 하는게 낫다.
//				loves.set(loves.indexOf(db), love); //2번 방법, 객체를 통째로 바꾸는 방법
				break;
			}
		}
	}
	
	
//  이상형의 나이 순으로 정렬하기
  public void sort() {
//     이상형의 나이만 담을 ArrayList
     ArrayList<Integer> ages = new ArrayList<Integer>();
     
//     오름차순으로 정렬된 이상형 정보를 담을 ArrayList
     ArrayList<Love> loves = new ArrayList<Love>();
     
     for (Love love : DateApp.loves) {
//        이상형의 나이만 담아주기
        ages.add(love.getAge());
     }
     
//     나이 오름차순 정렬
     Collections.sort(ages);
     
     for (int i = 0; i < DateApp.loves.size(); i++) {
//        정렬된 나이 ArrayList에서 첫번째 나이부터 비교
        for (Love love : DateApp.loves) {
           if(ages.get(i) == love.getAge()) {
//           찾았다면 순서대로 loves에 담아주기
              loves.add(love);
           }
        }
     }
//     오름차순으로 정렬된 전체 정보를 DB에 저장
     DateApp.loves = loves;
  }


	
	
	public static void main(String[] args) {
		
		DateApp da = new DateApp();
		
		Love test = new Love();
		Love test_2 = new Love();
		Love test_3 = new Love();
		
		test.setAge(20);
		test.setName("테스트1");
		test.setNumber(1);
		
		test_2.setAge(30);
		test_2.setName("테스트2");
		test.setNumber(2);
		
		test_3.setAge(20);
		test_3.setName("테스트3");
		test.setNumber(3);

		da.addType(test);
		da.addType(test_2);
		da.addType(test_3);

		System.out.println(da.typeCheck(20));

		
		test.setAge(40);
		da.ageChange(test);
		
	}
}
