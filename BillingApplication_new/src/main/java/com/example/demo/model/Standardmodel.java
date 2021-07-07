package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
//import com.example.demo.model.SectionStudents;


@Document(collection = "standard")

public class Standardmodel {
	
	private int classid;
	private String className;
	private int no_of_students;
	private int no_of_sections;
	
	public List<SectionStudents> sectionstudents;
	
	
	
	public int getClassid() {
		return classid;
	}
	
	
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getNo_of_students() {
		return no_of_students;
	}
	public void setNo_of_students(int no_of_students) {
		this.no_of_students = no_of_students;
	}
	public int getNo_of_sections() {
		return no_of_sections;
	}
	public void setNo_of_sections(int no_of_sections) {
		this.no_of_sections = no_of_sections;
	}
	public List<SectionStudents> getSectionstudents() {
		return sectionstudents;
	}
	public void setSectionstudents(List<SectionStudents> sectionstudents) {
		this.sectionstudents = sectionstudents;
	}
	
	
}
