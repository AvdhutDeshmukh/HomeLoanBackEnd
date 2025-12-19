package com.finance.controller;

import java.util.List;
import java.util.Optional;

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

import com.finance.model.Enquiry;
import com.finance.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController 
	{
		@Autowired
		EnquiryService enquiryService;
	
		//Created By Avdhut
		@PostMapping("/save")
		public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry e)
		{
			Enquiry enq = enquiryService.saveEnquiry(e);

	        return new ResponseEntity<>(enq, HttpStatus.CREATED);
	        
		}
		
	
//		@GetMapping("/all")
//		public ResponseEntity<List<Enquiry>> getAllEnquiries()
//		{
//			List<Enquiry> list = enquiryService.getAllEnquiries();
//			
//			return new ResponseEntity<>(list,HttpStatus.OK);
//		}
//		
//		@GetMapping("/{enquiryId}")
//		public ResponseEntity<List<Enquiry>> getEnquiryById(@PathVariable Long enquiryId)
//		{
//			Optional<Enquiry> enquiry=enquiryService.getEnquiryById(enquiryId);
//			
//			return new ResponseEntity<List<Enquiry>>(HttpStatus.OK);
//			
//		}
//		
		@PutMapping("/update/{enquiryId}")
		public ResponseEntity<Enquiry> updateEnquiry(@PathVariable Long enquiryId,@RequestBody Enquiry e)
		{
			Enquiry update=enquiryService.updateEnquiry(enquiryId,e);
			
			return new ResponseEntity<>(update,HttpStatus.OK);
			
		}
//		
//		@DeleteMapping("/delete/{enquiryId}")
//		public ResponseEntity<Enquiry> deleteEnquiry(@PathVariable Long enquiryId)
//		{
//			enquiryService.deleteEnquiry(enquiryId);
//			
//			return new ResponseEntity<Enquiry> (HttpStatus.OK);
//			
//		}
	}

