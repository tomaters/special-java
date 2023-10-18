package ch16.sec01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLBookSelectTest {
	
	public static void main(String[] args) {	
		selectBook();
	}

	public static void selectBook() {
		Connection connection = ConnectDatabase.makeConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 3. to execute a SELECT statement, need to call Statement and ResultSet
			statement = connection.createStatement();
			// leave the semicolon out of the SQL statement
			String selectStatement = "SELECT * FROM books ORDER BY book_id ASC";
			// .executeQuery for SELECT; .executeUpdate for each tuple using UPDATE
			resultSet = statement.executeQuery(selectStatement);
			// 4. print results (would only apply for SELECT statements)
			while(resultSet.next()) {
				// employee_id is numerical; use int
				int book_id = resultSet.getInt("BOOK_ID");
				String title = resultSet.getString("TITLE");
				String publisher = resultSet.getString("PUBLISHER");
				String year = resultSet.getString("YEAR");
				int price = resultSet.getInt("PRICE");
				System.out.printf("[Book ID: %-2d] [Title: %-25s] [Publisher: %-14s] [Year: %-4s] [Price: %-3d]%n", 
						book_id, title, publisher, year, price);
			}
		} catch (SQLException e) {
			System.out.println("Query statement error");
		} finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {}
		}
	}
}

