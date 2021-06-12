package com.example.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;


@RequestMapping("/api/v1")
@RestController
public class ExpenseController {
	
	private ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		System.out.println("Hey i got an expense object");
		this.expenseService = expenseService;
	}
	
	 @PostMapping ("/expense")
     public String CreateExpense (@RequestBody Expense expense) throws Exception
     {
   	  System.out.println("Create Expense" );
   	  return expenseService.addExpense(expense);
     }
	
	

}
