package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "balance")

public class Balance {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private int id;

	private LocalDate day;
	private double openBalance;
	private double liveBalance;
	private double closeBalance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public double getOpenBalance() {
		return openBalance;
	}
	public void setOpenBalance(double openBalance) {
		this.openBalance = openBalance;
	}
	public double getLiveBalance() {
		return liveBalance;
	}
	public void setLiveBalance(double liveBalance) {
		this.liveBalance = liveBalance;
	}
	public double getCloseBalance() {
		return closeBalance;
	}
	public void setCloseBalance(double closeBalance) {
		this.closeBalance = closeBalance;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	

}
