
public class Homework {
//	[파일 입출력 심화 실습]
//			1. https://koreanname.me/ 접속
//			2. MVC 패턴을 사용하여 표(테이블)에 접근할 수 있는 클래스 선언
//			3. 2개의 테이블에 있는 데이터들을 각각 2개의 메모장에 붙여넣기
//			4. 2개의 메모장 파일을 한 개의 메모장 파일로 병합하기
//
//			※ 이름 수에 따른 랭킹을 새롭게 추가해준다.
//			※ 만약 이름 수가 동일하다면 공동 순위를 부여해준다.
//			※ 남자아이 이름은 맨 앞에 M을 추가하고, 여자아이 이름은 맨 앞에 F를 추가한다.
//			   예)   F   서연   1   35,647
//			        M   시우   7   26,027
//
//			남자아이 DAO
//			   메모장의 데이터를 VO객체로 리턴하는 메소드 : setObject()
//
//			여자아이 DAO
//			   메모장의 데이터를 VO객체로 리턴하는 메소드 : setObject()
//
//			전체아이 DAO
//			   1. 파일1과 파일2를 병합 : merge()
//			   2. 병합된 파일에서 랭킹 수정(이름 수 순서 - 내림차순) : updateRanking()
//			   ※ 병합 시 두 개의 ArrayList를 하나의 ArrayList로 병합하는 방법
//			   ArrayList total = new ArrayList();
//
//			   ArrayList a = new ArrayList();
//			   ArrayList b = new ArrayList();
//
//			   total.addAll(a);
//			   total.addAll(b);
//
//			   ※ 중복된 이름 수 제거 : HashSet 사용
//			   ※ HashSet을 ArrayList로 변경
//			   HashSet set = new HashSet();
//			   ArrayList list = new ArrayList(set);
//			   ※ 동일한 이름 수일 경우 공동 순위로 구현한다.
//			   예)
//			   순위   이름 수
//			   1   15000   15000
//			   2   12000   12000
//			   3   10000   10000
//			   3   10000   8000
//			   3   10000
//			   6   8000
}
