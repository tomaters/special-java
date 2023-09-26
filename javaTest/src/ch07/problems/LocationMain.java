package ch07.problems;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LocationMain {

	public static final int NUM_INPUTS = 4;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, Location> locationMap = new HashMap<String, Location>();
		System.out.println("Enter city, longitude, and latutude.");
		
		for(int i = 0; i < NUM_INPUTS; i++) {
			System.out.println(">>");
			String location = scan.next();
			int longitude = scan.nextInt();
			int latitude = scan.nextInt();
			Location loc = new Location(longitude, latitude);
			locationMap.put(location, loc);
		}
		System.out.println("--------------------------");
		
		Set<String> keySet = locationMap.keySet();
		for(String key : keySet)
			System.out.printf("Location: %s\t%s%n", key, locationMap.get(key));	
		System.out.println("--------------------------");

		for(;true;) {
			System.out.println("Enter Location ('X' to close)>> ");
			String location = scan.next();
			if(location.toLowerCase().equals("x")) break;
			Location result = locationMap.get(location);
			if(result == null) {
				System.out.println("That location does not exist in this record");
				continue;
			}
			System.out.printf("Location: %s\t%s%n", 
					location, locationMap.get(location));	
		}
			
		System.out.println("--------------------------");
		System.out.println("Close");
	}
}
