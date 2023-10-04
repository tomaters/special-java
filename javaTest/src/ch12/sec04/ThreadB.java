package ch12.sec04;

public class ThreadB extends Thread {

	public ThreadB(WorkObject workObject) {	
		this.workObject = workObject;
	}
	
	private WorkObject workObject;

	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
