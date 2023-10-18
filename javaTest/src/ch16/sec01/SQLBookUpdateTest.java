package ch16.sec01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLBookUpdateTest {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		SQLBookSelectTest.selectBook();
		updateBook();
	}

	public static void updateBook() {
		Connection connection =  ConnectDatabase.makeConnection();
		Statement statement = null;
		try {
			// request query details through scanner
			System.out.println("Enter ID of book to update > ");
			int bookID = scan.nextInt();
			scan.nextLine(); // clear scanner buffer
			System.out.println("Enter book title to update > ");
			String title = scan.nextLine().trim();
			System.out.println("Enter book publisher to update > ");
			String publisher = scan.nextLine().trim();
			System.out.println("Enter book year to update > ");
			String year = scan.nextLine().trim();
			System.out.println("Enter book price to update > ");
			int price = scan.nextInt();
			scan.nextLine(); // clear scanner buffer
			// execute update query
			statement = connection.createStatement();
			String updateStatement = String.format("UPDATE books SET title = '%s', publisher = '%s', year = '%s', price = '%d' where book_id = %d",
					title, publisher, year, price, bookID);
			int count = statement.executeUpdate(updateStatement);
			// print result
			if(count == 0) {
				System.out.printf("Book ID %s failed to update%n", bookID);
			} else {
				System.out.printf("Book ID %s successfully updated%n", bookID);
			}
		} catch (SQLException e){
			System.out.println("Query error");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch(SQLException e) {}
		}
	}

}
