package com.finance.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.finance.model.Enquiry;
import com.finance.service.EmailService;
import com.finance.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController 
	{
		@Autowired
		EnquiryService enquiryService;

		@Autowired
		EmailService emailService;
		
		@Autowired
		RestTemplate restTemplate;
       
		//Created By Avdhut
		@PostMapping("/save")
		public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry e)
		{
			Enquiry enquiry = enquiryService.saveEnquiry(e);
			
			emailService.sendEnquiryConfirmation(enquiry.getEmail(),enquiry.getFirstName(),enquiry.getLastName());
			
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.CREATED);
			
		}
				
		@GetMapping("/display")
		public ResponseEntity<List<Enquiry>>  displayEnquiryDetails()
		{
			List<Enquiry>  enquiry = enquiryService.displayEnquiryDetails();
			return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);

		}
		
	
		@GetMapping("/{customerId}")
		public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Long customerId)
		{
			Enquiry enquiry=enquiryService.getEnquiryById(customerId);
			
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
			
		}
		
		@PutMapping("/update/{customerId}")
		public ResponseEntity<Enquiry> updateEnquiry(@PathVariable ("customerId")Long customerId,@RequestBody Enquiry e)
		{
			Enquiry update=enquiryService.updateEnquiry(customerId,e);
			
			return new ResponseEntity<>(update,HttpStatus.OK);
			
		}
		
		@DeleteMapping("/delete/{customerId}")
		public ResponseEntity<Enquiry> deleteEnquiry(@PathVariable ("customerId")Long customerId)
		{
			enquiryService.deleteEnquiry(customerId);
			
			return new ResponseEntity<Enquiry> (HttpStatus.OK);
			
		}
		
		@GetMapping("/updatecibil/{customerId}")
		public ResponseEntity<Enquiry> updateCibil(@PathVariable ("customerId")Long customerId)
		{
			
			Integer cibilScore = restTemplate.getForObject("http://localhost:2222/cibil", Integer.class);
			System.out.println("CibilScore is: " + cibilScore);
			
			Enquiry enquiry = enquiryService.updateCibil(customerId,cibilScore);
	
			String loanStatus = restTemplate.postForObject("http://localhost:2222/loanstatus", enquiry.getLoanStatus(), String.class);
			
			
			return new ResponseEntity<Enquiry> (enquiry,HttpStatus.OK);
			
		
		}
		
		
		@GetMapping("/approved/{customerId}")
		public ResponseEntity<Enquiry> getApprovedEnquiry(@PathVariable Long customerId)
		{
			Enquiry enquiry = enquiryService.getEnquiryById(customerId);
			
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
		}
		
	}

