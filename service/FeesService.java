package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fees;
import com.example.demo.model.FeesPaid;
import com.example.demo.repository.FeesRepository;
import com.example.demo.util.FeesUtil;

@Service
public class FeesService {

	private MongoTemplate mongoTemplate;

	public FeesService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am Fees Service class");
		this.mongoTemplate = mongoTemplate;
	}

	@Autowired
	private FeesRepository feesRepository;

	/*
	 * In fees collection inserted new document with all field and values
	 */
	public String addFees(Fees fees) {
		Fees insertedEntity = mongoTemplate.insert(fees);
		System.out.println("Fees for " + insertedEntity.getStudentID() + " added into the database.");
		return "Fees for " + insertedEntity.getStudentID() + " added into the database.";
	}

	/*
	 * While FeesPaid Student that document to be updated
	 * Business logics all applied in  FeesUtil
	 */

	public String updateFees(Fees fees) throws Exception {
		try {
			Query q = new Query();
			q.addCriteria(Criteria.where("studentID").is(fees.getStudentID()));
			Fees update = mongoTemplate.findOne(q, Fees.class);
			ArrayList<FeesPaid> updatedfesspaid = new ArrayList<>();
			Arrays.stream(update.getFeesPaid()).forEach((value) -> updatedfesspaid.add(value));
			Arrays.stream(fees.getFeesPaid()).forEach((value) -> updatedfesspaid.add(value));
			Object[] list = updatedfesspaid.toArray();
			FeesPaid[] temp = new FeesPaid[list.length];
			for (int i = 0; i < list.length; i++) {
				temp[i] = (FeesPaid) list[i];
			}
			update.setFeesPaid(temp);
			FeesUtil.recalculate(update);
			mongoTemplate.findAndReplace(q, update);
			System.out.println("StudentID " + fees.getStudentID() + " details updated in the database.");
			return "StudentID " + fees.getStudentID() + " details updated in the database.";

		} catch (Exception e) {

			throw new Exception(e);
		}
	}

	/*
	 * Querying a document with both year and studentID
	 * Updating a latePaymentFees field only in that document
	 */
	public String updatelatePaymentfees(Map<String, Object> search) {
		Query q = new Query();
		q.addCriteria(Criteria.where("year").is(search.get("year")));
		q.addCriteria(Criteria.where("studentID").is(search.get("StudentID")));
		Fees update = mongoTemplate.findOne(q, Fees.class);
		update.setLatePaymentFee((int) search.get("latePaymentfee"));
		mongoTemplate.findAndReplace(q, update);
		// mongoTemplate.updateFirst(q, update, Fees.class);
		return "StudentID " + search.get("StudentID") + " details updated in the database.";
	}

	/*
	 * getting a fees details about a student from fees collection
	 */
	public Fees getstudent(Map<String, Object> search) {
		Query q = new Query();
		q.addCriteria(Criteria.where("year").is(search.get("year")));
		q.addCriteria(Criteria.where("studentID").is(search.get("studentID")));
		System.out.println("getstudentFees");
		return mongoTemplate.findOne(q, Fees.class);

	}

	/*
	 * First query a particular student document and return Feespayemntstatus
	 */
	public String getStatus(int studentID) {
		Query q = new Query();
		q.addCriteria(Criteria.where("studentID").is(studentID));
		System.out.println("getFeesStatus");
		Fees fees = mongoTemplate.findOne(q, Fees.class);
		return fees.getFeesPaymentStatus();
	}

}
