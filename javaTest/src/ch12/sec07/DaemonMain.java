package ch12.sec07;
	// if working thread is a user thread, it keeps running
	// if it is a daemon thread, it stops if the main thread is closed
public class DaemonMain {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new PrintThread();
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		Thread.sleep(1000);
		
		System.out.println("Main thread closed");
	}
}
