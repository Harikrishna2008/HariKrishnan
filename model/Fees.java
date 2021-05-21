package com.example.demo.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fees")
public class Fees {
	
	private int year;
    private int admissionId;
    private int studentID;
    private int feesDue;       
    private String feesPaymentStatus;
    private FeesPaid [] feesPaid; 
    private int feesTotalPaid;
    private int latePaymentFee;
    private String newAdmissionInd ;
    
    
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
	
	
	
	@Override
	public String toString() {
		return "Fees [year=" + year + ", admissionId=" + admissionId + ", studentID=" + studentID + ", feesDue="
				+ feesDue + ", feesPaymentStatus=" + feesPaymentStatus + ", feesPaid=" + Arrays.toString(feesPaid)
				+ ", feesTotalPaid=" + feesTotalPaid + ", latePaymentFee=" + latePaymentFee + ", newAdmissionInd="
				+ newAdmissionInd + ", getYear()=" + getYear() + ", getAdmissionId()=" + getAdmissionId()
				+ ", getStudentID()=" + getStudentID() + ", getFeesDue()=" + getFeesDue() + ", getFeesPaymentStatus()="
				+ getFeesPaymentStatus() + ", getFeesPaid()=" + Arrays.toString(getFeesPaid()) + ", getFeesTotalPaid()="
				+ getFeesTotalPaid() + ", getLatePaymentFee()=" + getLatePaymentFee() + ", getNewAdmissionInd()="
				+ getNewAdmissionInd() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
    
	
	

}
