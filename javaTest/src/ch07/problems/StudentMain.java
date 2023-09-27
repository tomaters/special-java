package ch07.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static final int NUM_STUDENTS = 4;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<Student>(); // this works because List is a superclass of ArrayList
		
		System.out.printf("Enter student name, major, ID, and GPA for %d people:%n", NUM_STUDENTS);
		for(int i = 0; i < NUM_STUDENTS; i++) {	
			System.out.println(">>");
			String name = scan.next();
			String major = scan.next();
			int id = scan.nextInt();
			double gpa = scan.nextDouble();
			studentList.add(new Student(name, major, id, gpa));
		}
		for(int i = 0; i < NUM_STUDENTS; i++) {
			System.out.println("----------------------------");
			System.out.println(studentList.get(i));
		}
		
/*		for(;true;) {
			boolean isFound = false;
			Iterator<Student> iterator = studentList.iterator();
			System.out.println("----------------------------");
			System.out.println("Enter student name to search ('x' to close): ");
			String name = scan.next();
			if(name.toLowerCase().equals("x")) break;
			while(iterator.hasNext()) {
				Student stu = iterator.next();
				if(name.equals(stu.getName())) {
					System.out.println(stu.toString());
					isFound = true;
					break;
				}
			}
			if(!isFound) System.out.println("That name is not in the system");
		}
*/		

		// search using ArrayList methods instead of a loop
		while(true) {
			System.out.println("Enter student name to search ('x' to close):");
			String name = scan.next().trim();
			if(name.toLowerCase().equals("x")) break;
			System.out.println("Enter student ID:");
			int id = Integer.parseInt(scan.next().trim());
			Student stu = new Student(name, id);
			boolean isFound = studentList.contains(stu);
			if(isFound) {
				System.out.printf("%s%n", studentList.get(studentList.indexOf(stu)));
				continue;
			}
			System.out.println("That student and ID is not in the system");
		}
		
		scan.close();
		System.out.println("Close");
	}

}
