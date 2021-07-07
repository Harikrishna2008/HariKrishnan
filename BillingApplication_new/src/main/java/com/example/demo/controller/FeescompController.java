package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FeesComp;
import com.example.demo.service.FeescompService;


@RequestMapping("/api/v1")
@RestController
public class FeescompController {
	
	private FeescompService feescompservice;
	
	public FeescompController (FeescompService feescompservice)
	{
		this.feescompservice = feescompservice;
	}
	
	@PostMapping("/FeesComp")
	public String createFeesComp (@RequestBody FeesComp feescomp)
	{
		System.out.println("create FeesComp");
		return feescompservice.addFeesComp(feescomp);
	}
	
	@PutMapping("/FeesComp")
	public String  updatefeesComp(@RequestBody FeesComp feescomp)
	{
		System.out.println("update FeesComp");
		return feescompservice.updateFeesComp(feescomp);
	}
	
}
