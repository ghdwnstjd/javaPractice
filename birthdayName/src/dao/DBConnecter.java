package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	
//	파일 덮어쓰기
	public static BufferedWriter getWriter(String path) throws IOException{
		return new BufferedWriter(new FileWriter(path));
	}
	
//	파일 누적 저장
	public static BufferedWriter getAppend(String path) throws IOException{
		return new BufferedWriter(new FileWriter(path, true));
	}
	
//	전달된 경로의 파일의 입력 편의를 위한 메소드
	public static BufferedReader getReader(String path) throws IOException{
		return new BufferedReader(new FileReader(path));
	}
}



















