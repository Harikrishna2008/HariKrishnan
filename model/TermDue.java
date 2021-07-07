package com.example.demo.model;

import java.time.LocalDate;

import com.example.demo.impl.StatusConstants;

public class TermDue {
	
	private int term_No;
	private double termDue;
    private double termPaid;
    private double termpending;
    private int termStatus;
    private LocalDate dueDate;
    
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public int getTerm_No() {
		return term_No;
	}
	public void setTerm_No(int term_No) {
		this.term_No = term_No;
	}
	public double getTermDue() {
		return termDue;
	}
	public void setTermDue(double termDue) {
		this.termDue = termDue;
	}
	public double getTermPaid() {
		return termPaid;
	}
	public void setTermPaid(double termPaid) {
		this.termPaid = termPaid;
	}
	public double getTermpending() {
		return termpending;
	}
	public void setTermpending(double termpending) {
		this.termpending = termpending;
	}
	public int getTermStatus() {
		return termStatus;
	}
	public void setTermStatus(int termStatus) {
		this.termStatus = termStatus;
	}
	
	public double updateTermPending(double amount) throws Exception
	{
		if(this.termpending-amount<0&&this.termStatus==StatusConstants.COMPLETED.getCode())
		{
			//throw new Exception("OverPaid");
			return amount;
			
		}else {
			System.out.println("TermPending updated");
			if(this.termpending-amount<0)
			{
				double balance= (-(this.termpending-amount));
				this.termpending=0;
				return balance;
			}
			this.termpending-=amount;
			System.out.println(this.termpending);
			return 0;
		}
	}
	
	public void updateTermPaid(double amount) throws Exception
	{
		if(this.termPaid+amount>this.termDue&&this.termStatus==StatusConstants.COMPLETED.getCode())

		{
			//throw new Exception("OverPaid");
			
		}else {                        
			System.out.println("TermPaid updated");
			if(this.termPaid+amount<=this.termDue)
			{
				this.termPaid+=amount;
			}
			else
			{
				this.termPaid+=this.termpending;

			}

			System.out.println(this.termPaid);
		}
	}
	
	public double updateStatus(double amount)throws Exception
	{
		double balanceAmount;
		try {
			
			updateTermPaid(amount);
			balanceAmount=updateTermPending(amount);
			if(this.termDue-this.termPaid>0) {
				this.termStatus=StatusConstants.PENDING.getCode();
			}else {
				this.termStatus=StatusConstants.COMPLETED.getCode();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return balanceAmount;
	}
    
    
    	
}
