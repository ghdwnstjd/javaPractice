package vo;

//BoyVO와 GirlVO를 합친 NameDTO
public class NameDTO {
	private String gender;
	private String name;
	private int ranking;
	private int population;
	
	public NameDTO() {;}

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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	숫자를 3자리 수마다 콤마를 찍는다.
	private String insertComma(String data) {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			if(i % 3 == 0 && i != 0) { // i가 0이면 바로 if문으로 들어오기 때문에 그걸 막아줌
				result = "," + result; //콤마를 찍고 result값이 나와야 순서가 맞음
			}
//			숫자를 뒤에서부터 가져오기 때문에 result를 뒤에 붙여준다.
			result = data.charAt(data.length() - 1 - i) + result;
		}
		return result;
	}
	
	@Override
	public String toString() {
		String str = gender + "\t" + name + "\t" + ranking + "\t" + insertComma(String.valueOf(population));
		return str;
	}
}






















