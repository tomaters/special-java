package ch12.sec03;

public class Calculator {

	private int memory;
	
	public Calculator() {
		super();
	}
	
	public int getMemory() {
		return memory;
	}
	
	// if not synchronized, deadlock will occur and user1 will return 50
	public synchronized void setMemory(int memory) { 
		this.memory = memory;
		try {
			Thread.sleep(0, 1);; // will cause context switching
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " = " + this.memory);
	}
}
