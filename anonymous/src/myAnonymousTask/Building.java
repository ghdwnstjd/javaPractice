package myAnonymousTask;

public class Building {
	   public static void main(String[] args) {
	      
	      Starbucks gangnam = new Starbucks(); //Starbucks 객체 gangnam 생성 -> 따라서 gangnam 객체는 register 메소드를 통해 getMenu와 sell 메소드를 부를 수 있다.
	      gangnam.register(new Form() { //익명 클래스. 클래스명 없이 바디가 왔기 때문에 익명클래스다. Form 클래스에서 구현하지 않은 추상메소드 sell메소드, getMenu메소드를 구현하기 위해 선언되었다. 
	         
	         @Override
	         public void sell(String order) { //sell 메소드 재정의
	            String[] menus = getMenu(); //Form 클래스의 getMenu 메소드를 통해 가져온 문자열을 배열에 저장한다.(getMenu 메소드의 배열 안에 menu들을 넣는다.)
	            for (int i = 0; i < menus.length; i++) {
	               if(order.equals(menus[i])) { //sell 메소드의 매개변수가 menus에 있는 문자열과 같다면
	                  System.out.println("판매 완료"); //판매완료 출력
	               }
	            }
	         }
	         
	         @Override
	         public String[] getMenu() { //String 배열 타입의 메소드 getMenu()
	            String[] menus = {"아메리카노", "카푸치노", "캐모마일티"}; //String 배열 타입의 menus에 문자열 저장
	            return menus; //getMenu 메소드 선언 시 위에 기재한 String 타입 배열이 리턴된다.
	         }
	      });
	      
	      
	      
//	      잠실점 오픈
//	      잠실점은 무료 나눔 행사중이라서 판매 방식을 구현할 필요 없다.
//	      본사에서는 전달받은 양식을 검사할 때
//	      무료나눔 행사중인 매장이라면 "무료 나눔 행사중" 출력하기
	      Starbucks jamsil = new Starbucks(); //잠실점 오픈, Starbucks 객체 jamsil을 생성한다.
	      jamsil.register(new FormAdapter() {  //양식 검사 시 판매 방식은 구현할 필요 없음 -> 중간다리 역할을 할 어댑터 클래스를 받음
			  												//FormAdapter는 Form의 자식타입으로 up casting을 통해 전달한다. 
			@Override
			public String[] getMenu() {
				String[] menus = {"아메리카노", "카푸치노", "캐모마일티", "콜드브루"}; //String 배열 타입의 menus에 문자열 저장
	            return menus;  //getMenu 메소드 선언 시 위에 기재한 String 타입 배열이 리턴된다.
			}
		});
	   }
	}