package casting;

public class MyCastingTask {
	void check(Video video) { 							// check의 매개변수로 어떤 것이 들어올 지 모르므로 부모 클래스의 객체 video를 넣는다.
		if(video instanceof Film) {						// video가 Film 클래스와 같은 타입인지 확인
			Film film = (Film) video;							// 맞다면 Film 클래스의 객체 film에 Film 클래스로 강제 형변환 한 video 값을 넣는다. -> 다운캐스팅, 부모에서 자식으로 down casting하는 것이므로 강제 형변환이 필요
			film.print4D();										// 강제형변환이 이루어져 Film 클래스에만 있는 고유 메소드 print4D를 실행할 수 있다.
		} else if(video instanceof Animation) {		// video가 Film 클래스와 타입이 다르다면 Animation 클래스와 같은 타입인지 확인한다.
			Animation ani = (Animation) video;			// 맞다면 Animation 클래스의 객체 ani에 매개변수 video를 강제형변환하여 저장한다.
			ani.printSubtitle();								// Animation 클래스에만 있는 고유 메소드 printSubtitle을 실행한다.
		} else{													// Animation 클래스도 아니라면 Drama 클래스와 같은 타입이라는 것이므로 
			Drama drama = (Drama) video;				// Drama 클래스의 객체 drama에 매개변수 video를 Drama 클래스로 강제형변환하여 저장한다.
			drama.sellGoods();								// Drama 클래스에만 존재하는 고유 메소드 sellGoods를 실행한다.
		}
	}
	
	public static void main(String[] args) {
		MyCastingTask mct = new MyCastingTask();	//check 메소드를 실행하기 위해 MyCastingTask의 객체 mct를 선언한다.
		
		mct.check(new Film());								//Film 클래스를 check 메소드로 타입 확인
		mct.check(new Animation());						//Animation 클래스를 check 메소드로 타입 확인
		mct.check(new Drama());							//Drama 클래스를 check 메소드로 타입 확인
	}
}
