package birthdayDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import birthdayVO.BirthdayVO;

public class GirlBirthdayDAO {

	public void addGirlGender(BirthdayVO birthdayVO) throws IOException {
//		여자 아이 앞에 F 붙이기
		BufferedWriter girlBufferedWriter = null;
		BufferedReader girlBufferedReader = null;
		String line = null, temp = "";

		girlBufferedReader = GirlDBConnector.getReader();
		while((line = girlBufferedReader.readLine())!=null) {
			if(!String.valueOf(line.split("\t")[0]).equals("F")) {
			birthdayVO.setGender("F");
			temp += birthdayVO.getGender() + "\t" + line + "\n"; 
		}
			else {
				temp +=line + "\n";
			}
		}
		girlBufferedReader.close();
		
		girlBufferedWriter = GirlDBConnector.getWriter();
		girlBufferedWriter.write(temp);
		girlBufferedWriter.close();
	}
	
}
