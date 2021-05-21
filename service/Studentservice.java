package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Studentmodel;

@Service
public class Studentservice{

        private MongoTemplate mongoTemplate;

        @Autowired
        public Studentservice(MongoTemplate mongoTemplate) {
                System.out.println("Hey i am Student Service class");
                this.mongoTemplate = mongoTemplate;
        }

        public String addStudent(Studentmodel student) {
        	Studentmodel insertedEntity = mongoTemplate.insert(student);
                System.out.println("Student "+ insertedEntity.getFirstName()+" added into the database.");
                return "Student"+ insertedEntity.getFirstName()+" added into the database.";
        }

        public List<Studentmodel> getAllStudents() {
        	System.out.println("getAllStudents");
                return mongoTemplate.findAll(Studentmodel.class);
        }

        public Studentmodel getStudent(int RollNumber) {
                Query q=new Query();
                q.addCriteria(Criteria.where("RollNumber").is(RollNumber));
                System.out.println("getStudent");
                return mongoTemplate.findOne(q, Studentmodel.class);
        }

        public String updateStudent(Studentmodel student) {
                mongoTemplate.save(student);
                System.out.println("Student "+ student.getFirstName()+" details updated in the database.");
                return "Student "+ student.getFirstName()+" details updated in the database.";
        }

        public String deleteStudent(int RollNumber) {
                Query q=new Query();
                q.addCriteria(Criteria.where("RollNumber").is(RollNumber));
                Studentmodel student=mongoTemplate.findAndRemove(q, Studentmodel.class);
                System.out.println("Student "+ student.getRollNumber()+" removed from database.");
                return "Student "+ student.getRollNumber()+" removed from database.";
        }
}