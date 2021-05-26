package com.example.demo.service;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clone;
import com.example.demo.model.FeesStructure;

@Service
public class FeeStructureServices {

	private MongoTemplate mongoTemplate;

	public FeeStructureServices(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am FeeStructure Service class");
		this.mongoTemplate = mongoTemplate;
	}

	public String addFeesstructure(FeesStructure feesstructure) {
		System.out.println("feestructure" + feesstructure.getFeesComponents());
		FeesStructure insertedEntity = mongoTemplate.insert(feesstructure);
		System.out.println("Fees Structure for " + insertedEntity.getClassid() + " added into the database.");
		return "Fees Structure for " + insertedEntity.getClassid() + " added into the database.";
	}
	
	public String cloneFeesstructure (Clone clone)
	{
		Query q= new Query();
		 q.addCriteria(Criteria.where("year").is(clone.getFromyear()));
		 q.addCriteria(Criteria.where("classid").is(clone.getFromclassid()));
         FeesStructure	update =  mongoTemplate.findOne(q, FeesStructure.class);
         update.setYear(clone.getToyear());
         update.setClassid(clone.getToclassid());
		 mongoTemplate.save(update);
         System.out.println("Clone Fees structure for " + clone.getFromclassid() + "added into the database.");
		 return "clone Feesstructure created sucessfully";
	}

	
	
	public String updateFeesStructure(FeesStructure feesstructure) {
		   Query q=new Query();
		   q.addCriteria(Criteria.where("year").is(feesstructure.getYear()));
		   q.addCriteria(Criteria.where("classid").is(feesstructure.getClassid()));
		   
		  mongoTemplate.findAndReplace(q, feesstructure );
		  //mongoTemplate.update(FeesStructure.class);
		   
		System.out.println("ClassId " + feesstructure.getClassid() + " details updated in the database.");
		return "ClassId " + feesstructure.getClassid() + " details updated in the database.";
	}

}
