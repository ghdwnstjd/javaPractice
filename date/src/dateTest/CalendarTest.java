package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd aaa hh:mm:dd");
//		Calendar today = Calendar.getInstance(); //Calendar는 추상클래스임
//		System.out.println(today);
//		
//		System.out.println(simpleDateFormat.format(today.getTime())); //today가 object 타입으로 넘어가니, date타입으로 바꾸기 위해 getTime메소드 출력
		
		Calendar date = Calendar.getInstance();
//		date.set(2000, 11, 04);	//월은 0~11까지 이루어져있으므로 12월을 뽑아내려면 11을 적어야 한다.
//		date.set(Calendar.YEAR, 2000);  //연도만 바꾸기
//		System.out.println(simpleDateFormat.format(date.getTime()));
		System.out.println(date.get(Calendar.YEAR));
		System.out.println(date.get(Calendar.MONTH)+1);
	
	}
}
