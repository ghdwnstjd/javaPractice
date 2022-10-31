package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import vo.ManVO;
import vo.TotalDTO;
import vo.WomanVO;

public class TotalDAO {
	
//	각 파일의 모든 정보를 담을 ArrayList 만들기 -> 모든 정보를 담아야하므로 VO 전체를 타입으로 받는다.
//	두 파일이므로 ArrayList도 두 개를 만든다. 
//	
	public ArrayList<ManVO> mans;
	public ArrayList<WomanVO> womans;
	public ArrayList<TotalDTO> totals;
	
//	파일 두 개 병합하기
	public void merge(String firstPath, String secondPath, String lastPath) throws IOException{
		
//		남자 연봉을 firstPath, 여자 연봉을 secondPath, 병합된 파일을 lastPath로 지정
//		Reader가 열려있을 때 Writer를 열면 오류가 생긴다. 따라서 bufferedWriter는 null값으로 지정하고, 이후 사용할 때 DBConnector를 연결한다.
		BufferedReader manReader = DBConnector.getReader(firstPath);
		BufferedReader womanReader = DBConnector.getReader(secondPath);
		BufferedWriter bufferedWriter = null;
		
//		생성자 만들기
		ManDAO manDAO = new ManDAO();
		WomanDAO womanDAO = new WomanDAO();
		
		mans = new ArrayList<ManVO>();
		womans = new ArrayList<WomanVO>();
		
//		메모장의 각 줄을 읽을 line변수 선언
//		전체 내용을 입력 받아 메모장에 writer로 넣을 temp 변수 초기화
		String line = null, temp = "";
		
//		남자 평균 연봉
//		null값이 나오기 전까지(메모장에 문장이 더이상 없을 때까지) 한 줄씩 line에 담고, while문을 실행한다.
		while((line = manReader.readLine()) != null) {
//			temp에 각 문장을 한 줄씩 담고, 엔터를 친다.
			temp += line + "\n";
			
			mans.add(manDAO.setObject(line));
		}

		manReader.close();

		
//		여자 평균 연봉
//		null값이 나오기 전까지(메모장에 문장이 더이상 없을 때까지) 한 줄씩 line에 담고, while문을 실행한다.
		while((line = womanReader.readLine()) != null) {
//			temp에 각 문장을 한 줄씩 담고, 엔터를 친다.
			temp += line + "\n";
			
			womans.add(womanDAO.setObject(line));
		}
		
		womanReader.close();
		
		
//		저장한 값 출력
//		Reader를 모두 닫았고, Writer를 실행해야 메모장에 정보 저장이 가능하므로 Writer를 초기화한다.
		bufferedWriter = DBConnector.getWriter(lastPath);
		
//		남자, 여자 평균 연봉을 저장한 temp를 출력한다.
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
	
	
//	같은 회사 이름끼리 묶기
	public void grouping(String firstPath, String secondPath, String lastPath) throws IOException {
		
		BufferedReader manReader = DBConnector.getReader(firstPath);
		BufferedReader womanReader = DBConnector.getReader(secondPath);
		BufferedReader totalReader = DBConnector.getReader(lastPath);
		BufferedWriter bufferedWriter = null;
		
		
		
		ArrayList<Object> datas = new ArrayList<Object>();
		ArrayList<String> companyNames = new ArrayList<String>();
		
		HashSet<String> companyNameSet = null;
		
		datas.addAll(mans);
		datas.addAll(womans);
		
		mans.stream().map(v -> v.getCompanyName()).forEach(companyNames::add);
		womans.stream().map(v -> v.getCompanyName()).forEach(companyNames::add);
		
		companyNameSet = new HashSet<String>(companyNames);
		companyNames = new ArrayList<String>(companyNameSet);
		
		String temp = "";
		int count = 0;
		for (String companyName : companyNames) {
			boolean isIncomeTrueMan = false;
			boolean isIncomeTrueWoman = false;
			int averageIncome = 0;
			TotalDTO totalDTO = new TotalDTO();
			for (Object obj : mans) {
				ManVO manVO = (ManVO) obj;
				if(companyName.equals(manVO.getCompanyName())) {
					totalDTO.setCompanyName(manVO.getCompanyName());
					totalDTO.setManIncome(manVO.getIncome());
					if(totalDTO.getManIncome()!=0) {
						isIncomeTrueMan=true;
					}
				}
			}
			
			for(Object obj : womans) {
				WomanVO womanVO = (WomanVO) obj;
				if(companyName.equals(womanVO.getCompanyName())) {
					totalDTO.setWomanIncome(womanVO.getIncome());
					if(totalDTO.getWomanIncome()!=0) {
						isIncomeTrueWoman=true;
					}
				}
			}
			
			if(isIncomeTrueMan && isIncomeTrueWoman) {
				totalDTO.setExistIncome("정보 있음");
			} else {
				totalDTO.setExistIncome("정보 없음");
			}
			
			if(totalDTO.getExistIncome().equals("정보 있음")) {
				averageIncome = (totalDTO.getManIncome() + totalDTO.getWomanIncome()) /2;
			} else {
				averageIncome = totalDTO.getManIncome() + totalDTO.getWomanIncome();
			}
			totalDTO.setTotalIncome(averageIncome);
			
			count++;
			totalDTO.setRanking(count);
			
			temp += totalDTO + "\n";
		}
		bufferedWriter = DBConnector.getWriter(lastPath);
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
	
	public void updateRanking(String lastPath) throws IOException{
		BufferedReader totalReader = DBConnector.getReader(lastPath);
		
		BufferedWriter bufferedWriter = null;
		TotalDTO totalDTO = new TotalDTO();
		totals = new ArrayList<TotalDTO>();
		
		ArrayList<Object> datas = new ArrayList<Object>();
//		평균만 담을 Integer타입의 ArrayList를 만든다.
		ArrayList<Integer> averageIncomes = new ArrayList<Integer>();
		
		String line = "", temp = null;
		
	}
}
