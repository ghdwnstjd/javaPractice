package vo;

public class TotalDTO {
	private int ranking;
	private String companyName;
	private String existIncome;
	private int manIncome;
	private int womanIncome;
	private int totalIncome;
	
	public TotalDTO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExistIncome() {
		return existIncome;
	}

	public void setExistIncome(String existIncome) {
		this.existIncome = existIncome;
	}

	public int getManIncome() {
		return manIncome;
	}

	public void setManIncome(int manIncome) {
		this.manIncome = manIncome;
	}

	public int getWomanIncome() {
		return womanIncome;
	}

	public void setWomanIncome(int womanIncome) {
		this.womanIncome = womanIncome;
	}

	public int getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}




	@Override
	public String toString() {
		String str = ranking + "\t" + companyName + "\t" + existIncome + "\t" + manIncome+ "\t" + womanIncome + "\t" + totalIncome;
		return str;		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		TotalDTO totalDTO = (TotalDTO)obj;
		
		 // 연봉에 관계없이 이름이 같으면 true를 리턴       
		if (totalDTO.companyName == this.companyName) {          
			return true;       
			} 
		return false;
	}
}
