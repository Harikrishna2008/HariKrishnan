package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Standardmodel;


@Service
public class Standardservice {
	
	private MongoTemplate mongoTemplate;

    @Autowired
    public Standardservice(MongoTemplate mongoTemplate) {
            System.out.println("Hey i am Student Service class");
            this.mongoTemplate = mongoTemplate;
    }
    
    public String addstandard(Standardmodel standard) {
        Standardmodel insertedEntity = mongoTemplate.insert(standard);
        System.out.println("standard "+ insertedEntity.getClassName()+" added into the database.");
        return "Standard "+ insertedEntity.getClassName()+" added into the database.";
}
 
    public String updateStandard(Standardmodel standard ) {
        mongoTemplate.save(standard);
        System.out.println("Standard "+ standard.getClassName()+" details updated in the database.");
        return "standard "+ standard.getClassName()+" details updated in the database.";
}

}
