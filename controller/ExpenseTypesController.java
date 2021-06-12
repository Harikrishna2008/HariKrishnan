package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExpenseType;
import com.example.demo.service.ExpenseTypesService;


@RequestMapping("/api/v1")
@RestController
public class ExpenseTypesController {
	
	private ExpenseTypesService expenseTypeService;

	public ExpenseTypesController(ExpenseTypesService expenseTypeService) {
		System.out.println("Hey i got an expenseType object");
		this.expenseTypeService = expenseTypeService;
	}
	
	 @PostMapping ("/expensetype")
     public String CreateExpense (@RequestBody ExpenseType expenseType) throws Exception
     {
   	  System.out.println("Create Expense" );
   	  return expenseTypeService.addExpenseType(expenseType);
     }
	 
	 @GetMapping ("/expensetype")
	 public List<ExpenseType> getAllExpenseType()
	 {
		 return expenseTypeService.getallExpenseType();
	 }

}
