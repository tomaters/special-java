package ch12.sec02;

public class ThreadMain {
	public static void main(String[] args) {
		
		Thread thread = Thread.currentThread();
		System.out.println("This is a thread test");
		System.out.printf("Name of thread : %s%n", thread.getName());
		thread.setName("oh yah");
		System.out.printf("New name of thread : %s%n-----------------------%n", thread.getName());
		
		System.out.println("Start");
		for(int i = 0; i < 10; i ++) {
			Thread thread2 = new CalculateThread("Thread-" + i);
			// even if Thread-9 is given the highest priority, it will not always finish first
			if(i == 9) thread2.setPriority(Thread.MAX_PRIORITY);
			else thread2.setPriority(Thread.MIN_PRIORITY);
			
			thread2.start();
		}
		// main thread continues to execute after other threads begin
		// it does not need to wait for the other threads to finish before closing
		System.out.println("Close");
	}
}
