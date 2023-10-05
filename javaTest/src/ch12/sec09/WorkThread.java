package ch12.sec09;
// test using ThreadGroup
public class WorkThread extends Thread {

	public WorkThread(ThreadGroup group, String name) {
		super(group, name);
		this.setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.printf("%s working thread running%n", getName());
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.printf("%s thread interrupted%n", getName());
				break;
			}
		} 
		System.out.printf("%s process complete%n", getName());
	}
}
