package ch07.sec03;

import java.util.HashSet;
import java.util.Iterator;

public class LottoSetTest {

	public static void main(String[] args) {
		// print six random numbers between 1 and 45 with no repeating numbers
		HashSet<Integer> hset = new HashSet<Integer>();
		for(;true;) {
			int num = (int)(Math.random()*(45-1)+(1));
			hset.add(num); // auto-unboxing
			if(hset.size() >= 6) break;
		}
		for(Integer data : hset) {
			System.out.printf("%d  ", data);
		}
		System.out.println();
		
		// same result but using iterator
		Iterator<Integer> iterator = hset.iterator();
		while(iterator.hasNext()) {
			int num = iterator.next();
			System.out.printf("%d  ", num);
		}
		
	System.out.printf("%nClose");
	}
}
