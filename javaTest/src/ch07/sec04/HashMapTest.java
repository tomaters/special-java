package ch07.sec04;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapTest {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, String> hmTranslator = new HashMap<String, String>();
		
		hmTranslator.put("Apple", "사과");
		hmTranslator.put("Banana", "바나나");
		hmTranslator.put("Plum", "자두");
		hmTranslator.put("Potato", "감자");
		
		// to print a HashMap, a keySet needs to be created
		Set<String> keySet = hmTranslator.keySet();
		for(String key : keySet) {
			System.out.printf("%s is %s in Korean%n%n", key, hmTranslator.get(key));			
		}
		
		// search function
		while(true) {
			System.out.printf("Enter word to translate ('exit' to close):%n");
			String input = scan.nextLine().trim();
			if(input.toLowerCase().equals("exit")) break;
			String result = hmTranslator.get(input);
			if (result == null) {
				System.out.printf("%s is not in the database%n", input);
				continue;
			}
			System.out.printf("%s is %s in Korean%n", input, result);
		}
		
		System.out.println("Close");
	}
}
