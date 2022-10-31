package vo;

import java.util.ArrayList;
import java.util.Collections;



public class BoxOfficeVO {
	private int ranking;
	private String name;
	private String releaseDate;
	private long income;
	private int guestCount;
	private int screenCount;	
	
	public BoxOfficeVO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public void setScreenCount(int screenCount) {
		this.screenCount = screenCount;
	}
	
	private String insertComma(String data) {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			if( i% 3 == 0 && i !=0) {
				result = "," + result;
			}
			result = data.charAt(data.length() -1 -i) + result;
		}
		return result;
	}
	
	
//	숫자 타입은 3자리마다 , 삽입 -> 값을 반대로 바꾸고 3의 배수마다 ,를 찍으면 됨
	@Override
	public String toString() {	
		String str = null;
		
		str = ranking + "\t" + name + "\t" + releaseDate + "\t" + insertComma(String.valueOf(income)) + "\t" 
		+ insertComma(String.valueOf(guestCount)) + "\t" 
		+ insertComma(String.valueOf(screenCount));
		return str;
	}
}
