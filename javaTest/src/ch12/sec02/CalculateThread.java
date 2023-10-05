package ch12.sec02;

public class CalculateThread extends Thread {

	public CalculateThread(String name) {
		// sets name of thread
		this.setName(name);
	}

	@Override
	public void run() {
		super.run();
		// print thread name after running many loops
		for(int i = 0; i < 2000000000; i++) {}
		System.out.println(getName() + " completed task" + getState().toString());
	}
	
}
