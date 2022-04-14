package com.bia.web.model;

import java.util.List;

public class ClassRoom {
	
	private int id;
	private String name;
	private String teacher;
	private List<Student> students;
	
	public ClassRoom(int id, String name, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	
	

	public ClassRoom(int id) {
		super();
		this.id = id;
	}



	public ClassRoom(String name, String teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
	}



	public ClassRoom() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	

	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}



	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
	
}
