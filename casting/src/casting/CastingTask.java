package casting;

public class CastingTask {
//   넷플릭스
//   애니메이션, 영화, 드라마 클래스 선언
//   사용자가 선택한 영상이
//   애니메이션이라면 "자막지원"기능 사용
//   영화라면 "4D"기능 사용
//   드라마라면 "굿즈"기능 사용
   
   public void check(Video video) { //check의 매개변수로 어떤 것이 들어올 지 모른다. 따라서 부모 객체인 video를 넣어준다.
      if(video instanceof Animation) { //객체가 Animation과 동일한 타입인지 확인한다.
         Animation ani = (Animation) video; // 맞다면 Animation 객체 ani에 video객체를 Animation 타입으로 강제 형변환한다.
         											    // 객체가 부모객체에서 자식객체로 다운캐스팅 되므로, 강제 형변환이 필요하다.
         ani.printSubtitle();					    // Animation 객체로 형변환을 했으므로 해당 클래스에만 있는 메소드를 실행할 수 있다.
      }else if(video instanceof Film) {	//두번째로 Film 클래스와 비교하는 객체가 같은 타입인지 확인한다.
         Film film = (Film) video;				// 맞다면 비교 객체를 Film 클래스로 강제형변환한다.
         film.print4D();							// 자식클래스에만 있는 메소드를 실행한다.
      }else {									// 다 아니라면 드라마 클래스와 같으므로
         Drama drama = (Drama) video;	// 비교 객체를 드라마 클래스로 강제 형변환한다.
         drama.sellGoods();					// 드라마 클래스에만 있는 메소드를 실행한다.
      }
   }
   
   public static void main(String[] args) {
      CastingTask ct = new CastingTask();  // check 메소드를 실행하기 위한 객체화
      ct.check(new Animation());				 // Animation 클래스 check
      ct.check(new Film());						// Film 클래스 check
      ct.check(new Drama());					// Drama 클래스 check
   }
}