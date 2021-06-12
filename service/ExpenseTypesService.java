package com.example.demo.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExpenseType;

@Service
public class ExpenseTypesService {
	
	private static MongoTemplate mongoTemplate;

	public ExpenseTypesService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am ExpenseType Service class");
		ExpenseTypesService.mongoTemplate=mongoTemplate;
	}
	


	public String addExpenseType(ExpenseType expenseType) {
	  mongoTemplate.insert(expenseType);
		System.out.println("ExpenseType added into the database.");
		return "ExpenseType added into the database.";
	}



	public List<ExpenseType> getallExpenseType() {
		System.out.println("Show All ExpenseType ");
		return mongoTemplate.findAll(ExpenseType.class);
	}

	

}
