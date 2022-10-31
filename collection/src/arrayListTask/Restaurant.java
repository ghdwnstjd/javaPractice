package arrayListTask;

import java.util.ArrayList;

public class Restaurant {
//	음식 정보를 담을 DB선언
	public static ArrayList<Food> foods = new ArrayList<>();
	
//	음식 추가
	public void addFood(Food food) {
		foods.add(food);
	}
	
	
//	양식인지 중식인지 양식인지 한식인지 검사(문자열로 리턴)
//	예) 스파게티 입력 시 "양식" 리턴
	public String checkKindOfFood(String name) {
		String kind = null;
		for (Food food : foods) {
			if(food.getName().equals(name)) {
				kind = food.getKindOfFood();
			}
		} return kind;
	}
	
	
//	사용자가 원하는 종류의 음식 목록 조회(종류는 한 가지만 입력 가능)
//	예) 한식 입력 시 한식만 조회
	public ArrayList<Food> getList(String kind) {
		ArrayList<Food> selectFoods = new ArrayList<>();
		for (Food food : foods) {
			if(food.getKindOfFood().equals(kind)) {
				selectFoods.add(food);
			}
		} return selectFoods;
	}
	
//	음식의 종류 수정(종류를 수정할 때마다 가격10% 상승)
//	예)한식 -> 중식, 음식 가격은 10% 상승
	public void foodKindChange(Food food) {
		for (Food dbFood : foods) {
			if(dbFood.getNumber() == food.getNumber()) {
				dbFood.setKindOfFood(food.getKindOfFood());
				dbFood.setPrice((int)(dbFood.getPrice()*1.1));
				break;
			}
		}
	}
	
//	사용자가 원하는 종류의 음식 개수 조회
//	예) 불고기, 제육볶음, 파스타, 초밥
//	     -> 한식 입력 시 2개
	public int countList(String kind){
		ArrayList<Food> countFoods = new ArrayList<>();
		for (Food food : foods) {
			if(food.getKindOfFood().equals(kind)) {
				countFoods.add(food);
			}
		} return countFoods.size();
	}
	
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		
		Food bulgogi = new Food();
		Food maratang = new Food();
		Food spaghetti = new Food();
		Food sushi = new Food();
		Food chicken = new Food();
		
		bulgogi.setNumber(1);
		bulgogi.setName("불고기");
		bulgogi.setKindOfFood("한식");
		bulgogi.setPrice(5000);
		
		maratang.setNumber(2);
		maratang.setName("마라탕");
		maratang.setKindOfFood("중식");
		maratang.setPrice(5000);
		
		spaghetti.setNumber(3);
		spaghetti.setName("스파게티");
		spaghetti.setKindOfFood("양식");
		spaghetti.setPrice(5000);
		
		sushi.setNumber(4);
		sushi.setName("스시");
		sushi.setKindOfFood("일식");
		sushi.setPrice(5000);
		
		chicken.setNumber(5);
		chicken.setName("치킨");
		chicken.setKindOfFood("한식");
		chicken.setPrice(10000);
		
//		=======================================
		
//		음식 추가 메소드 구현(ArrayList 추가)
		restaurant.addFood(bulgogi);
		restaurant.addFood(maratang);
		restaurant.addFood(sushi);
		restaurant.addFood(chicken);
		
//		ArrayList에 잘 들어갔는지 확인
		System.out.println(foods);
////		양식인지 중식인지 양식인지 한식인지 검사(문자열로 리턴)
////		예) 스파게티 입력 시 "양식" 리턴
//		System.out.println(restaurant.checkKindOfFood("스파게티"));

//		사용자가 원하는 종류의 음식 목록 조회(종류는 한 가지만 입력 가능)
//		예) 한식 입력 시 한식만 조회
//		System.out.println(restaurant.getList("한식"));
		

////		음식의 종류 수정(가격10% 상승)
////		예)한식 -> 중식, 음식 가격은 10% 상승
//		
		chicken.setKindOfFood("양식");
//		restaurant.foodKindChange(chicken);
//		System.out.println(foods);

////		사용자가 원하는 종류의 음식 개수 조회
////		예) 불고기, 제육볶음, 파스타, 초밥
////		     -> 한식 입력 시 2개
//		
//		System.out.println(restaurant.countList("한식"));

	}
}
