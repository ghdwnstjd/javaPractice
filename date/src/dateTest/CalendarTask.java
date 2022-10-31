package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTask {
	public static void main(String[] args) {
//		본인의 생년월일 출력
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(1992, 9, 16);
		
		System.out.println(simpleDateFormat.format(date.getTime()));
		
		
	}
}
