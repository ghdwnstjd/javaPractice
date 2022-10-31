package anonymousTest;

public class Computer {
	public static void main(String[] args) {
		Game game = new Game() {  //Game 인터페이스에 play, exit는 구현되지 않았고, 클래스명이 지정되지 않았음에도 구현이 된다.(익명클래스)

			@Override
			public void play() { 
				// TODO Auto-generated method stub
				
			}

			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}
