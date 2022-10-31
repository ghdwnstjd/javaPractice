package lamp;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 전원 끄기 예약이 가능한 책상 조명
 */
public class TimerDeskLamp extends DeskLamp implements Runnable {

    final static int DELAY_MILLISECOND = 5000; // 5초 사용

    private Thread offDelayThread; // 전원 끄기 예약 쓰레드
    private Thread previousThread;

    // TODO - TimerDeskLamp 클래스의 나머지 코드를 구현해 주세요.
    
//	1. 전원 끄기 예약을 누르면 5초 후에 전원이 꺼지도록 구현
//	- 전원 끄기 예약 기능은 메소드로 구현
//2. TimerDeskLamp 클래스 나머지 코드 구현
//3. TimerDeskLamp 클래스는 DeskLamp 클래스를 꼭 상속받아야 함 v
//4. 전원 끄기 예약이 되어 있는 경우 마지막에 예약한 시점부터 다시 타이머가 시작되어야함
//	- 전원 끄기 예약 중에 예약이 시도되는 경우 타이머 리셋 문자열이 출력
//5. 다른 클래스 내용 변경 불가 v
//6. 기능 구현을 위한 새로운 파일 추가 무방
    
    
//    전원 끄기 예약 기능 메소드
    public void offDelay() {
    	if(previousThread != null) { //이미 실행 중인 것이 있다면
    		previousThread.interrupt(); //interrrupt() 실행
    	}
    	offDelayThread = new Thread(this); //
    	offDelayThread.start();
    	previousThread = offDelayThread;
    }
    
    public void waitStart() {
//		이거 하면 안돌아감..
    	for (int i = 0; i < 5; i++) {
    		try {Thread.sleep(1000);} catch (InterruptedException e) {break;}
    		System.out.println(i+1 + "초");
    	}	
    }
    
    
//    전원 끄기 예약 버튼
    @Override
    public synchronized void run() {
//    	예약 여부 확인
    	while(true) {
	    	try {
//	    		waitStart();
		    	Thread.sleep(DELAY_MILLISECOND);
	    	} catch (InterruptedException e) {
	    		System.out.println("타이머 리셋");
	    		break;
	    	}
		    turnOff();
		    previousThread = null;
		    break;
    	}
    }
}
