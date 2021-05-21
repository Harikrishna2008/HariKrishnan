package com.example.demo.model;

public class FeesPaid {
	
	private String date;
	private int amount;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "FeesPaid [date=" + date + ", amount=" + amount + "]";
	}
	
	

}
