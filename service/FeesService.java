package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fees;
import com.example.demo.repository.FeesRepository;

@Service
public class FeesService {

	private MongoTemplate mongoTemplate;

	public FeesService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am Fees Service class");
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private FeesRepository feesRepository;
	
	public String addFees(Fees fees) {
		// System.out.println("fees" + fees.getStudentID());
		Fees insertedEntity = mongoTemplate.insert(fees);
		System.out.println("Fees for " + insertedEntity.getStudentID() + " added into the database.");
		return "Fees for " + insertedEntity.getStudentID() + " added into the database.";
	}

	public String updateFees(Fees fees) {

		Query q = new Query();
		q.addCriteria(Criteria.where("studentID").is(fees.getStudentID()));
		Fees update = mongoTemplate.findOne(q,Fees.class);
		update.setTotalFeesPending((fees.getFeesDue())-(fees.getFeesTotalPaid()));
		mongoTemplate.findAndReplace(q,fees);
		System.out.println("StudentID " + fees.getStudentID() + " details updated in the database.");
		return "StudentID " + fees.getStudentID() + " details updated in the database.";

	}
	
	
	public String updatelatePaymentfees(Fees fees)
	{
		Query q = new Query();
		q.addCriteria(Criteria.where("studentID").is(fees.getStudentID()));
		Fees update=mongoTemplate.findOne(q,Fees.class);
		update.setLatePaymentFee(fees.getLatePaymentFee());
		mongoTemplate.findAndReplace(q,update);
		//mongoTemplate.updateFirst(q, update, Fees.class);
	    return "StudentID " + fees.getStudentID() + " details updated in the database.";
	}

	/*
	 * public String updateFees(Fees fees) { Fees updatedFees =
	 * feesRepository.getByStudentID(fees.getStudentID());
	 * 
	 * if (updatedFees != null) { updatedFees.setYear(fees.getYear());
	 * updatedFees.setAdmissionId(fees.getAdmissionId());
	 * updatedFees.setFeesDue(fees.getFeesDue());
	 * updatedFees.setFeesPaymentStatus(fees.getFeesPaymentStatus());
	 * updatedFees.setFeesPaid(fees.getFeesPaid());
	 * updatedFees.setFeesTotalPaid(fees.getFeesTotalPaid());
	 * updatedFees.setLatePaymentFee(fees.getLatePaymentFee());
	 * updatedFees.setNewAdmissionInd(fees.getNewAdmissionInd());
	 * 
	 * mongoTemplate.save(updatedFees);
	 * 
	 * // updatedFees = modelMapper.map(updatedFees, Fees.class); }
	 * System.out.println(updatedFees.getLatePaymentFee()); return "StudentID " +
	 * fees.getStudentID() + " details updated in the database."; }
	 */

	public String getStatus(int studentID) {
		Query q = new Query();
		q.addCriteria(Criteria.where("studentID").is(studentID));
		System.out.println("getFeesStatus");
		Fees fees = mongoTemplate.findOne(q, Fees.class);
		return fees.getFeesPaymentStatus();
	}

}
