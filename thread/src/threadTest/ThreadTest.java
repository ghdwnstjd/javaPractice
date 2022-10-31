package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
		
		Runnable runner = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(300);} catch(InterruptedException e) {;}
			}
		};
		
		Thread t1 = new Thread1("★");
		Thread t2 = new Thread1("♥");
		
////		run으로 실행을 하면 멀티쓰레드가 실행이 되는게 아니고, 하나씩 실행이 된다.
//		t1.run();
//		t2.run();

//		start로 했기 때문에 멀티쓰레드가 실행됨
//		t1.start();
//		t2.start();
		
		
////		start메소드는 thread 클래스에 있기 때문에 thread클래스를 상속받지 않았을 경우에는 thread를 직접 선언해야한다.
//		Runnable t1= new Thread2(); //Thread2는 Runnable 인터페이스를 사용하기 때문에 Runnable 객체 t1을 써도 무방하다.(업캐스팅)
//		Thread2 t2= new Thread2();
//		
////		Thread thread1 = new Thread(t1, "!");
////		Thread thread2 = new Thread(t2, "?");
//		
//		Thread thread1 = new Thread(runner, "!");
//		Thread thread2 = new Thread(runner, "?");
//
//		thread1.start();
//		thread2.start();
//		
////		join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
////				  이미 start()된 쓰레드는 영향을 받지 않는다.
////				  만약 나중에 실행하고자 하는 쓰레드가 있다면, join() 다음에 start()를 실행해야 한다.
//		try {
//			thread1.join();
//			thread2.join();
//		} catch(InterruptedException e) {;}
//		
//		System.out.println("main 쓰레드 종료");
		
	}
}