package ch12.sec04;

public class WorkObject {

	public int bread;
	
	public WorkObject() {}
	
	public WorkObject(int bread) {
		this.bread = 0;
	}
	
	public synchronized void methodA() {
		this.bread = (int)(Math.random()*(25-10+1)+(10));
		System.out.printf("ThreadA methodA() processed: Jim ate %d pieces of bread%n", this.bread);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}

	public synchronized void methodB() {
		this.bread = (int)(Math.random()*(75-40+1)+(40));
		System.out.printf("ThreadB methodB() processed: Bob took %d%n", this.bread);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}
