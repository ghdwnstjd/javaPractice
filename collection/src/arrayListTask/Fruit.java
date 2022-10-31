package arrayListTask;

public class Fruit {
//	과일이름, 과일가격
//	private
//	기본생성자
//	toString()
	
//	필드 변수
	private String name;
	private int cost;


//	private getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
//	기본 생성자
	public Fruit() {;}
	
	
//	toString Override
	@Override
	public String toString() {
		String str = name + ", " + cost;
		return str;
	}
}
