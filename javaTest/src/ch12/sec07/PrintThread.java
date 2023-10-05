package ch12.sec07;

public class PrintThread implements Runnable {

	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println("Working thread running");
		}
	}
}
