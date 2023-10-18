package ch16.sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WorkoutLoggerMain {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		
		boolean stopFlag = false;
		while(!stopFlag) {
			System.out.printf(" [1] View workout log%n [2] Enter new workout%n [3] Edit workout%n [4] Remove workout%n [5] Close%n");
			int input = scan.nextInt();
			scan.nextLine(); // clear buffer
			switch(input) {
			case 1: viewLog(); break;
			case 2: enterNewWorkout(); break;
			case 3: editWorkout(); break;
			case 4: removeWorkout(); break;
			case 5: stopFlag = true; System.out.println("Program closed"); break;
			default: System.out.println("Enter a number between 1 and 4");
			}
		}
	}
	
	private static void viewLog() {
		Connection connection = connectToDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String selectStatement = "SELECT * FROM workoutlog ORDER BY workout_count ASC";
			resultSet = statement.executeQuery(selectStatement);
			while(resultSet.next()) {
				int workout_count = resultSet.getInt("workout_count");
				String workout_type = resultSet.getString("workout_type");
				int workout_duration_minutes = resultSet.getInt("workout_duration_minutes");
				Date workout_date = resultSet.getDate("workout_date");
				int workout_calories = resultSet.getInt("workout_calories");
				System.out.printf("[Workout number: %-2d] [Workout type: %-15s] [Workout duration (min): %-3s] [Workout date: %s] [Calories lost: %-4d]%n", 
						workout_count, workout_type, workout_duration_minutes, workout_date, workout_calories);
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
		
	private static void enterNewWorkout() {
		Connection connection = connectToDatabase();
		Statement statement = null;
		try {
			System.out.println("Enter Workout type > ");
			String workout_type = scan.nextLine().trim();
			System.out.println("Enter Workout duration (minutes) > ");
			int workout_duration_minutes = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Workout date (YYYY-MM-DD) > ");
			String workout_date = scan.nextLine().trim();
			System.out.println("Enter Calories lost > ");
			int calories_lost = scan.nextInt();
			scan.nextLine();
			statement = connection.createStatement();
			String insertStatement = String.format("INSERT INTO workoutlog VALUES (workoutlog_seq.nextval, '%s', '%d', '%s', '%d')", workout_type, workout_duration_minutes, workout_date, calories_lost);
			int result = statement.executeUpdate(insertStatement);
			if(result == 1)	System.out.println("Workout inserted successfully"); 
			else System.out.println("Workout failed to insert");
		} catch (SQLException e) {
			System.out.println("Query statement error");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {}
		}
	}

	private static void editWorkout() {
		Connection connection = connectToDatabase();
		viewLog();
		Statement statement = null;
		
		try {
			System.out.println("Workout Number to update >");
			int workout_count = scan.nextInt();
			scan.nextLine(); // clear buffer
			Workouts workouts = selectWorkoutNumber(workout_count);
			if(workouts == null) {
				System.out.printf("The Workout Number %d does not exist%n", workout_count);
				return;
			}
			
			System.out.printf("(%s) Update workout type > %n", workouts.getWorkout_type());
			String workout_type = scan.nextLine().trim();
			if(workout_type.equals("")) workout_type = workouts.getWorkout_type();
				
			System.out.printf("(%s minutes) Update workout duration > %n", workouts.getWorkout_duration());
			String _workout_duration = scan.nextLine().trim();
			int workout_duration = 0;
			if(_workout_duration.equals("")) {
				workout_duration = workouts.getWorkout_duration();
			} else workout_duration = Integer.parseInt(_workout_duration);
				
			System.out.printf("(%s) Update workout date (YY/MM/DD)> ", workouts.getWorkout_date());
			String workout_date = scan.nextLine().trim();
			if(workout_date.equals("")) {
				System.out.println("Error: please try again");
				return;
			}				
				
			System.out.printf("(%d calories) Update calories lost > ", workouts.getWorkout_calories());
			String _workout_calories = scan.nextLine();
			int workout_calories = 0;
			if(_workout_calories.equals("")) {
				workout_calories = workouts.getWorkout_calories();
			} else workout_calories = Integer.parseInt(_workout_calories);
				
			statement = connection.createStatement();
			String updateStatement = String.format("UPDATE workoutlog SET workout_type = '%s', workout_duration_minutes = '%d', workout_date = '%s', "
					+ "workout_calories = '%d' where workout_count = %d",
					workout_type, workout_duration, workout_date, workout_calories, workout_count);
			int count = statement.executeUpdate(updateStatement);
			if(count == 0) {
				System.out.printf("Workout %s failed to update%n", workout_count);
			} else {
				System.out.printf("Workout %s successfully updated%n", workout_count);
			}
		} catch(SQLException e) {}
	}
		
	private static Workouts selectWorkoutNumber(int workout_count) {
		Connection connection = connectToDatabase();
		Statement statement = null;
		ResultSet resultSet = null;
		Workouts workouts = null;
		try {
			statement = connection.createStatement();
			String selectQuery = String.format("SELECT * FROM workoutlog WHERE workout_count = %d", workout_count);
			resultSet = statement.executeQuery(selectQuery);
				
			if(resultSet.next()) {
				int _workout_count = resultSet.getInt("workout_count");
				String workout_type = resultSet.getString("workout_type");
				int workout_duration_minutes = resultSet.getInt("workout_duration_minutes");
				Date workout_date = resultSet.getDate("workout_date");
				int workout_calories = resultSet.getInt("workout_calories");
					
				workouts = new Workouts(_workout_count, workout_type, workout_duration_minutes, workout_date, workout_calories);
				System.out.println(workouts.toString());
			}
		} catch(SQLException e){}
		finally {
			try {
				resultSet.close();
				connection.close();
				statement.close();
			} catch(SQLException e) {}
		} return workouts;
	}
	
	private static void removeWorkout() {
		Connection connection = connectToDatabase();
		Statement statement = null;
		viewLog();
		try {
			System.out.println("Enter Workout Number that you would like to delete > ");
			int workout_number = scan.nextInt();
			statement = connection.createStatement();
			String deleteStatement = String.format("DELETE FROM workoutlog WHERE workout_count = %d%n", workout_number);
			int result = statement.executeUpdate(deleteStatement);
					if(result == 1)	System.out.println("Workout deleted successfully"); 
					else System.out.printf("Workout number %d failed to delete. Please try again%n", workout_number);
		} catch (SQLException e) {
			System.out.println("Query statement error");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {}
		}
	}
	
	private static Connection connectToDatabase() {	
			String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
			String username = "hr";
			String password = "hr";
			Connection connection = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.printf("Error: %s", e);
		} return connection;
	}

}
