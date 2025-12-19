package com.finance.controller;

import java.util.List;

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

			enquiryService.saveEnquiry(e);
		}
		
		@GetMapping("/display")
		public ResponseEntity<List<Enquiry>>  displayEnquiryDetails()
		{
			List<Enquiry>  enquiry = enquiryService.displayEnquiryDetails();
			return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);

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

