package collectionTest;

public class ForEachTest {
	public static void main(String[] args) {
		int[][] arrData = {{10, 30, 80}, {20, 40, 10}};
//		각 학생의 총점과 평균 출력
		int i = 0;
		int total = 0;
		double average = 0.0;
		for (int[] ar : arrData) { // 바깥 배열 돌아감(현재 총 2개이니 0, 1)
			for (int arr : ar) { // ar이라고 바깥 배열 변수를 지정했으니, ar만큼 돌라고 하면 안쪽 배열 돌아감(각 3개씩 인수가 있으니 0, 1, 2)
				total +=arr;
			}
			
			average = total / (double)ar.length;
			average = Double.parseDouble(String.format("%.2f", average));
			
			
			System.out.println("--------" + (i+1) + "번 학생의 점수--------");
			System.out.println("총점: " + total );
			System.out.println("평균: " + average);

			total = 0;		// total 점수 초기화
			i++;
		}
	}
}
