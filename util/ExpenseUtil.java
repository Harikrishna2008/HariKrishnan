package com.example.demo.util;


import com.example.demo.impl.Function;
import com.example.demo.model.Expense;
import com.example.demo.model.Fees;
import com.example.demo.model.FeesPaid;

public abstract class ExpenseUtil {
	
	public static void createexpense(Expense expense)
	{
	   
		expense.setTransaction_Id(Function.createTransactionid1());
        expense.setDate(Function.createdate1()); 
        expense.setYear(expense.getYear());
        expense.setStudentID(expense.getStudentID());
        expense.setAmount(expense.getAmount());
        expense.setExpenseType(expense.getExpenseType());
        expense.setPerson(expense.getPerson());
        expense.setTranType(expense.getTranType());
 
	}
	
	
	public static Fees createobj(Expense expense) {
		System.out.println("create new Fees Object ");
		Fees newobj = new Fees();
		newobj.setYear(expense.getYear());
		newobj.setStudentID(expense.getStudentID());
		FeesPaid paid=new FeesPaid();
	    paid.setTransaction_Id(expense.getTransaction_Id());
		paid.setDate(Function.createdate1());
		paid.setAmount(expense.getAmount());
		newobj.setFeesPaid(new FeesPaid[]{paid});
	
		return newobj;
	}


	/*ExpenseUtil.updateexpense(updatefeereq);

	public static String updateexpense(Map<String, Object> updatefeereq)
	{
	 
		Expense ex = new  Expense();
		// Creating Uniqe Tr_Id Using currentDateTime 	
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        System.out.println(datetime);
        String uid = "T"+datetime;
        ex.setTransaction_Id(uid);
        
        //  Auto set of Current system date
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        String date=day.format(dNow);
        ex.setDate(date); 
        ex.setExpenseType(String.valueOf(updatefeereq.get("expenseType")));
        ex.setAmount(Double.parseDouble((String) updatefeereq.get("amount")));
        ex.setPerson(String.valueOf(updatefeereq.get("person")));
        ex.setTranType(String.valueOf(updatefeereq.get("tranType")));
        mongoTemplate.insert(ex);
        System.out.println("Sucess");
      
        
        return uid;
        
        
	}*/
}
