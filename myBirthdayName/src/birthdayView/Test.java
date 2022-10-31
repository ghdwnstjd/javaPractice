package birthdayView;

import java.io.IOException;

import birthdayDAO.BirthdayDAO;
import birthdayDAO.BoyBirthdayDAO;
import birthdayDAO.GirlBirthdayDAO;
import birthdayVO.BirthdayVO;

public class Test {
	public static void main(String[] args) throws IOException {
		
////		남자에 M, 여자에 F 추가하기
//		BirthdayVO birthdayVO = new BirthdayVO();
//		BoyBirthdayDAO boyBirthdayDAO = new BoyBirthdayDAO();
//		GirlBirthdayDAO girlBirthdayDAO = new GirlBirthdayDAO();
//
//		boyBirthdayDAO.addBoyGender(birthdayVO);
//		girlBirthdayDAO.addGirlGender(birthdayVO);
		
		
//		남자, 여자 메모장 리턴
//		남자아이
//		BirthdayDAO birthdayDAO = new BirthdayDAO();
//		birthdayDAO.boyCheck().forEach(System.out::println);
//		여자아이
//		birthdayDAO.girlCheck().forEach(System.out::println);
		
		BirthdayDAO birthdayDAO = new BirthdayDAO();
		birthdayDAO.merge().forEach(System.out::println);

	}
}
