package ch07.problems;

import java.util.Objects;

public class HonorRoll {

	private String name;
	private double gpa;

	public HonorRoll() {
		this(null, 0.0);
	}
	
	public HonorRoll(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}
	public double getGpa() {
		return gpa;
	}
	
	@Override
	public String toString(){
		return String.format(this.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, gpa);
	}
	
	@Override
	public boolean equals(Object obj) {
		HonorRoll stu = null;
		if(!(obj instanceof Student)) {
			return false;
		}
		stu = (HonorRoll) obj;
		if(this.name.equals(stu.name) && this.gpa == stu.gpa) {
			return true;
		}
		return false;
	}
}
