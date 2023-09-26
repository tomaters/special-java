package ch07.sec05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapStudentEx {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();

	map.put("Jim", new Student(1, "123-456-7890"));
	map.put("Bob", new Student(2, "234-567-8901"));
	map.put("Joe", new Student(3, "345-678-9012"));
	
	// print using keySet. because this is a HashMap, the order of which the elements are stored depends on the hashcode 
	Set<String> keySet = map.keySet();
	for(String key : keySet) {
		Student student = map.get(key);
		System.out.printf("Name: %s  SID:%s  Phone: %s%n", 
				key, student.getSid(), student.getPhone());
	}
	System.out.println("--------------------------------------");

	// print using iterator
	Iterator<String> iterator = keySet.iterator();
	while(iterator.hasNext()) {
		String name = iterator.next();
		System.out.printf("Name: %s%n%s", name, map.get(name)); // toString is overridden in Student.java to print SID and Phone (in a different format compared to above)
	}
	System.out.println("--------------------------------------");
	
	// scan for name to print SID and phone number
	while(true) {
		System.out.println("Search name ('exit' to close): ");
		String name = scan.nextLine().trim();
		if(name.toLowerCase().equals("exit")) break;
		Student student = map.get(name);
		if(student == null) System.out.printf("%s does not exist in the system%n", name);
		else System.out.println(student.toString()); 
	}
	System.out.println("Close");
	
	}
}
