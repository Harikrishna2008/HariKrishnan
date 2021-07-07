package com.example.demo.service;



import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Balance;
import com.example.demo.model.Expense;
import com.example.demo.model.Fees;
import com.example.demo.util.ExpenseUtil;

@Service
public class ExpenseService {
	
	private MongoTemplate mongoTemplate;

	public ExpenseService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am Expense Service class");
		this.mongoTemplate = mongoTemplate;
	}
	
	public String addExpense(Expense expense) throws Exception {
		ExpenseUtil.createexpense(expense);
		Expense insertedEntity = mongoTemplate.insert(expense);
		System.out.println(expense.getDate());
		System.out.println("Expense " + insertedEntity.getExpenseType() + " added into the database.");
		
		if(expense.getExpenseType().equals("fees"))
		{
		Fees updatefeereq = ExpenseUtil.createobj(expense);
		FeesService.updateFees(updatefeereq);
		}
		
		return "Expense " + insertedEntity.getExpenseType() + " added into the database.";
	}
	

}
