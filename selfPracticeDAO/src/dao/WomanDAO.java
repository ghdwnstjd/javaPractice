package dao;

import vo.WomanVO;

public class WomanDAO {
	public WomanVO setObject(String line) {
		String[] originalDatas = line.split("\t");
		String[] updateDatas = new String[2];
		
		WomanVO womanVO = new WomanVO();
		
		if(originalDatas.length == 1) {
			updateDatas[0] = originalDatas[0];
			updateDatas[1] = "0";
		}
		else {
			updateDatas[0] = originalDatas[0];
			updateDatas[1] = originalDatas[1];
		}

		womanVO.setCompanyName(updateDatas[0]);
		womanVO.setIncome(Integer.valueOf(updateDatas[1]));
		
		return womanVO;
	}
}
