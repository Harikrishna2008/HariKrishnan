package com.example.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Balance;
import com.example.demo.service.BalanceService;

@RequestMapping("/api/v1")
@RestController
public class BalanceController {
	
	private BalanceService balanceService;
	
	public BalanceController(BalanceService balanceService)
	{
		System.out.println("Hey i got an balance object");
		this.balanceService=balanceService;
	}

	
	 @PostMapping ("/balance")
     public String AddBalanceDoc (@RequestBody Balance balance) throws Exception
     {
   	  System.out.println("Create Balance Document" );
   	  return balanceService.createBalanceDoc(balance);
     }
	 
	 @PutMapping("/balance/credit")
	 public String Updatecreditbalance(@RequestBody Balance balance)
	 {
		 System.out.println("Balance document updated");
		 return balanceService.updateAddBalanceDoc(balance);
	 }
	 
	 @PutMapping("/balance/debit")
	 public String Updatebebitbalance(@RequestBody Balance balance)
	 {
		 System.out.println("Balance document updated");
		 return balanceService.updateSubBalanceDoc(balance);
	 }
	 
	
}
