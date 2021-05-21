package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sectionstudent")

public class SectionStudents {
	
	private String sectionname;
	private int noofstudents;
	
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public int getNoofstudents() {
		return noofstudents;
	}
	public void setNoofstudents(int noofstudents) {
		this.noofstudents = noofstudents;
	}
	
	

}
