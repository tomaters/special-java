package ch12.sec05;

public class ThreadStatePrinter extends Thread {
	// create thread to be checked
	private Thread targetThread;
	private boolean stopFlag;
	
	public ThreadStatePrinter(Thread targetThread) {
		super();
		this.targetThread = targetThread;
		this.stopFlag = false;
	}
		
	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	@Override
	public void run() {
		super.run();
		// check thread state and print	
		while(true) {
			State state = targetThread.getState();
			switch(state.toString()) {
				case "NEW" 				: System.out.printf("targetThread state: %s%n", state.toString()); 
											targetThread.start(); break;
				case "RUNNABLE"			: 
				case "BLOCKED"			: 
				case "TIMED_WAITING"	: 
				case "WAITING" 			: System.out.printf("targetThread state: %s%n", state.toString()); break;
				case "TERMINATED" 		: System.out.printf("targetThread state: %s%n", state.toString()); return;
			}

//			if(state == Thread.State.TERMINATED) {
//				System.out.printf("targetThread state: %s%n", state.toString());
//				break;
//			}
//			if(state == Thread.State.NEW) {
//				System.out.printf("targetThread state: %s%n", state.toString());
//				targetThread.start();
//			}
//			if(state == Thread.State.TIMED_WAITING) {
//				System.out.printf("targetThread state: %s%n", state.toString());
//			}
			
			// sets an interval to check thread state; set low to test RUNNABLE
			try {
				Thread.sleep(2);
			} catch(InterruptedException e) {		
			}
		}
	}
}