package ch16.sec01;

import java.util.Scanner;

public class BookMain {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean stopFlag = false;
		while(!stopFlag) {
			System.out.printf("[1] View book list%n[2] Add new book%n[3] Delete book%n[4] Update book%n[5] NEW update book%n[6] Close");
			int input = scan.nextInt();
			switch(input) {
				case 1: SQLBookSelectTest.selectBook(); break;
				case 2: SQLBookInsertTest.insertBook(); break;
				case 3: SQLBookDeleteTest.deleteBook(); break;
				case 4: SQLBookUpdateTest.updateBook(); break;
				case 5: SQLNewBookUpdateTest.newUpdateBooks(); break;
				case 6: stopFlag = true; break;
				default: System.out.println("Enter a number between 1 and 5");
			}
		}
		System.out.println("Close");
	}

}
