package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fees;
import com.example.demo.service.FeesService;

@RequestMapping("/api/v1")
@RestController
public class FeesController {

	private FeesService feesservice;

	public FeesController(FeesService feesservice) {
		System.out.println("Hey i got an fees object");
		this.feesservice = feesservice;
	}
	
	  @PostMapping ("/Fees")
      public String Createfees (@RequestBody Fees fees)
      {
    	  System.out.println("Create fees" );
    	  return feesservice.addFees(fees);
      }
      
     /*@PutMapping ("/Fees/{studentID}")
      public String updatefees (@PathVariable ("studentID") int studentID ,@RequestBody Fees fees )
      {
    	  System.out.println("Update fees");
    	  return feesservice.updateFees(studentID,fees);
      }*/
	  
	  @PutMapping ("/Fees")
	  public String updatefees(@RequestBody Fees fees)
	  {
		  System.out.println("Update fees");
    	  return feesservice.updateFees(fees);
	  }
	  
	  @PutMapping ("/Fees/{studentID}")
	  public String updatlatePayment(@RequestBody Fees fees)
	  {
		  System.out.println("update LatePaymentFee");
    	 return feesservice.updatelatePaymentfees(fees);
	  }
      
      @GetMapping("/Fees/{studentID}")
      public String getFeesStatus(@PathVariable("studentID") int studentID){
      	System.out.println("get fees status By studentID");
              return feesservice.getStatus(studentID);
      }
}
