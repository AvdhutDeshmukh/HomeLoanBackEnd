package com.finance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finance.EnquiryDetailsApplication;
import com.finance.model.Enquiry;
import com.finance.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService
	{

		@Autowired
		EnquiryRepository enquiryRepository;

		@Override
		public Enquiry saveEnquiry(Enquiry e) 
		{
			
			return enquiryRepository.save(e);
		}
		
//		@Override
//		public List<Enquiry> getAllEnquiries() 
//		{
//			return enquiryRepository.findAll();
//		}
//
//		@Override
//		public Optional<Enquiry> getEnquiryById(Long enquiryId) 
//		{
//			return enquiryRepository.findById(enquiryId);
//		}
//
		@Override
		public Enquiry updateEnquiry(Long enquiryId, Enquiry e) 
		{
			Optional<Enquiry> op = enquiryRepository.findById(enquiryId);
			
			if(op.isPresent())
			{
				Enquiry enquiry = op.get();
				
				//enquiry.setEnquiryId(e.getEnquiryId());
				enquiry.setFirstName(e.getFirstName());
				enquiry.setLastName(e.getLastName());
				enquiry.setAge(e.getAge());
				enquiry.setEmail(e.getEmail());
				enquiry.setMobileNo(e.getMobileNo());
				enquiry.setGender(e.getGender());
				enquiry.setAadharNo(e.getAadharNo());
				enquiry.setPanNo(e.getPanNo());
				enquiry.setEmployeeType(e.getEmployeeType());
				
				//enquiry.setCibil(enquiry.getCibil());
				//enquiry.getCibil().setCibilId(enquiry.getCibil().getCibilId());
//				enquiry.getCibil().setCibilRemark(enquiry.getCibil().getCibilRemark());
//				enquiry.getCibil().setCibilScore(enquiry.getCibil().getCibilScore());
//				enquiry.getCibil().setCibilStatus(enquiry.getCibil().getCibilStatus());
//				enquiry.getCibil().setCibilScoreDateTime(enquiry.getCibil().getCibilScoreDateTime());
//				
				return enquiryRepository.save(enquiry);
				
			}
			else
			{
				return null;
			}
			
		}
//
//		@Override
//		public void deleteEnquiry(Long enquiryId) 
//		{
//			enquiryRepository.deleteById(enquiryId);		
//		}
	
		
	}
