package ch07.problems;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HonorRollMain {

	public static Scanner scan = new Scanner(System.in);
	public static final int NUM_STUDENTS = 5;
	public static void main(String[] args) {

		HashMap<String, HonorRoll> honorList = new HashMap<String, HonorRoll>();
		System.out.println("Honor Roll Designation System");
		
		for(int i = 0; i < NUM_STUDENTS; i++) {
			System.out.println("Enter name and GPA >>");
			String name = scan.next().trim();
			double gpa = scan.nextDouble();
			honorList.put(name, new HonorRoll(name, gpa));
		}
		
		System.out.println("Enter GPA requirement for Honor Roll >>");
		double requirement = scan.nextDouble();
		
		Set<String> keySet = honorList.keySet();
		System.out.println("The students in the honor roll are:");
		for(String key : keySet) {
			HonorRoll honorRoll = honorList.get(key);
			if(honorRoll.getGpa() >= requirement) {
				System.out.printf("[%s] ", honorRoll.getName());
			}			
		}
		System.out.printf("%nClose");
	}
}
