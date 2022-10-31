package birthdayDAO;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class BoyDBConnector {
	public static final String PATH = "boy.TXT";
	
	
//	출력
	public static BufferedWriter getWriter() throws IOException{
		return new BufferedWriter(new FileWriter(PATH));
	}
	
//	추가
	public static BufferedWriter getAppend() throws IOException{
		return new BufferedWriter(new FileWriter(PATH, true));
	}
	
//	입력
	public static BufferedReader getReader() throws IOException{
		return new BufferedReader(new FileReader(PATH));
	}
}
