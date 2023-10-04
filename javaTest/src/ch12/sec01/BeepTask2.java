package ch12.sec01;

public class BeepTask2 implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("beep");
			Thread.sleep(1000);
			System.out.println("beep");
			Thread.sleep(1000);
			System.out.println("beep");
			Thread.sleep(1000);
			System.out.println("beep");
			Thread.sleep(1000);
			System.out.println("beep");
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Working thread closed");
		}
	}
}
