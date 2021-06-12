package com.example.demo.model;

import com.example.demo.impl.StatusConstants;

public class TermDue {
	
	private int term_No;
	private double termDue;
    private double termPaid;
    private double termpending;
    private int termStatus;
    
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
	
	public void updateTermPending(double amount) throws Exception
	{
		if(this.termpending-amount<0)
		{
			throw new Exception("OverPaid");
		}else {
			System.out.println("TermPending updated");
			this.termpending-=amount;
		}
	}
	
	public void updateTermPaid(double amount) throws Exception
	{
		if(this.termPaid+amount>this.termDue)
		{
			throw new Exception("OverPaid");
		}else {
			System.out.println("TermPaid updated");

			this.termpending+=amount;
		}
	}
	
	public void updateStatus(double amount)throws Exception
	{
		try {
			updateTermPending(amount);
			updateTermPaid(amount);
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
	}
    
    
    	
}
