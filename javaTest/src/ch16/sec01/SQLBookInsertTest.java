package ch16.sec01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLBookInsertTest {

	public static Scanner scan = new Scanner(System.in)	;
	
	public static void main(String[] args) {
		insertBook();
	}

	public static void insertBook() {
		// connect database (1 and 2)
		Connection connection = ConnectDatabase.makeConnection();
		Statement statement = null;
		try {
			// request info to insert from scanner
			System.out.println("Enter Book Title > ");
			String title = scan.nextLine().trim();
			System.out.println("Enter Publisher > ");
			String publisher = scan.nextLine().trim();
			System.out.println("Enter Publication Year > ");
			String year = scan.nextLine().trim();
			System.out.println("Enter Book Price > ");
			int price = scan.nextInt();
			
			// 3. to execute an INSERT statement, need to call Statement and ResultSet
			statement = connection.createStatement();
			// .executeUpdate for each tuple using UPDATE
			String insertStatement = String.format("INSERT INTO books VALUES (book_id_seq.nextval, '%s', '%s', '%s', '%d')", title, publisher, year, price);
			// stores into result the number of rows inserted (0 if none)
			int result = statement.executeUpdate(insertStatement);
			if(result == 1)	System.out.println("Book inserted successfully"); 
			else System.out.println("Book failed to insert");
		} catch (SQLException e) {
			System.out.println("Query statement error");
		} finally {
			try {
				statement.close();
				scan.close();
			} catch (SQLException e) {}
		}
	}
}