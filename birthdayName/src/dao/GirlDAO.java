package dao;

import vo.GirlVO;

public class GirlDAO {
//	BoyDAO와 동일
//	NameDAO에서 한 줄씩 읽으며 입력(Reader)을 받고, 그걸 매개변수 line으로 받는다.
//	각각의 정보는 모두 GirlVO의 정보이기 때문에 메소드 타입도 GirlVO로 받는다.
	public GirlVO setObject(String line) {
//		String 배열 datas에 각 라인의 정보를 탭을 기준으로 받아낸다.
		String[] datas = line.split("\t");
//		GirlVO의 새로운 생성자를 만들고
		GirlVO girlVO = new GirlVO();
		
//		각 생성자에 이름, 랭킹, 이름 수를 담는다.
		girlVO.setName(datas[0]);
		girlVO.setRanking(Integer.valueOf(removeComma(datas[1])));
		girlVO.setPopulation(Integer.valueOf(removeComma(datas[2])));
		
		return girlVO;
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
}
