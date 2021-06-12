package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.impl.StatusConstants;
import com.example.demo.model.Fees;
import com.example.demo.model.FeesPaid;
import com.example.demo.model.TermDue;

public class FeesUtil {
	
	public static void recalcaculate(Fees update)
	{
		
		FeesPaid[] feesamounts = update.getFeesPaid();
		int total = 0; 
		for(FeesPaid feesamount : feesamounts )
		{
			total+=feesamount.getAmount();
			
		}
		update.setFeesTotalPaid(total);
		
		update.setTotalFeesPending(update.getFeesDue()-total);
		
		if(update.getTotalFeesPending()<=0)
		{
			update.setFeesPaymentStatus("Completed");
		}
		else if(update.getFeesTotalPaid() >= (update.getFeesDue())/2)
		{
			update.setFeesPaymentStatus("Partial");
		}
		else
		{
			update.setFeesPaymentStatus("Pending");
		}
		}

	public static void termcaculate(Fees update) throws Exception {
	
		FeesPaid[] value = update.getFeesPaid();
		FeesPaid lastPaid=value[value.length-1];
		double amount = lastPaid.getAmount();
		
		TermDue[] i = update.getTermDue();
		for(TermDue termDue:i)
		{
			if(termDue.getTermStatus()==StatusConstants.COMPLETED.getCode())  // add and for overdue
			{
				System.out.println("Term Action");
				continue;
			}
			termDue.updateStatus(amount);
		}
	}
	
}
  