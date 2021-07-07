package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ExpenseTypes")

public class ExpenseType {
	
	private String expenseType;
	private String description;
	private String trnAllowed;
	
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrnAllowed() {
		return trnAllowed;
	}
	public void setTrnAllowed(String trnAllowed) {
		this.trnAllowed = trnAllowed;
	}
	
	
		
}
