package vo;

public class ManVO {
	private String companyName;
	private int income;
	
	public ManVO() {;}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
	@Override
	public String toString() {
		String str = companyName + ", " + income;
		return str;
	}

}
