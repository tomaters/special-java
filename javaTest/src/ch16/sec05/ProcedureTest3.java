package ch16.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcedureTest3 {

	public static Scanner scan = new Scanner(System.in);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success = false;
		String statement;
		try {
			connection = makeConnection();
			statement = "create or replace table transaction_test1 (id varchar2(10), password varchar2(10))";
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
			connection.setAutoCommit(false);
			statement = "insert into transaction_test1 values('syh1011','1111')";
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
			statement = "insert into transaction_test1 values('syh1011','2222')";
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
			statement = "insert into transaction_test1 values('syh1011','3333')";
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (success) {
					connection.commit();
			} else {
				connection.rollback();
			}
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String username = "hr";
		String password = "hr";
		Connection connection = null;
		try {
			// 1. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("OracleDriver loading complete");

			// 2. connect to oracle database
			connection = DriverManager.getConnection(url, username, password);
//			System.out.println("Oracle connection established");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.printf("Error: %s", e);
		}
		return connection;
	}
}