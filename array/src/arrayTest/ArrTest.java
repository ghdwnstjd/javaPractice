package arrayTest;

public class ArrTest {
	public static void main(String[] args) {
//		int[][][][] = 의면행렬
		int[][] arrData = {{3, 4, 5, 6}, {8, 9, 0, 9}, {1, 2, 3, 4}};
//		int length = arrData.length * arrData[0].length; //전체 길이 구하기
		
//		System.out.println(arrData.length); // 3
//		System.out.println(arrData[0].length); //4
		
//		for (int i = 0; i < length; i++) {
//			System.out.println(arrData[i/4][i%4]); //2차원 배열에 포함된 내용을 나열
//		}

		for (int i = 0; i < arrData.length; i++) {
			for (int j = 0; j < arrData[i].length; j++) {
				System.out.println(arrData[i][j]);
			}
		}
		
	}
}
