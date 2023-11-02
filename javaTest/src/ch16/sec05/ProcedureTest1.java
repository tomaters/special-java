package ch16.sec05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcedureTest1 {
	
	public static Scanner scan = new Scanner(System.in);
			
	public static void main(String[] args) {
		CallableStatement callableStatement = null;
		Connection connection = null;
		int deptNum = 0;
		double rate = 0.0;
		// input values
		System.out.println("Enter department number: ");
		deptNum = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter rate: ");
		rate = scan.nextDouble();
		scan.nextLine();
		
		try {
			connection = makeConnection();
			callableStatement = connection.prepareCall("{call updatesalary(?, ?)}");
			callableStatement.setInt(1, deptNum);
			callableStatement.setDouble(2, rate);
			callableStatement.executeUpdate();
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
