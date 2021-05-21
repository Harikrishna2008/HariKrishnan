package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

//import com.example.demo.feesmodel.FeesCompName;


@Document(collection = "feesstructure")
public class FeesStructure {
	
	private int year;
	private String classid;
	
	private FeesCompName [] feesComponents;   // Contains FeesCompName And Value
	
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

	public FeesCompName[] getFeesComponents() {
		return feesComponents;
	}

	public void setFeesComponents(FeesCompName[] feesComponents) {
		this.feesComponents = feesComponents;
	}

	public String getFrozenIndicator() {
		return frozenIndicator;
	}

	public void setFrozenIndicator(String frozenIndicator) {
		this.frozenIndicator = frozenIndicator;
	}

	

}
