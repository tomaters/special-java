package ch07.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentMain {

	public static final int NUM_STUDENTS = 4;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		ArrayList<Student> student = new ArrayList<Student>();
		
		for(int i = 0; i < NUM_STUDENTS; i++) {	
			System.out.println("Enter student name, major, ID, and GPA:");
			System.out.println(">>");
			String name = scan.next();
			String major = scan.next();
			int id = scan.nextInt();
			double gpa = scan.nextDouble();
			student.add(new Student(name, major, id, gpa));
		}
		for(int i = 0; i < NUM_STUDENTS; i++) {
			System.out.println("----------------------------");
			System.out.println(student.get(i));
		}
		
		for(;true;) {
			boolean isFound = false;
			Iterator<Student> iterator = student.iterator();
			System.out.println("----------------------------");
			System.out.println("Enter student name ('x' to close): ");
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
		
		System.out.println("Close");
	}

}
