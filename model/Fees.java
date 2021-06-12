package com.example.demo.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fees")
public class Fees {
	
	private int year;
    private int admissionId;
    private int studentID;
    private int no_of_terms;
    private int feesDue;    
    private TermDue[] termDue;  //  Fields:mmternNo and amount termpayment termstatus    
    private FeesPaid [] feesPaid;  // Fields : transaction_Id,amount,date
    private int feesTotalPaid;
    private String feesPaymentStatus;
    private int latePaymentFee;
    private String newAdmissionInd ;
    private int totalFeesPending;
	
	public int getNo_of_terms() {
		return no_of_terms;
	}
	public void setNo_of_terms(int no_of_terms) {
		this.no_of_terms = no_of_terms;
	}
	public TermDue[] getTermDue() {
		return termDue;
	}
	public void setTermDue(TermDue[] termDue) {
		this.termDue = termDue;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getFeesDue() {
		return feesDue;
	}
	public void setFeesDue(int feesDue) {
		this.feesDue = feesDue;
	}
	public String getFeesPaymentStatus() {
		return feesPaymentStatus;
	}
	public void setFeesPaymentStatus(String feesPaymentStatus) {
		this.feesPaymentStatus = feesPaymentStatus;
	}
	public FeesPaid[] getFeesPaid() {
		return feesPaid;
	}
	public void setFeesPaid(FeesPaid[] feesPaid) {
		this.feesPaid = feesPaid;
	}
	public int getFeesTotalPaid() {
		return feesTotalPaid;
	}
	public void setFeesTotalPaid(int feesTotalPaid) {
		this.feesTotalPaid = feesTotalPaid;
	}
	public int getLatePaymentFee() {
		return latePaymentFee;
	}
	public void setLatePaymentFee(int latePaymentFee) {
		this.latePaymentFee = latePaymentFee;
	}
	public String getNewAdmissionInd() {
		return newAdmissionInd;
	}
	public void setNewAdmissionInd(String newAdmissionInd) {
		this.newAdmissionInd = newAdmissionInd;
	}
	
	public int getTotalFeesPending() {
		return totalFeesPending;
	}
	public void setTotalFeesPending(int totalFeesPending) {
		this.totalFeesPending = totalFeesPending;
	}
	@Override
	public String toString() {
		return "Fees [year=" + year + ", admissionId=" + admissionId + ", studentID=" + studentID + ", no_of_terms="
				+ no_of_terms + ", feesDue=" + feesDue + ", termDue=" + Arrays.toString(termDue)
				+ ", feesPaymentStatus=" + feesPaymentStatus + ", feesPaid=" + Arrays.toString(feesPaid)
				+ ", feesTotalPaid=" + feesTotalPaid + ", latePaymentFee=" + latePaymentFee + ", newAdmissionInd="
				+ newAdmissionInd + ", totalFeesPending=" + totalFeesPending + "]";
	}
	
	
    
}
