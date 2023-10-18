package ch16.sec01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLBookDeleteTest {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		SQLBookSelectTest.selectBook();
		deleteBook();
	}

	public static void deleteBook() {
		// connect database (1 and 2)
		Connection connection = ConnectDatabase.makeConnection();
		Statement statement = null;
		try {
			// request info to insert from scanner
			System.out.println("Enter Book ID of book to delete > ");
			int bookID = scan.nextInt();

			// 3. to execute an INSERT statement, need to call Statement and ResultSet
			statement = connection.createStatement();
			// .executeUpdate for each tuple using UPDATE
			String deleteStatement = String.format("DELETE FROM books WHERE book_id = %d%n", bookID);
			// stores into result the number of rows inserted (0 if none)
			int result = statement.executeUpdate(deleteStatement);
					if(result == 1)	System.out.println("Book deleted successfully"); 
					else System.out.printf("Book ID %d failed to delete%n", bookID);
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
