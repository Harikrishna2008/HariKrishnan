package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teachermodel;

@Service
public class Teacherservice{

        private MongoTemplate mongoTemplate;

        @Autowired
        public Teacherservice(MongoTemplate mongoTemplate) {
                System.out.println("Hey i am Teacher Service class");
                this.mongoTemplate = mongoTemplate;
        }

        public String addTeacher(Teachermodel teacher) {
        	Teachermodel insertedEntity = mongoTemplate.insert(teacher);
                System.out.println("Teacher "+ insertedEntity.getFirstName()+" added into the database.");
                return "Teacher"+ insertedEntity.getFirstName()+" added into the database.";
        }

        public List<Teachermodel> getAllTeachers() {
        	System.out.println("getAllTeachers");
                return mongoTemplate.findAll(Teachermodel.class);
        }

        public Teachermodel getTeacher(int RollNumber) {
                Query q=new Query();
                q.addCriteria(Criteria.where("RollNumber").is(RollNumber));
                System.out.println("getTeacher");
                return mongoTemplate.findOne(q, Teachermodel.class);
        }

        public String updateTeacher(Teachermodel teacher) {
                mongoTemplate.save(teacher);
                System.out.println("Teacher "+ teacher.getFirstName()+" details updated in the database.");
                return "Teacher "+ teacher.getFirstName()+" details updated in the database.";
        }

        public String deleteTeacher(int RollNumber) {
                Query q=new Query();
                q.addCriteria(Criteria.where("RollNumber").is(RollNumber));
                Teachermodel teacher=mongoTemplate.findAndRemove(q, Teachermodel.class);
                System.out.println("Teacher "+ teacher.getRollNumber()+" removed from database.");
                return "Teacher "+ teacher.getRollNumber()+" removed from database.";
        }
}