package arrayListTask;

public class Food {
//	이름, 가격, 종류(한식, 중식, 일식, 양식)
//	private
//	기본 생성자
//	toString
	private String name;
	private String kindOfFood;
	private int price;
	private int number;
	
	
	public Food() {;}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKindOfFood() {
		return kindOfFood;
	}

	public void setKindOfFood(String kindOfFood) {
		this.kindOfFood = kindOfFood;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public String toString() {
		String str = number + "," + name + "," + kindOfFood + "," + price;
		return str;
	}
	
}
