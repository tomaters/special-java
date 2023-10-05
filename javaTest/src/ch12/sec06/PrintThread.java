package ch12.sec06;

public class PrintThread extends Thread {

	private boolean stopFlag;
	
	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	@Override
	public void run() {	
		try {
			while(!stopFlag) {
				System.out.printf("%s working thread running%n", this.getName());
				Thread.sleep(500);
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Working thread closed");
	}
}
