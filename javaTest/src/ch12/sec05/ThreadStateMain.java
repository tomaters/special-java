package ch12.sec05;

public class ThreadStateMain {

	public static void main(String[] args) {
		TargetThread targetThread = new TargetThread();
		ThreadStatePrinter threadStatePrinter = new ThreadStatePrinter(targetThread);
		threadStatePrinter.start();
		threadStatePrinter.setStopFlag(true);
		System.out.println("Main thread closed");
	}
}
