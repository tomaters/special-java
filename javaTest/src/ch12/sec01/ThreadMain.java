package ch12.sec01;

import java.awt.Toolkit;

// make computer beep five times with one-second intervals while printing "beep" in those same intervals
public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// cannot call threads in this way; threads will not run concurrently
/*		BeepTask beepTask = new BeepTask();
		beeptask.run();
*/

		// FIRST METHOD: choose to override run() of Thread; two options for constructor
/*		Thread thread = new Thread(beepTask);
		Thread thread = new BeepTask();
		thread.start();
*/
		
		// SECOND METHOD: need to override run() of Runnable; two options for constructor
/*		BeepTask2 beepTask2 = new BeepTask2();
		Runnable runnable = new BeepTask2();
		Thread thread = new Thread(runnable);
		thread.start();
*/
		
		// THIRD METHOD: anonymous class using Thread; no need for another class; similar to first method
/*		Thread thread = new Thread() {
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
		};
		thread.start();
*/		

		// FOURTH METHOD: anonymous class using Runnable; similar to second method
/*		Thread thread = new Thread(new Runnable() {

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
			}});
		thread.start();
*/
		
		// FIFTH METHOD: anonymous class using Runnable lambda expression
		Thread thread = new Thread(()-> {
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
		});
		thread.start();
		
		// there is only a single main thread, so a delay occurs before the printing begins
/*		System.out.println("beep");
		Thread.sleep(1000);
		System.out.println("beep");
		Thread.sleep(1000);
		System.out.println("beep");
		Thread.sleep(1000);/		
		System.out.println("beep");
		Thread.sleep(1000);
		System.out.println("beep");
*/		
		// using threads, it is possible to make the beeps and prints occur "simultaneously" 
		
		toolkit.beep();
		Thread.sleep(1000); // thread delays one second; throw exception because it can be interrupted
		toolkit.beep();
		Thread.sleep(1000);
		toolkit.beep();
		Thread.sleep(1000); 
		toolkit.beep();
		Thread.sleep(1000); 
		toolkit.beep();
		
		System.out.println("Main thread closed");
	}
}