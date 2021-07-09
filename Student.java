package com.te.StudentDataBase;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_info")
public class Student implements Serializable{
	
	@Id
	private int rollno;
	
	private String name;
	private long phno;
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", phno=" + phno + ", dob=" + dob + "]";
	}
	private String dob;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
