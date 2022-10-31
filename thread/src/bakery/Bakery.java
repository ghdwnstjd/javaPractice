package bakery;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
//		BreadMaker를 사용하기 위한 객체 breadMaker 
		BreadMaker breadMaker = new BreadMaker();
//		Thread 객체 maker는 breadMaker를 매개변수로 하는 새로운 Thread로 만든다.
		Thread maker = new Thread(breadMaker);
		String[] btns = {"빵 먹기", "나가기"};
		int choice = 0;
		
//		ImagaIcon사용법
		ImageIcon icon = new ImageIcon("src/img/bread2.gif");
		
//		run 재정의한 것 실행
		maker.start();
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, icon, btns, null);
			
			if(choice ==0) {
//				eatBread객체를 사용하기 위해 싱글톤 실행
				BreadPlate.getInstance().eatBread();
			} else {
				System.exit(0);
//				maker.interrupt();
//				break;
			}
		}
	}
}
