package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Fees;

public interface FeesRepository extends MongoRepository< Fees, String>{

	public Fees getByStudentID(int StudentID);
}
