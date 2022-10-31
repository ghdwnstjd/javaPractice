package arrayListTask;

import java.util.ArrayList;

public class Market {

// 	과일들을 저장할 DB 선언
	public static ArrayList<Fruit> fruits = new ArrayList<>();
	Fruit fruit = null;

//	과일 추가 - 추가 메소드 선언
	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

//	과일 삭제
//	과일의 이름으로 삭제한다.
//	과일의 이름을 외부에서 전달받는다.
//	DB에서 과일의 이름을 검색한다.
//	과일의 이름이 검색되면 해당 객체를 저장한다.
//	저장한 객체를 DB에서 삭제한다.
	public void deleteFruit(String findFruit) {
//		빠른 for문에서 반복자 자리에 있는 객체의 데이터에 변화가 생기면 반복에 대한 기준점이 수정되는 것이므로 오류가 발생한다.
		for (Fruit fruit : fruits) {
			if (fruit.getName().equals(findFruit)) {
				fruits.remove(fruit);
				break; //빠른 for문을 돌릴 때는 반복이 되는 주체가 변화가 되면 오류가 나기 때문에, 제거나 추가를 할 경우 break를 잡아야한다. 
			}
		}
	}
	
	
//	평균 가격 구하기
	public double averageCost() {
		int totalCost = 0;
		double averageCost = 0.0;
		for (Fruit fruit : fruits) {
			totalCost += fruit.getCost();
		}
		averageCost = Double.parseDouble(String.format("%.2f",(double) totalCost / fruits.size()));
		return averageCost;
	}
	
	
//	과일 가격이 평균 가격보다 낮은 지 검사
	public boolean isCheck(int cost) {
		return cost < averageCost();
	}

	
	

	public static void main(String[] args) {
		Market market = new Market();
		Fruit banana = new Fruit();
		Fruit apple = new Fruit();
		
		banana.setCost(10000);
		banana.setName("바나나");
		fruits.add(banana);
//		System.out.println(fruits);

		apple.setCost(8000);
		apple.setName("바나나");
		fruits.add(apple);
		
//		market.deleteFruit("바나나");
//		System.out.println(fruits);

		System.out.println(market.averageCost());
		System.out.println(market.isCheck(9000));
	}
}
