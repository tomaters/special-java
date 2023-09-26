package ch07.sec05;

import java.util.Objects;

public class Student {
	private int sid;
	private String phone;
	public Student(int sid, String telephone) {
		this.sid = sid;
		this.phone = telephone;
	}
	
	public int getSid() {
		return sid;
	}
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return String.format("SID: %d%nPhone: %s%n", sid, phone);
	}
	
	@Override
	public boolean equals(Object obj) {
		Student student = (Student)obj;
		if(this.sid == student.sid && this.phone.equals(student.phone)) {
			return true;
		} return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(sid + phone);
	}
}
