package birthdayVO;



public class BirthdayVO {
	private String name;
	private int ranking;
	private String nameCount;
	private String gender;
	
	public BirthdayVO() {;}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getNameCount() {
		return nameCount;
	}

	public void setNameCount(String nameCount) {
		this.nameCount = nameCount;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		String str = gender + "\t" + name + "\t" + ranking + "\t" + nameCount;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		
		if(obj instanceof BirthdayVO) {
			BirthdayVO birthdayVO = (BirthdayVO) obj;
			if(this.nameCount == birthdayVO.nameCount) {
				return true;
			}
		}
		return false;
	}
	
//	@Override
//	public int hashCode() {
//		return this.nameCount;
//	}
//	
	
}
