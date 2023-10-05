package ch12.sec09;

public class GroupThreadMain {

	public static void main(String[] args) {
		// myGroup is automatically placed in system & main group
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		
		// place threads in myGroup, not main group
		// done by assigning a group in the thread constructor parameter:
		WorkThread workThreadA = new WorkThread(myGroup, "WorkThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "WorkThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[Print main thread group list() method]");
		// current thread is main thread; gets thread group of main thread
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("--------------------------------------------------");
		// prints information about thread group
		mainGroup.list();
		System.out.println("--------------------------------------------------");
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {}
		// interrupts all threads in myGroup (workThreadA and workThreadB)
		myGroup.interrupt();
		
		System.out.println("Main thread closed");
	}

}
