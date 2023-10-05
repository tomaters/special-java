package ch12.sec08;

public class PrintThread extends Thread {
	public PrintThread(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.printf("%s is running%n", getName());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
	}
}
