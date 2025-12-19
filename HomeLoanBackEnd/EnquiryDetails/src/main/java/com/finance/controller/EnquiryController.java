package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.model.Enquiry;
import com.finance.service.EnquiryService;

@RestController
public class EnquiryController 
	{
		@Autowired
		EnquiryService esi;
	
		@PostMapping("/save")
		public void saveEnquiry(@RequestBody Enquiry e)
		{
			esi.saveEnquiry(e);
		}
	}
