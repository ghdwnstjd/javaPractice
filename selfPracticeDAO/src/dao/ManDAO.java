package dao;

import vo.ManVO;

public class ManDAO {

	public ManVO setObject(String line) {
		String[] originalDatas = line.split("\t");
		String[] updateDatas = new String[2];

		ManVO manVO = new ManVO();
		
		if(originalDatas.length == 1) {
			updateDatas[0] = originalDatas[0];
			updateDatas[1] = "0";
		}
		else {
			updateDatas[0] = originalDatas[0];
			updateDatas[1] = originalDatas[1];
		}

		
		manVO.setCompanyName(updateDatas[0]);
		manVO.setIncome(Integer.valueOf(updateDatas[1]));

		return manVO;
	}
}
