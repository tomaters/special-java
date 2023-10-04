package ch12.sec03;

public class User1 extends Thread {

	private Calculator calculator;
	
	public User1(String name) {
		super();
		this.setName(name);
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		super.run();
		// create deadlock with User2
		this.calculator.setMemory(100);
	}
}
