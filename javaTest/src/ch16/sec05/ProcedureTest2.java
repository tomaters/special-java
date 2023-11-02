package ch16.sec05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureTest2 {
	
	public static Scanner scan = new Scanner(System.in);
			
	public static void main(String[] args) {
		CallableStatement callableStatement = null;
		Connection connection = null;
		int empNum = 0;
		// input values
		System.out.println("Enter employee number: ");
		empNum = scan.nextInt();
		scan.nextLine();
		
		try {
			connection = makeConnection();
			callableStatement = connection.prepareCall("{call proc02(?, ?)}");
			callableStatement.setInt(1, empNum);
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			int result = callableStatement.executeUpdate();
			if(result == 0) {
				throw new SQLException();
			}
			System.out.println(callableStatement.getString(2));
			// using a int result here will give 1 if the procedure is executed no matter what
		} catch(SQLException e) {
			System.out.println("SQL Error");
		} catch(Exception e) {
			System.out.println("Java Error");
		} finally {
			try {
				callableStatement.close();
				connection.close();				
			} catch(SQLException e) {
				System.out.println("SQL Error");
			}
		}
		System.out.println("End");
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
