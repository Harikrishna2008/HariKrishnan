package com.example.demo.controller;

//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FeesStructure;
import com.example.demo.service.FeeStructureServices;

@RequestMapping("/api/v1")
@RestController
public class FeeStructureController {
	
	  private FeeStructureServices feestructureservices;

      public FeeStructureController (FeeStructureServices feestructureservices) {
              System.out.println("Hey i got an feesStructure Service object");
              this.feestructureservices = feestructureservices;
      }
      
      @PostMapping ("/FeeStructure")
      public String Createfeesstructure (@RequestBody FeesStructure feesstructure )
      {
    	  System.out.println("Create feesstruce" + feesstructure.getFeesComponents().length);
    	  return feestructureservices.addFeesstructure(feesstructure);
      }
      
      @PutMapping ("/FeeStructure")
      public String updatefeesstructure (@RequestBody FeesStructure feesstructure )
      {
    	  System.out.println("Update feesstructure");
    	  return feestructureservices.updateFeesStructure(feesstructure);
      }
      
     

}
