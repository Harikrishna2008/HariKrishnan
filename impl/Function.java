package com.example.demo.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Function  {

	public static String createdate1 () {
		 /* Auto set of Current system date*/
		Date dNow = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String date = day.format(dNow);
		return date;
	}
	 
	public static String createTransactionid1()
	{
		/* Creating Uniqe Tr_Id Using currentDateTime */	
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        String temp = "T"+datetime;
        return temp;
        
	}
}
