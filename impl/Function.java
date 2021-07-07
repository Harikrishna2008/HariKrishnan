package com.example.demo.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class Function  {

	public static LocalDate createdate1 () {
		 /* Auto set of Current system date*/
		LocalDate currentDate = LocalDate.now();
        return currentDate;
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
