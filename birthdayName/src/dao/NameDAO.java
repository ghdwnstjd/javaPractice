package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

public class NameDAO {
	public ArrayList<GirlVO> girls;
	public ArrayList<BoyVO> boys;
	
	//병합
//	병합되는 두 개의 파일 경로는 path1, path2로 나타내고, 병합 완료된 파일의 경로를 path3로 나타내어 merge 매개변수 3개를 지정한다.
	public void merge(String path1, String path2, String path3) throws IOException{
//		남자 아이 메모장 경로 : path1, 여자 아이 메모장 경로 : path2로 지정하고
//		각 경로의 입력을 받을 BufferedReader로 boyReader, girlReader 객체를 생성한다.
		BufferedReader boyReader = DBConnecter.getReader(path1);
		BufferedReader girlReader = DBConnecter.getReader(path2);
		BufferedWriter bufferedWriter = null;
		
//		BoyDAO, GirlDAO 생성자 생성
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
		
//		BoyVo, GirlVO 타입의 ArrayList 생성
		girls = new ArrayList<GirlVO>();
		boys = new ArrayList<BoyVO>();
		
		String line = null, temp = "";
		
//		남자아이 메모장을 읽을 boyReader의 내용을 한 줄 씩 line에 담고, null이 되기 전까지(내용이 없을 때까지) 읽는다.
		while((line = boyReader.readLine()) != null) {
//			임시 저장공간인 temp에 각 줄을 담고 한 줄 엔터 -> BufferedWrite에 담길 내용을 한 줄씩 저장하는 것
			temp += line + "\n";
//			BoyVO 타입의 boys ArrayList에 한 라인의 정보를 담는다.
//			setObject메소드를 통해 각 라인의 정보를 boyVO에 담고, 그 정보가 다시 리턴되어 boys ArrayList에 담긴다.
			boys.add(boyDAO.setObject(line));
		}
		
//		boyReader close
		boyReader.close();
		
//		여자아이 메모장을 읽을 girlReader 내용을 한 줄 씩 line에 담고, 공백이 오기 전까지 읽는다.
		while((line = girlReader.readLine()) != null) {
//			임시 저장 공간인 temp에 각 라인의 내용을 담고, 라인이 끝날 때마다 한 줄을 엔터친다. temp 내용은 BufferedWrite에 담길 내용을 한 줄씩 저장하는 것이다.
			temp += line + "\n";
//			setObject 메소드를 통해 각 라인의 정보를 girlVO에 저장하고, 그 값을 리턴하여 girls ArrayList에 하나씩 저장한다.
			girls.add(girlDAO.setObject(line));
		}
		
//		girlReader close
		girlReader.close();
		
//		저장한 값을 출력한다.
//		두 정보를 합칠 path3을 bufferedWriter의 경로로 지정하고
		bufferedWriter = DBConnecter.getWriter(path3);
//		남자아이 메모장, 여자아이 메모장을 한 줄씩 불러와 저장한 temp 내용을 출력한다.
		bufferedWriter.write(temp);
//		bufferedWriter close
		bufferedWriter.close();
	}
	
	//랭킹 수정
//	매개변수로 path를 받아 어떤 정보의 랭킹을 수정할 것인지 지정한다.
	public void updateRanking(String path) throws IOException{
//		출력할 정보의 경로를 매개변수에 따라 지정한다.
		BufferedWriter bufferedWriter = DBConnecter.getWriter(path);
//		toString 내용의 타입이 여러 개이므로 Object 타입의 ArrayList를 만든다.
		ArrayList<Object> datas = new ArrayList<Object>();
//		이름 수만 담을 Integer타입의 ArrayList를 만든다.
		ArrayList<Integer> populations = new ArrayList<Integer>();
//		중복 검사를 진행할 Integer 타입의 HashSet을 만든다.
		HashSet<Integer> populationSet = null;
		String temp = "";
		int ranking = 1, count = 0;
		
//		Object 타입의 배열 datas에 merge메소드를 통해 저장된 boys와 girls ArrayList를 한 번에 담는다.
		datas.addAll(boys);
		datas.addAll(girls);
		
//		이름수만 담을 populations ArrayList에 각 정보의 이름수 정보만 추출해 더해준다.
		boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
		girls.stream().map(v -> v.getPopulation()).forEach(populations::add);
		
//		중복을 제거한 HashSet populationSet을 만든다. 
		populationSet = new HashSet<Integer>(populations);
//		이름수만 담았던 populations ArrayList에 중복을 제거한 populationSet HashSet의 내용을 다시 담아준다. -> 중복이 제거된 상태가 된다.
		populations = new ArrayList<Integer>(populationSet);
		
//		이름 수를 내림차순으로 나열한다.
		populations = (ArrayList<Integer>)populations.stream().sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		
//		populations의 개수만큼 반복을 돌린다.
		for (Integer population : populations) {
//			중복된 항목이 많아지면 count가 올라간다.
			count = 0;
//			boys와 girls의 정보가 다 들어간 전체 데이터 ArrayList인 datas길이 만큼 반복을 돌린다.
			for (Object obj : datas) {
//				Object 타입의 obj객체가 BoyVO 타입이면
				if(obj instanceof BoyVO) {
//					Object타입 객체 obj를 BoyVO로 다운캐스팅한 boyVO 객체에 담는다.
					BoyVO boyVO = (BoyVO) obj;
//					만약 populations ArrayList에 있는 population과 boyVO에 있는 population 값이 같다면
					if(population == boyVO.getPopulation()) {
//						NameDTO 객체 nameDTO 에 성별, 이름, 랭킹, 이름 수를 저장한다.
						NameDTO nameDTO = new NameDTO();
						nameDTO.setGender("B");
						nameDTO.setName(boyVO.getName());
						nameDTO.setRanking(ranking);
						nameDTO.setPopulation(population);
						
//						temp에 nameDTO 정보를 저장한 후 한 줄 엔터
						temp += nameDTO + "\n";
//						count를 추가한다.
						count ++;
					}
				}
				
//				만약 obj가 GirlVO 타입이라면
				if(obj instanceof GirlVO) {
//					Object 타입의 obj 객체를 GirlVO로 다운캐스팅하여 girlVO객체로 저장한다.
					GirlVO girlVO = (GirlVO) obj;
//					해당 정보의 인구 수가 girlVO인구와 같다면
					if(population == girlVO.getPopulation()) {
//						NameDTO 객체 nameDTO에 성별, 이름, 랭킹, 이름 수를 저장한다.
						NameDTO nameDTO = new NameDTO();
						nameDTO.setGender("G");
						nameDTO.setName(girlVO.getName());
						nameDTO.setRanking(ranking);
						nameDTO.setPopulation(population);
//						temp에 nameDTO 정보를 저장한 후 한 줄엔터
						temp += nameDTO + "\n";
//						count를 추가한다.
						count ++;
					}
				}
			}
//			만약 count가 1보다 크다면(동일한 이름 수가 있다면) 
			if(count > 1) {
//				현재 랭킹에 동일한 이름 수만큼 더하고 마지막에 랭킹을 한 번더 더하므로 1을 빼준 값을 ranking에 저장한다.
//				여기의 ranking은 지금 돌고 있는 obj의 ranking이 아니라, 현재 obj의 다음 obj 값의 랭킹을 결정하는 것
				ranking += count - 1;
			}
//			ranking 값을 1 더한다.(디폴트)
			ranking ++;
		}
		
//		반복문이 끝나면 temp 에 저장된 모든 정보를 출력하고 bufferedWriter를 닫는다.
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
}



















