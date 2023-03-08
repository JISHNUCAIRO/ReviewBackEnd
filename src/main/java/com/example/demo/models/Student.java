package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int id;
private String Name;
private String Department;
private String emailId;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String Name, String Department, String emailId) {
	super();
	this.id = id;
	this.Name = Name;
	this.Department = Department;
	this.emailId = emailId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String Department) {
	this.Department = Department;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

}