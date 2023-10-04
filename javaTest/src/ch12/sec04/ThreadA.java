package ch12.sec04;

public class ThreadA extends Thread {

	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	private WorkObject workObject;

	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}
}
