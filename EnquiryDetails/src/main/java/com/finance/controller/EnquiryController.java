package com.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.model.Enquiry;
import com.finance.service.EnquiryService;

@RestController
public class EnquiryController 
	{
		@Autowired
		EnquiryService enquiryService ;
	
		@PostMapping("/save")
		public void saveEnquiry(@RequestBody Enquiry e)
		{
			enquiryService.saveEnquiry(e);
		}
		
		@GetMapping("/display")
		public ResponseEntity<List<Enquiry>>  displayEnquiryDetails()
		{
			List<Enquiry>  enquiry = enquiryService.displayEnquiryDetails();
			return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);
		}
	}
