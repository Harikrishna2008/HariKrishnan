package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDate;

public class TermDetails {

	
	private int term_No;
	private double amount;
	private LocalDate dueDate; // Format : yyyy-mm-dd
	
	
	public int getTerm_No() {
		return term_No;
	}
	public void setTerm_No(int term_No) {
		this.term_No = term_No;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	
	
	
}
