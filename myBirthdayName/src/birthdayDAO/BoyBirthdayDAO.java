package birthdayDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import birthdayVO.BirthdayVO;

public class BoyBirthdayDAO {
	public void addBoyGender(BirthdayVO birthdayVO) throws IOException {
		BufferedWriter boyBufferedWriter = null;
		BufferedReader boyBufferedReader = BoyDBConnector.getReader();
		String line = null, temp = "";
	
//		남자아이 앞에 M 붙이기
		while((line = boyBufferedReader.readLine())!=null) {
			if(!String.valueOf(line.split("\t")[0]).equals("M")) {
				birthdayVO.setGender("M");
				temp += birthdayVO.getGender() + "\t" + line + "\n"; 
			}
			else {
				temp += line + "\n";
			}
		}
		boyBufferedReader.close();
		
		boyBufferedWriter = BoyDBConnector.getWriter();
		boyBufferedWriter.write(temp);
		boyBufferedWriter.close();
	}
}
