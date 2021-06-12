package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "expense")
public class Expense {
	
    private String transaction_Id;
	private String date;
	private int year;
	private int studentID;
	private String expenseType;
	private double amount;
	private String person;
	private String tranType;
	

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(String temp) {
		this.transaction_Id = temp;
	}
	public String getDate() {
		return date;
	}
	public Expense setDate(String date) {
		this.date = date;
		return null;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
	this.tranType = tranType;
	}
		
	}
	
	

