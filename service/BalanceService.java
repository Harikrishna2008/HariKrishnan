package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Balance;

@Service
public class BalanceService {
	
	private MongoTemplate mongoTemplate;

	public BalanceService(MongoTemplate mongoTemplate) {
		System.out.println("Hey i am Balance Service class");
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private SequenceGeneratorService service;
	
	public String createBalanceDoc(Balance balance)
	{
	
		balance.setId(service.getSequenceNumber(Balance.SEQUENCE_NAME));
        balance.setCloseBalance(balance.getLiveBalance());
		mongoTemplate.insert(balance);
		System.out.println("Balance Document Created");
		return "Balance Document Created";
		
	}
	
	
	
	public  String updateAddBalanceDoc(Balance balance  )
	{
		Query q = new Query();
		q.addCriteria(Criteria.where("day").is(balance.getDay()));
		
		Balance document = mongoTemplate.findOne(q, Balance.class);
		
		if(document!=null) {
			document.setLiveBalance(document.getLiveBalance()+balance.getLiveBalance());
			document.setCloseBalance(document.getLiveBalance());
			mongoTemplate.findAndReplace(q, document);
	        System.out.println("amount added to livebalance and document updated");
		}
		
		else
		{
			Balance balance1 = service.getdocument(Balance.SEQUENCE_NAME);
			balance1.setLiveBalance(balance1.getOpenBalance()+balance.getLiveBalance());
			balance1.setDay(balance.getDay());
			createBalanceDoc(balance1);
			System.out.println("New balance document created with updated liveBalance");
		 }
        
		return "amount added to livebalance and document updated";
 
	}
	

	public String updateSubBalanceDoc(Balance balance  )
	{
		Query q = new Query();
		q.addCriteria(Criteria.where("day").is(balance.getDay()));
		
		Balance document = mongoTemplate.findOne(q, Balance.class);
		
		if(document!=null) {
			document.setLiveBalance(document.getLiveBalance()-balance.getLiveBalance());
			document.setCloseBalance(document.getLiveBalance());
			mongoTemplate.findAndReplace(q, document);
	        System.out.println("amount  subtracted to livebalance and document updated");
		}
		
		else
		{
			Balance balance1 = service.getdocument(Balance.SEQUENCE_NAME);
			balance1.setLiveBalance(balance1.getOpenBalance()-balance.getLiveBalance());
			balance1.setDay(balance.getDay());
			createBalanceDoc(balance1);
			System.out.println("New balance document created with updated liveBalance");
		 }
        
		return "amount subtracted to livebalance and document updated";
 
	}

	
}
