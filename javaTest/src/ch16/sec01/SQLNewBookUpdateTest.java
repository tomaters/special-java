package ch16.sec01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLNewBookUpdateTest {

	public static Scanner scan = new Scanner(System.in);

	public static void newUpdateBooks() {
		Connection connection = ConnectDatabase.makeConnection();
		SQLBookSelectTest.selectBook();
		Statement statement = null;
		try {
			System.out.println("Book ID to update >");
			int bookID = scan.nextInt();
			scan.nextLine(); // clear buffer
			Books books = selectBookID(bookID);
			if(books == null) {
				System.out.printf("Book ID %d does not exist%n", bookID);
				return;
			}
			System.out.printf("(%s) update title > %n", books.getTitle());
			String title = scan.nextLine().trim();
			if(title.equals("")) title = books.getTitle();
			System.out.printf("(%s) update publisher > %n", books.getPublisher());
			String publisher = scan.nextLine().trim();
			if(publisher.equals("")) publisher = books.getPublisher();
			System.out.printf("(%s) update year > ", books.getYear());
			String year = scan.nextLine().trim();
			if(year.equals("")) year = books.getYear();
			System.out.printf("(%d) update price > ", books.getPrice());
			String _price = scan.nextLine();
			int price = 0;
			if(_price.equals("")) {
				price = books.getPrice();
			} else price = Integer.parseInt(_price);
			statement = connection.createStatement();
			String updateStatement = String.format("UPDATE books SET title = '%s', publisher = '%s', year = '%s', price = '%d' where book_id = %d",
					title, publisher, year, price, bookID);
			int count = statement.executeUpdate(updateStatement);
			if(count == 0) {
				System.out.printf("Book ID %s failed to update%n", bookID);
			} else {
				System.out.printf("Book ID %s successfully updated%n", bookID);
			}
		} catch(SQLException e) {}
	}
	
	private static Books selectBookID(int bookID) {
		Connection connection = ConnectDatabase.makeConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		Books books = null;
		try {
			statement = connection.createStatement();
			String selectQuery = String.format("SELECT * FROM books WHERE book_id = %d", bookID);
			resultSet = statement.executeQuery(selectQuery);
			
			if(resultSet.next()) {
				int _bookID = resultSet.getInt("BOOK_ID");
				String title = resultSet.getString("TITLE");
				String publisher = resultSet.getString("PUBLISHER");
				String year = resultSet.getString("YEAR");
				int price = resultSet.getInt("PRICE");
				
				books = new Books(_bookID, title, publisher, year, price);
				System.out.println(books.toString());
			}
		} catch(SQLException e){}
		finally {
			try {
				resultSet.close();
				connection.close();
				statement.close();
			} catch(SQLException e) {}
		} return books;
	}
}
