package ch07.problems;

import java.util.Objects;

public class Student {
	private String name;
	private String major;
	private int id;
	private double gpa;
	
	public Student() {
		this(null, null, 0, 0.0);
	}
	
	public Student(String name, int id) {
		this(name, null, id, 0.0);
	}
	
	public Student(String name, String major, int id, double gpa) {
		super();
		this.name = name;
		this.major = major;
		this.id = id;
		this.gpa = gpa;
	}
	
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getId() {
		return id;
	}
	public double getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return String.format("Name: %s%nMajor: %s%nID: %d%nGPA: %.2f", 
				this.name, this.major, this.id, this.gpa);
	}
	
	// need to compare objects (non-repeatable; [name & id] in this case) because hashSets have no repeating keys
	// so override hashCode and equals
	@Override 
	public int hashCode() {
		return Objects.hash(this.name, this.id);
	}
	
	@Override
	public boolean equals(Object obj) {
		Student stu = null;
		if(!(obj instanceof Student)) {
			return false;
		}
		stu = (Student)obj;
		if(this.name.equals(stu.name) && this.id == stu.id) return true;
		return false;
	}
}
