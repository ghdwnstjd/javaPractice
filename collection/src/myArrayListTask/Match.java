package myArrayListTask;

import java.util.ArrayList;
import java.util.Collections;

public class Match {
	
//	스포츠 정보를 담을 DB 선언
	public static ArrayList<Sports> alSports = new ArrayList<Sports>();
	
//	종목 추가
	public void addSports(Sports sports) {
		alSports.add(sports);
	}
	
//	사용자가 원하는 종류의 스포츠 목록 조회(종류는 한 가지만 입력 가능)
//	예) "구기" 입력 시 구기종목 조회
	public ArrayList<Sports> checkSportsType(String type){
		ArrayList<Sports> typeList = new ArrayList<Sports>();
		for (Sports sports : alSports) {
			if(sports.getType().equals(type)) {
				typeList.add(sports);
			}
		}
		return typeList;
	}
	
	
//	스포츠의 정보 수정
//	종목 이름, 참여 인원, 종류(축구, 농구, 야구, 달리기), 연봉, 구기종목 유무 모두 수정 가능하도록 진행
	public void update(Sports sports) {
		for (Sports dbSports : alSports) {
			if(dbSports.getCount() == sports.getCount()) {
				dbSports.setName(sports.getName());
				dbSports.setType(sports.getType());
				dbSports.setNumber(sports.getNumber());
				dbSports.setMoney(sports.getMoney());
				break;
			}
		}
	}
	
	
//	사용자가 원하는 종류의 스포츠 개수 조회
//	예) 축구, 농구, 달리기
//	     -> '구기' 입력 시 2개
	
	public int type(String type) {
		ArrayList<Sports> temp = new ArrayList<>();
		for (Sports sports : alSports) {
			if(sports.getType().equals(type)) {
				temp.add(sports);
			}
		}
		return temp.size();
	}
	

//	스포츠 종목의 전체 평균 연봉 구하기
	public double averagePay() {
		int total = 0;
		double average = 0.0;
		
		for (Sports sports : alSports) {
			total += sports.getMoney();
		}
		average = Double.parseDouble(String.format("%.2f", total / (double)alSports.size()));
		return average;
	}
		
//  연봉이 높은 순으로 정렬하기
	public void descending() {
		ArrayList<Integer> pay = new ArrayList<>();
		ArrayList<Sports> descendingSports = new ArrayList<>();
		
		for (Sports sports : alSports) {
			pay.add(sports.getMoney());
		}
		
		Collections.sort(pay);
		Collections.reverse(pay);
		
		for (int i = 0; i < pay.size(); i++) {
			for (Sports sports : alSports) {
				if(pay.get(i) == sports.getMoney()) {
					descendingSports.add(sports);
				}
			}			
		}
		alSports = descendingSports;
	}
	
	
	public static void main(String[] args) {
		Match match = new Match();

		Sports soccer = new Sports();
		Sports basketball = new Sports();
		Sports baseball = new Sports();
		Sports running = new Sports();
		
		soccer.setCount(1);
		soccer.setName("축구");
		soccer.setType("구기");
		soccer.setNumber(11);
		soccer.setMoney(10000);
		
		basketball.setCount(2);
		basketball.setName("농구");
		basketball.setType("구기");
		basketball.setNumber(5);
		basketball.setMoney(5000);
		
		baseball.setCount(3);
		baseball.setName("야구");
		baseball.setType("구기");
		baseball.setNumber(9);
		baseball.setMoney(12000);
		
		running.setCount(4);
		running.setName("달리기");
		running.setType("구기아님");
		running.setNumber(1);
		running.setMoney(2000);
		
//		======================================
		
//		1.종목 추가
		match.addSports(soccer);
		match.addSports(basketball);
		match.addSports(baseball);
		match.addSports(running);
		System.out.println("1. 종목 추가 : " + alSports);

//		2. 사용자가 원하는 종류의 스포츠 목록 조회(종류는 한 가지만 입력 가능)
//		예) "구기" 입력 시 구기종목 조회
		System.out.println("2. 구기종목 조회 : " + match.checkSportsType("구기"));
		
		

//		3. 스포츠의 정보 수정
//		종목 이름, 참여 인원, 종류(축구, 농구, 야구, 달리기), 연봉, 구기종목 유무 모두 수정 가능하도록 진행
		
//		야구 연봉을 150000으로 수정
		baseball.setMoney(15000);
		match.update(baseball);
		System.out.println("3. 정보 수정 : " + alSports);
		
		
//		4. 사용자가 원하는 종류의 스포츠 개수 조회
//		예) 축구, 농구, 달리기
//		     -> '구기' 입력 시 2개
		System.out.println("4. 스포츠 개수 조회 : " + match.type("구기") + "개");

//		5. 스포츠 종목의 전체 평균 연봉 구하기
		System.out.println("5. 평균 연봉 : " + match.averagePay());

//  	6. 연봉이 높은 순으로 정렬하기
		match.descending();
		System.out.println("6. 연봉 높은 순으로 정렬 : " +alSports);
		
	}
}
