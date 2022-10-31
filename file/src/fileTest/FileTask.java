package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException{
//		고등어, 갈치, 꽁치, 전어
//		배열로 출력하고 전체 내용 가져와서 콘솔에 출력하기
		
//		String[] arFish = {"고등어", "갈치", "꽁치","전어"};
//		
////		출력
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt", true));
//		
//		for (int i = 0; i < arFish.length; i++) {
//			bufferedWriter.write(arFish[i]); 
//			bufferedWriter.newLine(); //줄바꿈
//		}
//		bufferedWriter.close(); //반복문이 끝난 후 close
		
		
//		입력
//		File file = new File("fish.txt");
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//			String line = null;
//			while((line = bufferedReader.readLine())!=null) {
//				System.out.println(line);
//			}
//			bufferedReader.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("해당 경로는 존재하지 않습니다.");
//		}
//		if(file.exists()) { //해당 경로가 존재하면
//			System.out.println(file.delete()); //삭제
//		}
		
		
		
//		수정(갈치 -> 연어)
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//			String line = null, temp = "";
//			
//			while((line = bufferedReader.readLine()) !=null) {
//				if(line.equals("갈치")) {
//					temp += "연어\n";
//					continue;
//				}
//				temp += line + "\n";
//			}
//			bufferedReader.close();
//			
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//			bufferedWriter.write(temp);;
//			bufferedWriter.close();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 경로입니다.");
//		}
		
//		고등어 삭제
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
			String line = null, temp = "";
			
			while((line=bufferedReader.readLine())!=null) {
				if(line.equals("고등어")) {
					continue;
				}
				temp += line + "\n";
			}
			bufferedReader.close();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("없는 경로입니다.");
		}
	}
}
