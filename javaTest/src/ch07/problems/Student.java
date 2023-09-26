package ch07.problems;

public class Student {
	private String name, major;
	private int id;
	private double gpa;
	
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
	
	@Override
	public boolean equals(Object obj) {
		Student student = (Student)obj;
		if(this.name == student.name && this.name.equals(student.name)) return true;
		return false;
	}
}
