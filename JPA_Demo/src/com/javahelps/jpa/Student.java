package com.javahelps.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name ="student_id",unique = true)
	private int id;
	
	@Column(name ="student_name",nullable = false)
	private String name;
	
	@Column(name ="student_age",nullable = false)
	private int age;
		
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;	
	}
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return id + "\t" + name + "\t" + age;
	}
}

