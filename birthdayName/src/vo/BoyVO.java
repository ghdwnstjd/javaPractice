package vo;

// 두 개의 테이블이 있기 때문에 VO도 두 개가 있어야한다.
public class BoyVO {
	private String name;
	private int ranking;
	private int population;
	
	public BoyVO() {;}

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
	
//	toString 재정의
	@Override
	public String toString() {
		String str = name + "," + ranking + "," + population;
		return str;
	}
}




