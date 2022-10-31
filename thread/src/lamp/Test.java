package lamp;

public class Test extends DeskLamp implements Runnable {
	
	final static int DELAY_MILLISECOND = 5000;
	private Thread offDelayThread; // 전원 끄기 예약 쓰레드
	private Thread previousThread;
	
	public void timerDelay() {
		if(previousThread !=null) {
			previousThread.interrupt();
		}
		offDelayThread = new Thread(this);
		offDelayThread.start();
		previousThread = offDelayThread;
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(DELAY_MILLISECOND);
			} catch (InterruptedException e) {
				System.out.println("타이머 리셋");
				break;
			}
			turnOff();
			break;
		}
	}
	
}
