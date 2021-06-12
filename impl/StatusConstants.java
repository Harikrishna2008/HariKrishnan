package com.example.demo.impl;

public enum StatusConstants {
	PENDING(0,"pending"),
	COMPLETED(1,"completed");
	
	private final int statusCode;
	private final String statusName;
	
	private StatusConstants(int statusCode,String statusName)
	{
		this.statusCode=statusCode;
		this.statusName=statusName;
	}
	
	public int getCode()
	{
		return this.statusCode;
	}
	
	public String getName()
	{
		return this.statusName;
	}
}
