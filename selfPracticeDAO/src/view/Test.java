package view;

import java.io.IOException;

import dao.TotalDAO;

public class Test {
	public static void main(String[] args) throws IOException{
		TotalDAO totalDAO = new TotalDAO();
		totalDAO.merge("manIncomes.txt", "womanIncomes.txt", "totalIncomes.txt");
//
		totalDAO.grouping("manIncomes.txt", "womanIncomes.txt", "totalIncomes.txt");
		totalDAO.updateRanking("totalIncomes.txt");
	}
	
}
