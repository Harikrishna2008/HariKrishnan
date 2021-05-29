package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fees;
import com.example.demo.model.Studentmodel;
import com.example.demo.service.FeesService;

@RequestMapping("/api/v1")
@RestController
public class FeesController {

	private FeesService feesservice;

	public FeesController(FeesService feesservice) {
		System.out.println("Hey i got an fees object");
		this.feesservice = feesservice;
	}
	
	/*
	 * Passing all field values to addFees function
	 */
	  @PostMapping ("/Fees")
      public String Createfees (@RequestBody Fees fees)
      {
    	  System.out.println("Create fees" );
    	  return feesservice.addFees(fees);
      }
      
	  /*
	   * While FeesPaid that respective student fees record updated with some business logics 
	   */
	  @PutMapping ("/Feesrecord")
	  public String updatefees(@RequestBody Fees fees) throws Exception
	  {
		  System.out.println("Update fees");
    	  return feesservice.updateFees(fees);
	  }
	  
	  /*
	   * updating latePayemtfees  of student
	   */
	  @PutMapping ("/Fees/{studentID}")
	  public String updatlatePayment(@RequestBody Map<String,Object> search)
	  {
		  System.out.println("update LatePaymentFee");
    	 return feesservice.updatelatePaymentfees(search);
	  }
	  
	  /*
	   * Get fees details about particular student
	   */
	  @GetMapping("/Fees")
      public Fees getStudentFees(@RequestBody Map<String,Object> search){
     
              return feesservice.getstudent(search);
      }
	  
	  
      /*
       * feesstatus about particular student passing with the help of student id  
       */
      @GetMapping("/Fees/{studentID}")
      public String getFeesStatus(@PathVariable("studentID") int studentID){
      	System.out.println("get fees status By studentID");
              return feesservice.getStatus(studentID);
      }
}
