package randomTest;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		
//		Random 메소드를 사용할 객체 r 생성 
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(r.nextInt(3)); //nextInt(숫자) = 0~숫자-1 까지의 범위 내에서 무작위로 정수를 뽑아냄
		}
	}
}
