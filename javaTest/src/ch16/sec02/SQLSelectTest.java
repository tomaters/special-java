package ch16.sec02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch16.sec01.ConnectDatabase;

public class SQLSelectTest {
	
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
			String selectStatement = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
			// .executeQuery for SELECT; .executeUpdate for each tuple using UPDATE
			resultSet = statement.executeQuery(selectStatement);
			// 4. print results (would only apply for SELECT statements)
			while(resultSet.next()) {
				// employee_id is numerical; use int
				int employee_id = resultSet.getInt("EMPLOYEE_ID");
				String first_name = resultSet.getString("FIRST_NAME");
				String last_name = resultSet.getString("LAST_NAME");
				String email = resultSet.getString("EMAIL");
				Date hire_date = resultSet.getDate("HIRE_DATE");
				String job_id = resultSet.getString("JOB_ID");
				double salary = resultSet.getDouble("SALARY");
				int manager_id = resultSet.getInt("MANAGER_ID");
				int department_id = resultSet.getInt("DEPARTMENT_ID");
				System.out.printf("[Employee ID: %d] [First name: %-11s] [Last name: %-11s] [Email: %15s] "
						+ "[Hire date: %s] [Job ID: %-10s] [Salary: %-8.2f] [Manager ID: %-3d] [Department ID: %-3d]%n", 
						employee_id, first_name, last_name, email, hire_date, job_id, salary,
						manager_id, department_id);
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

