package dao;

import vo.BoyVO;

public class BoyDAO {
//	NameDAO에서 한 줄씩 읽으며 입력(Reader)을 받고, 그걸 매개변수 line으로 받는다.
//	각각의 정보는 모두 BoyVO의 정보이기 때문에 메소드 타입도 BoyVO로 받는다.
	public BoyVO setObject(String line) {
//		String 배열 datas에 각 라인의 정보를 탭을 기준으로 받아낸다.
		String[] datas = line.split("\t");
//		BoyVO 생성자를 만들고
		BoyVO boyVO = new BoyVO();
		
//		생성자에 이름, 랭킹, 이름 수를 저장한다.
//		랭킹과 이름 수는 콤마가 있으므로 지우고 Integer로 형변환하여 저장한다.
		boyVO.setName(datas[0]);
		boyVO.setRanking(Integer.valueOf(removeComma(datas[1])));
		boyVO.setPopulation(Integer.valueOf(removeComma(datas[2])));
		
//		저장한 값을 리턴한다.
		return boyVO;
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
}
