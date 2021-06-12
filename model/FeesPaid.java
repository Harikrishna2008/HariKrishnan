package com.example.demo.model;

public class FeesPaid {
	
	private String transaction_Id;
	private String date;
	private double amount;
	
	
	public String getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(String transaction_Id) {
		this.transaction_Id = transaction_Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	
	
	@Override
	public String toString() {
		return "FeesPaid [date=" + date + ", amount=" + amount + "]";
	}
	
	
	

}
