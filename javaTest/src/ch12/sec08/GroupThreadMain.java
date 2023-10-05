package ch12.sec08;

import java.util.Map;
import java.util.Set;

public class GroupThreadMain {

	public static void main(String[] args) {
		
		PrintThread printThread = new PrintThread("myThread");
		
		printThread.setDaemon(true);
		printThread.setPriority(Thread.MAX_PRIORITY);
		printThread.start();
		
		// returns a Map<Thread, StackTraceElement[]> of all live threads
		Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
		Set<Thread> set = threadMap.keySet();		
		System.out.println("Number of live threads: " + set.size());
		System.out.println("--------------------------------------------------------------");
		
		// two ways to bring: iterator or enhanced for loop
		for(Thread thread : set) {
			System.out.printf("Thread name: %s%n", thread.getName());
			System.out.printf("Thread type: %s%n", thread.isDaemon() ? "daemon" : "user");
			System.out.printf("Thread group: %s%n", thread.getThreadGroup());
			System.out.println("--------------------------------------------------------------");
		}
		System.out.println("Main thread closed");
	}

}
