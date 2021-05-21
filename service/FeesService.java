package com.example.demo.service;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fees;

@Service
public class FeesService {

	private MongoTemplate mongoTemplate;

	public FeesService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am Fees Service class");
		this.mongoTemplate = mongoTemplate;
	}

	public String addFees(Fees fees) {
		//System.out.println("fees" + fees.getStudentID());
		Fees insertedEntity = mongoTemplate.insert(fees);
		System.out.println("Fees for " + insertedEntity.getStudentID() + " added into the database.");
		return "Fees for " + insertedEntity.getStudentID() + " added into the database.";
	}

	public String updateFees(Fees fees) {
		mongoTemplate.save(fees);
		System.out.println("StudentID " + fees.getStudentID() + " details updated in the database.");
		return "StudentID " + fees.getStudentID() + " details updated in the database.";
	}
	
	
	 public String getStatus(int studentID) {
         Query q=new Query();
         q.addCriteria(Criteria.where("studentID").is(studentID));
         System.out.println("getFeesStatus");
         Fees fees = mongoTemplate.findOne(q, Fees.class );
         return fees.getFeesPaymentStatus();
 }

	

}
