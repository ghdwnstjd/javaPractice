package arrayListTask;

public class Love {
//	이름, 나이
//	private
//	기본 생성자
//	toString()
	
//	private 필드
	private String name;
	private int age;
	private int number;
	
//	기본 생성자
	public Love() {;}
	
	
//	private 필드 getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNumber() {
		return age;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

//	toString override
	@Override
	public String toString() {
		String str = number + ", " + name + ", " + age;
		return str;
	}
}
