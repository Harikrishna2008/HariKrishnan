package com.example.demo.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

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
		System.out.println("Fees SStructure for " + insertedEntity.getClassid() + " added into the database.");
		return "Fees Structure for " + insertedEntity.getClassid() + " added into the database.";
	}

	public String updateFeesStructure(FeesStructure feesstructure) {

		FeesStructure updateFeesstructure = mongoTemplate.findById(feesstructure,);
		
		
		if (updateFeesstructure != null) {

			updateFeesstructure.setYear(feesstructure.getYear());
			updateFeesstructure.setClassid(feesstructure.getClassid());
			updateFeesstructure.setFeesComponents(feesstructure.getFeesComponents());
			updateFeesstructure.setFrozenIndicator(feesstructure.getFrozenIndicator());

			//updateFeesstructure = modelMapper.map(updateFeesstructure, FeesStructure.class);
		}

		mongoTemplate.save(updateFeesstructure);
		System.out.println("ClassId " + feesstructure.getClassid() + " details updated in the database.");
		return "ClassId " + feesstructure.getClassid() + " details updated in the database.";
	}

}
