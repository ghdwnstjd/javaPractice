package birthdayDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import birthdayVO.BirthdayVO;

public class BirthdayDAO {

//		1. https://koreanname.me/ 접속 v
//		2. MVC 패턴을 사용하여 표(테이블)에 접근할 수 있는 클래스 선언 v
//		3. 2개의 테이블에 있는 데이터들을 각각 2개의 메모장에 붙여넣기 v
	
//		남자아이 DAO
//		   메모장의 데이터를 VO객체로 리턴하는 메소드 : setObject()
		public ArrayList<BirthdayVO> boyCheck() throws IOException {
			BufferedReader bufferedReader = BoyDBConnector.getReader();
			ArrayList<BirthdayVO> birthdayVOs = new ArrayList<BirthdayVO>();
			String line = null;
			int i = 0;
			
			while((line = bufferedReader.readLine())!=null){
				String[] datas = line.split("\t");
				BirthdayVO birthdayVO = new BirthdayVO();
//				남자 아이의 각 정보 하나씩 받아옴
				birthdayVO.setGender(datas[i++]);
				birthdayVO.setName(datas[i++]);
				birthdayVO.setRanking(Integer.valueOf(datas[i++]));
				birthdayVO.setNameCount(datas[i]);
//				birthdayVO 정보를 ArrayList에 추가
				birthdayVOs.add(birthdayVO);
				i = 0; //i값 초기화
			}
			return birthdayVOs;
		}
		
		
//		여자아이 DAO
//		   메모장의 데이터를 VO객체로 리턴하는 메소드 : setObject()
//		남자아이와 동일
		public ArrayList<BirthdayVO> girlCheck() throws IOException {
			BufferedReader bufferedReader = GirlDBConnector.getReader();
			ArrayList<BirthdayVO> birthdayVOs = new ArrayList<BirthdayVO>();
			String line = null;
			int i = 0;
			
			while((line = bufferedReader.readLine())!=null){
				String[] datas = line.split("\t");
				BirthdayVO birthdayVO = new BirthdayVO();
				birthdayVO.setGender(datas[i++]);
				birthdayVO.setName(datas[i++]);
				birthdayVO.setRanking(Integer.valueOf(datas[i++]));
				birthdayVO.setNameCount(datas[i]);
				birthdayVOs.add(birthdayVO);
				i = 0;
			}
			return birthdayVOs;
		}
		
		
		
//		4. 2개의 메모장 파일을 한 개의 메모장 파일로 병합하기 
//		※ 이름 수에 따른 랭킹을 새롭게 추가해준다.
//		※ 만약 이름 수가 동일하다면 공동 순위를 부여해준다.
		public ArrayList<BirthdayVO> merge() throws IOException{
			ArrayList<BirthdayVO> originalTotal = new ArrayList<>();
			ArrayList<BirthdayVO> newTotal = new ArrayList<>();
			ArrayList<Integer> nameCount = new ArrayList<>();
			BufferedWriter bufferedWriter = null;
			BufferedReader bufferedReader = null;
			String temp = "", line = null;			
			
//			전체 인원 ArrayList에 추가
			originalTotal.addAll(boyCheck());
			originalTotal.addAll(girlCheck());

			
//			이름 순서대로 내림차순 정렬하기
			for (BirthdayVO birthday : originalTotal) {
				nameCount.add(Integer.parseInt(removeComma(birthday.getNameCount())));
			}
			
//			오름차순으로 정렬
			Collections.sort(nameCount);
//			내림차순으로 정렬
			Collections.reverse(nameCount);
			
//			newTotal ArrayList에 내림차순으로 모든 정보를 저장
			for (int i = 0; i < nameCount.size(); i++) {
				for (BirthdayVO birthday : originalTotal) {
					if(nameCount.get(i) == Integer.parseInt(removeComma(birthday.getNameCount()))) {
//						newTotal ArrayList에 nameCount가 높은 순서대로 저장
						newTotal.add(birthday);
//						temp에 각 정보를 한 줄 씩 띄고 저장
						temp += birthday + "\n";
					}
				}
			}

		
			bufferedWriter = TotalDBConnector.getWriter();
//			temp에 저장한 내역을 그대로 write하여 메모장에 저장
			bufferedWriter.write(temp);
			bufferedWriter.close();
			temp="";
			
			
//			랭킹 수정하기
			bufferedReader = TotalDBConnector.getReader();
			int i = 0;
			while((line=bufferedReader.readLine()) !=null) {
//				temp에 각 항목을 추가, ranking은 내림차순으로 구현했기 때문에 그대로 입력
				temp += line.split("\t")[0] + "\t" + line.split("\t")[1] + "\t" + (i+1) + "\t" + line.split("\t")[3];
				temp+= "\n";
				i++;
			}
			bufferedReader.close();
			
			
			bufferedWriter = TotalDBConnector.getWriter();
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
			
			return newTotal;
		}
		
//		Integer 비교를 위해 콤마 삭제하는 메소드 구현
		public String removeComma(String data) {
			return data.replaceAll(",", "");
		}
	
}
