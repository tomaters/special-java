package ch16.sec03;

import java.sql.Date;
import java.util.Objects;

public class Workouts {

	private int workout_count;
	private String workout_type;
	private int workout_duration_minutes;
	private Date workout_date;
	private int workout_calories;
	
	public Workouts(int workout_count, String workout_type, int workout_duration, Date workout_date,
			int workout_calories) {
		super();
		this.workout_count = workout_count;
		this.workout_type = workout_type;
		this.workout_duration_minutes = workout_duration;
		this.workout_date = workout_date;
		this.workout_calories = workout_calories;
	}

	public int getWorkout_count() {
		return workout_count;
	}

	public String getWorkout_type() {
		return workout_type;
	}

	public int getWorkout_duration() {
		return workout_duration_minutes;
	}

	public Date getWorkout_date() {
		return workout_date;
	}

	public int getWorkout_calories() {
		return workout_calories;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(workout_count);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Workouts)) {
			return false;
		}
		Workouts workouts = (Workouts)obj;
		return this.workout_count == workouts.workout_count;	
	}
	
	@Override
	public String toString() {
		return String.format("[Workout number: %-2d] [Workout type: %-15s] [Workout duration (min): %-3s] [Workout date: %s] [Calories lost: %-4d]%n", 
				workout_count, workout_type, workout_duration_minutes, workout_date, workout_calories);
	}	
}
