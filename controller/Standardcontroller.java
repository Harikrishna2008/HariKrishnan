package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Standardmodel;
import com.example.demo.service.Standardservice;


@RequestMapping("/api/v1")
@RestController
public class Standardcontroller {

	private Standardservice standardService;
	
	 public Standardcontroller( Standardservice standardService ) {
         System.out.println("Hey i got an Standard Service object");
         this. standardService = standardService;
     }
	 

     @PostMapping("/standard")
     public String createstandard(@RequestBody Standardmodel standard) {
     	    System.out.println("CreateStudent");
             return standardService.addstandard(standard); 
     }
     
     @PutMapping("/standard")
     public String modifystandard(@RequestBody Standardmodel standard)
     {
    	 System.out.println("Updatestandard");
    	 return standardService.updateStandard(standard);
     }
}
