package lamp;

import javax.swing.JOptionPane;

import bakery.BreadPlate;

public class LampOperation {
	
	
	
	public static void main(String[] args) {
		TimerDeskLamp timerDeskLamp = new TimerDeskLamp();
		Thread lampOffReservationStart = new Thread(timerDeskLamp);
		String[] btns = {"램프 켜기", "밝기 조절", "끄기예약", "끄기"};
		
		int choice = 0, count = 0;
		
		SimpleDeskLamp simpleDeskLamp = new SimpleDeskLamp();
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null, btns, null);
			
			if(choice == 0) {
				simpleDeskLamp.turnOn();
				System.out.println("전원이 켜졌습니다.");
				System.out.println("현재 밝기: " + simpleDeskLamp.getBright());
			}
			else if(choice == 1) {
				simpleDeskLamp.nextBright();
				System.out.println("현재 밝기: " + simpleDeskLamp.getBright());
			}
			
			else if(choice == 2) {
				timerDeskLamp.offDelay();
			}
			else {
				simpleDeskLamp.turnOff();
				System.exit(0);
			}
				
		}
		
	}
	
}
