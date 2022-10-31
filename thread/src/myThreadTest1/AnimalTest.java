package myThreadTest1;

public class AnimalTest {
	public static void main(String[] args) {
				
//		3마리의 동물
		Runnable animalFirst = new Animal();
		Runnable animalSecond = new Animal();
		Runnable animalLast = new Animal();
		
//		울음 소리가 다름
		Thread threadFirst = new Thread(animalFirst, "어흥");
		Thread threadSecond = new Thread(animalSecond, "야옹");
		Thread threadLast = new Thread(animalLast, "멍멍");
		
//		2마리는 동시에 울고
		threadFirst.start();
		threadSecond.start();
		
//		join 사용
		try {
			threadFirst.join();
			threadSecond.join();
		} catch(InterruptedException e) {;}
		
//		나머지 1마리 동물은 2마리 동물이 모두 울고 나서 마지막에 운다.
		threadLast.start();
	}
}
