package com.example.demo.util;

import com.example.demo.model.Fees;
import com.example.demo.model.FeesPaid;

public class FeesUtil {
	
	public static void recalculate(Fees update)
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
	


}
