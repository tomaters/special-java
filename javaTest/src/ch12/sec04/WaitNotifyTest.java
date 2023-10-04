package ch12.sec04;

public class WaitNotifyTest {
// because wait() and notify() are used in WorkObject, the processor alternates threads
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();
		System.out.println("Main thread closed");
	}
}
