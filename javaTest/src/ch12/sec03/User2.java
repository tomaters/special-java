package ch12.sec03;

public class User2 extends Thread {
	
	private Calculator calculator;
	
	public User2(String name) {
		super();
		this.setName(name);
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		super.run();
		// create deadlock with User1
		this.calculator.setMemory(50);
		}

}
