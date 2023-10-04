package ch12.sec03;

public class CalculatorMain {

	public static void main(String[] args) throws InterruptedException {
		
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1("user1");
		User2 user2 = new User2("user2");
		
		user1.setCalculator(calculator);
		user1.start();
		System.out.println("Main thread closed");
		
		user2.setCalculator(calculator);
		
		// also makes user2 wait until user1 is done
//		user1.join(); 

		user2.start();
		System.out.println("Working thread closed");
		// when user1 is run independently, it returns 100 memory
		// but when it is run with user2, it returns 50
	}
}
