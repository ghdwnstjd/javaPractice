package crawling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * ※ 셀레니움 사용 시 주의사항
 * 브라우저의 url을 변경할 때에는, 미리 WebElement를 담아놓았던 객체의 해당 필드를 전부 다 사용하고 나서 url이 변경되어야 한다.
 * 해당 페이지의 작업은 무조건 다 끝내고 URL을 변경하자!
 * 알고리즘 상 불가능하다면, 기존 URL로 변경 후 작업하자!
 */

public class CGV {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	public static void main(String[] args) {
		CGV cgv = new CGV();
		String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		WebDriver driver = cgv.webDriver;
		Scanner sc = new Scanner(System.in);
		String countText = null;
		int i = 0, total = 0;
		
//		운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
//		WebDriver객체에 크롬 드라이버 대입
		driver = new ChromeDriver();
		
//		원하는 경로를 브라우저에 전달
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		더 보기 버튼 클릭
//		driver.findElement(By.className("btn-more-fontbold")).click();
//		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		영화 제목 가져오기
//		[실습] 예매율도 가져오기
//		[실습] 장르 가져오기(뒤로가기 하지말기)
		ArrayList<String> reservationRates = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> hrefs = new ArrayList<String>();
		ArrayList<String> genres = new ArrayList<String>();
		
		for (WebElement webElement : driver.findElements(By.cssSelector("strong.percent span"))) {
			reservationRates.add(webElement.getText());
		}
		
		for (WebElement webElement : driver.findElements(By.cssSelector("div.box-contents strong.title"))) {
			names.add(webElement.getText());
		}
		
		for(WebElement webElement : driver.findElements(By.cssSelector("div.box-image a"))) {
			String href = webElement.getAttribute("href");
			if(href.equals("http://www.cgv.co.kr/movies/?lt=1&ft=0#")) {continue;}
			hrefs.add(webElement.getAttribute("href"));
		}
//		
		for (String href : hrefs) {
			driver.get(href);
			for(WebElement webElement : driver.findElements(By.cssSelector("div.spec dl dt"))) {
				String genre = webElement.getText();
				if(genre.startsWith("장르")) {
					genres.add(genre);
				}
			}
		}
		
		for(int j = 0; j < names.size(); j++) {
			System.out.println(++i + ". " + names.get(j) + ", " + reservationRates.get(j) + ", " + genres.get(j));
		}
		i = sc.nextInt();
		i--;
		
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		예매하기 버튼 다 가져오기
		List<WebElement> btns = driver.findElements(By.className("link-reservation"));
		
//		예매하기 버튼은 클릭 안되기 때문에, 이동할 경로를 직접 가져온다.
//		가져온 경로를 직접 브라우저 주소창(URL)에 넣어준다.
		
		driver.get(btns.get(i).getAttribute("href"));
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		극장 정보는 새로운 iframe에 담겨있기 때문에,
//		현재 브라우저의 주소창(URL)을 iframe src(경로)로 변경해준다.
		driver.get(driver.findElement(By.id("ticket_iframe")).getAttribute("src"));
		try {Thread.sleep(2000);} catch (InterruptedException e) {;}
		
		for(WebElement webElement : driver.findElements(By.className("count"))) {
			countText = webElement.getText();
			if(countText.length() == 0) {continue;}
			total += Integer.valueOf(countText.substring(1, countText.length() - 1));
		}
		
		System.out.println("예매 가능한 영화관 수 : " + total);
		
//		크롬 종료
//		driver.close(); //오류나면 코드 삭제
		driver.quit();
	}
}












