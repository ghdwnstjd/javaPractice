package threadTest;

import java.util.Iterator;

//	상속을 통한 Thread 사용
//  상속은 하나밖에 못받기 때문에 잘 사용하지는 않는다.
public class Thread1 extends Thread {
	
	public String data;
	
	public Thread1() {;}
	
	
	public Thread1(String data) {
		this.data = data;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try{Thread.sleep(1000);} catch(InterruptedException e) {;}
		}
	}
}
