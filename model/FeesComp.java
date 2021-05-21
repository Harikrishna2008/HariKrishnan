package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feescomponents")
public class FeesComp {

	private String compName;
	private double value;
	private double defaultvalue;
	private String supressedIndicator;
	
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(double defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public String getSupressedIndicator() {
		return supressedIndicator;
	}
	public void setSupressedIndicator(String supressedIndicator) {
		this.supressedIndicator = supressedIndicator;
	}
	
		
	
}
