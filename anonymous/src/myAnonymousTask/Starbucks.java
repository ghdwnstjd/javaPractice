package myAnonymousTask;

public class Starbucks {
	   public void register(Form form) { // Form 타입의 객체 form
	      String[] menus = form.getMenu(); //Form 클래스의 getMenu 추상메소드를 String 배열 타입의 menus로 받는다. 
	      
	      System.out.println("=======메뉴========");
	      for (int i = 0; i < menus.length; i++) { 
	         System.out.println(i + 1 + ". " + menus[i]);
	      }
	      
	      if(form instanceof FormAdapter) { // form객체가 FormAdapter를 업캐스팅 했다면
	    	  System.out.println("무료 나눔 행사 중");
	    	  return; //if 문에 들어왔기 때문에 즉시 종료 시키기 위해 return을 적음
	      }
	      form.sell("카푸치노");
	   }
	}
