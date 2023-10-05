package ch12.sec05;

public class TargetThread extends Thread {

	@Override
	public void run() {
		super.run();
		for(long i = 0; i < 2000000000; i++) {
			// RUNNABLE
		}
		
		// TIMED_WAITING
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(long i = 0; i < 2000000000; i++) {
			// RUNNABLE
		}
		
	}	
}