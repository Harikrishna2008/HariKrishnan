package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.FeesComp;

@Service
public class FeescompService {
	
private MongoTemplate mongoTemplate;
	
	@Autowired
    public FeescompService ( MongoTemplate mongoTemplate) {
            System.out.println("Hey i am FeeStructure Service class");
            this.mongoTemplate = mongoTemplate;
    }
	
	public String addFeesComp(FeesComp feescomp)
	{
		 FeesComp insertedEntity = mongoTemplate.insert(feescomp);
         System.out.println("FeesComp for "+ insertedEntity.getCompName()+ " added into the database.");
         return "FeesComp for "+ insertedEntity.getCompName()+" added into the database.";

	}
	
	public String updateFeesComp( FeesComp feescomp )
	{
		// Query q=new Query();
        //q.addCriteria(Criteria.where("compName").is(compName));
		  mongoTemplate.save(feescomp);
          System.out.println("FeesComp "+ feescomp.getCompName()+" details updated in the database.");
          return "FeesComp "+ feescomp.getCompName()+" details updated in the database.";
		
	}

}
