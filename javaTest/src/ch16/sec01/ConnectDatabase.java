package ch16.sec01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	public static void main(String[] args) {	
		makeConnection();
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

