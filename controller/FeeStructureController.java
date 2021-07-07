package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Clone;
import com.example.demo.model.FeesStructure;
import com.example.demo.service.FeesStructureServices;

@RequestMapping("/api/v1")
@RestController
public class FeeStructureController {
	
	  private FeesStructureServices feestructureservices;

      public FeeStructureController (FeesStructureServices feestructureservices) {
              System.out.println("Hey i got an feesStructure Service object");
              this.feestructureservices = feestructureservices;
      }
      
      /*
       *  it is a Method to create fees Structure  
       * Here addFeesstructure function is called and feesstructure object passed
       */
      @PostMapping ("/FeeStructure")
      public String Createfeesstructure (@RequestBody FeesStructure feesstructure )
      {
    	  System.out.println("Create feesstructure" + feesstructure.getFeesComponents().length);
    	  return feestructureservices.addFeesstructure(feesstructure);
      }
      
      /*
       * Method to Clone a fees structure with match year and classid
       */
      @PostMapping ("/FeesStructure/Clone")
      public String Clonemethod (@RequestBody Clone clone)
      {
    	  System.out.println("Clone Feesstructure");
    	  return feestructureservices.cloneFeesstructure(clone);
      }
      
      
      @PutMapping ("/FeeStructure")
      public String updatefeesstructure (@RequestBody FeesStructure feesstructure )
      {
    	  System.out.println("Update Feesstructure");
    	  return feestructureservices.updateFeesStructure(feesstructure);
      }
      
     

}
