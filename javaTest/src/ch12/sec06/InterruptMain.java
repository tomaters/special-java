package ch12.sec06;
	// ways to stop thread: using a flag / interrupting 
	// (using stop() <- deprecates; do not use)
public class InterruptMain {

	public static void main(String[] args) throws InterruptedException {
		PrintThread printThread = new PrintThread();
		printThread.start();
		System.out.println("Main thread running");
		
		Thread.sleep(2000);
//		printThread.setStopFlag(true);
		printThread.interrupt();
		
		System.out.println("Main thread closed");
	}

}
