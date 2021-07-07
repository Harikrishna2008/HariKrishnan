package com.example.demo.model;

import java.time.LocalDate;

public class FeesPaid {
	
	private String transaction_Id;
	private LocalDate day;
	private double amount;
	
	
	public String getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(String transaction_Id) {
		this.transaction_Id = transaction_Id;
	}
	public LocalDate getDate() {
		return day;
	
	}
	public void setDate(LocalDate day) {
		this.day = day;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	
	

}
