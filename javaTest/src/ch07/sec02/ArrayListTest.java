package ch07.sec02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// initialize array and ArrayList
		String[] strArray = new String[10];
		ArrayList<String> strList = new ArrayList<String>(); // automatically creates ten elements
		
		// assign random numbers to indices
		for(int i = 0; i < strArray.length; i++) {
			int no = (int)(Math.random()*(100)+(1));
			strArray[i] = new String("Num " + no);
			strList.add(new String("Num " + no));
		}
		printArrayAndList(strArray, strList);
		System.out.println("*******************************************");
		
		// insert "element" into first index of array and ArrayList
		strArray[1] = new String("element"); // this will replace index [1] and leave the others untouched
		strList.add(1, "element"); // this will push back the indices after [1] by one element
		printArrayAndList(strArray, strList);
		System.out.println("*******************************************");
		
		// search indices for "element" in array and return index
		boolean isFound = false;
		int index = -1;
		for(int i = 0; i < strArray.length; i++) {
			if(strArray[i] != null && strArray[i].equals("element")) {
				isFound = true; index = i; break;
			}
		}
		System.out.printf("\"element\" is %sin the array", 
				isFound == true ? "" : "not ");
		if(isFound) System.out.printf(" at index %d%n", index);
		// search indices for "element" in ArrayList using contains(Object o) 
		System.out.printf("\"element\" is %sin the ArrayList", 
				strList.contains("element") ? "" : "not ");
		if(strList.contains("element")) System.out.printf(" at index %d%n", strList.indexOf("element"));
		System.out.println("*******************************************");

		// change ArrayList to an array and use enhanced for loop to print
		Object[] obj = strList.toArray();
		for(Object data : obj) {
			System.out.printf("[%s] ", data.toString());
		}
		System.out.println("\n*******************************************");
		// change array to ArrayList
		List<String> list = Arrays.asList(strArray);
		for(String data : list) {
			System.out.printf("<%s> ", (data != null) ? data.toString() : null);
		}
		System.out.println();
		System.out.println("*******************************************");
		
		
		// remove index: array can only be changed to null; ArrayList element can be removed with remove()
		strArray[1] = null;
		strList.remove(1);
		printArrayAndList(strArray, strList);
		System.out.println("*******************************************");
		
		// clear indices: array can only be changed to null; ArrayList elements can be removed with clear()
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = null;
		}
		strList.clear();
		//print size of array and ArrayList
		System.out.printf("strArray.length = %d%n", strArray.length); // size of array not changed
		System.out.printf("strList.size() = %d%n", strList.size()); // size of ArrayList is 0
		
		System.out.println("*******************************************");
		
		// test if array is null
		boolean isEmpty = true;
		for(int i = 0; i < strArray.length; i++)
			if(strArray[i] != null) isEmpty = false;
		System.out.printf("strArray: %s%n", (isEmpty == true) ? 
				"The array is empty" : "The array is not empty");
		// test if ArrayList is empty using isEmpty()
		System.out.printf("strList: %s%n", (strList.isEmpty() == true) ? 
				"The list is empty" : "Ths list is not empty");
		
		System.out.println("Close");
	}
	
	// print array and ArrayList function
	public static void printArrayAndList(String[] strArray, ArrayList<String> strList) {
		for(int i = 0; i < strArray.length; i++) {
			System.out.printf("strArray[%d]: %s\tstrList[%d]: %s%n", 
					i, strArray[i], i, strList.get(i));
		}
	}
}