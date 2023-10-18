package ch16.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ch16.sec01.ConnectDatabase;

public class PreparedStatementTest {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean stopFlag = false;
		while(!stopFlag) {
			System.out.println("1 to create table, 2 to insert member, 3 to view members, 4 to remove a member, 5 to close");
			int input = scan.nextInt();
			switch(input) {
			case 1: createMemberTable(); break;
			case 2: insertMember(); break;
			case 3: viewMembers(); break;
			case 4: break; // add drop function
			case 5: stopFlag = true; System.out.println("Close");
			}
		}
		
//		PreparedStatement preparedStatement = null;
//		Connection connection = ConnectDatabase.makeConnection();
//		ResultSet resultSet = null;
//			try {
//				int employee_id = 100;
//				String selectStatement = String.format("select first_name, job_id, salary from employees where employee_id = ?");
//				preparedStatement = connection.prepareStatement(selectStatement);
//				preparedStatement.setInt(1, employee_id);
//				resultSet = preparedStatement.executeQuery();
//				
//				while(resultSet.next()) {
//					System.out.printf("ename: %s, job: %s, salary: %s", 
//							resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
//				}
//				
//			} catch (SQLException e) {
//				System.out.println("Query statement error");
//			} finally {
//				try {
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				} catch (SQLException e) {}
//			}
	}
	
	public static void createMemberTable() {
		Connection connection = ConnectDatabase.makeConnection();
		PreparedStatement preparedStatement = null;
		try {
			String tableStatement = String.format("create table member(" + 
			    "id varchar2(10) not null, " +
			    "password varchar2(10) not null, " +
			    "name varchar2(5) not null, " +
			    "constraint member_id_pk primary key(id))");
			preparedStatement = connection.prepareStatement(tableStatement);
			int result = preparedStatement.executeUpdate();
			if(result != 1) {
				System.out.println("Table created");
			} else System.out.println("Error");
		}catch (SQLException e){
			System.out.println("Error: table already exists");
		}
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void insertMember() {
		Connection connection = ConnectDatabase.makeConnection();
		PreparedStatement preparedStatement = null;
		try {
			scan.nextLine();
			System.out.println("Enter ID");
			String id = scan.nextLine();
			System.out.println("Enter PW");
			String password = scan.nextLine();
			System.out.println("Enter Name");
			String name = scan.nextLine();
			
			String insertStatement = String.format("insert into member values(?, ?, ?)");
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			
			int result = preparedStatement.executeUpdate();
			if(result >= 1) {
				System.out.println("Insert statement successful");
			} else System.out.println("Insert statement unsuccessful");
		} catch(SQLException e) {}
	}
	
	public static void viewMembers() {
		Connection connection = ConnectDatabase.makeConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectStatement = "select * from member order by id asc";
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String data = String.format("%-10s\t%-10s\t%-10s", id, password, name);
				System.out.println(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
