package myArrayListTask;

public class Sports {
	
	
// 종목 이름, 참여 인원, 종류(축구, 농구, 야구, 달리기), 연봉, 구기종목 유무(구기, 구기아님으로 구분)
//	private
	private String name;
	private String type;
	private int number;
	private int money;
	private int count;
	
//	기본 생성자
	public Sports() {;}

//	getter setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
//	toString
	public String toString() {
		String str = count + "," + name + "," + type + "," + number + "," + money;
		return str;
	}

}
