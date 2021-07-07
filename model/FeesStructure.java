package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "feesstructure")
public class FeesStructure {
	private int year;
	private String classid;
	@Autowired
	private FeesComponents [] feesComponents;   // Contains FeesCompName And Value
	@Autowired
    private TermDetails [] termDetails;         // term_No , amount , duedate
	private String frozenIndicator;
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public FeesComponents[] getFeesComponents() {
		return feesComponents;
	}

	public void setFeesComponents(FeesComponents[] feesComponents) {
		this.feesComponents = feesComponents;
	}

	public String getFrozenIndicator() {
		return frozenIndicator;
	}

	public void setFrozenIndicator(String frozenIndicator) {
		this.frozenIndicator = frozenIndicator;
	}

	public TermDetails [] getTermdetails() {
		return termDetails;
	}

	public void setTermdetails(TermDetails [] termdetails) {
		this.termDetails = termdetails;
	}

	public TermDetails [] getTermDetails() {
		return termDetails;
	}

	public void setTermDetails(TermDetails [] termDetails) {
		this.termDetails = termDetails;
	}

	

}
