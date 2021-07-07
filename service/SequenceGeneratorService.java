package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations; 
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.model.Balance;
import com.example.demo.model.dbSequence;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public int getSequenceNumber(String sequenceName) {
		// get sequence no
		Query query = new Query(Criteria.where("_id").is(sequenceName));
		System.out.println(query);
		// update the sequence no
		Update update = new Update().inc("seq", 1);
		System.out.println(update);
		// modify in document
		dbSequence counter = mongoOperations.findAndModify(query, update,dbSequence.class);
		System.out.println(counter.getId());
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
	
	public Balance getdocument(String sequenceName)
	{
		        // get sequence no
				Query query = new Query(Criteria.where("_id").is(sequenceName));
				dbSequence counter= mongoOperations.findOne(query,dbSequence.class);
				int seqno=counter.getSeq();
			    
				Query q = new Query(Criteria.where("_id").is(seqno-1));
				Balance olddocument=mongoOperations.findOne(q, Balance.class);
				
				Balance newdocument = new Balance();
				newdocument.setOpenBalance(olddocument.getCloseBalance());
                
				return newdocument;	

	}

}
