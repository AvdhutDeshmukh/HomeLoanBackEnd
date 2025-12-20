package com.finance.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.model.Cibil;
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
	@Override
	public List<Enquiry> displayEnquiryDetails() {
		List<Enquiry> list = enquiryRepository.findAll();
		return list;
	}
		
		@Override
		public Enquiry updateEnquiry(Long enquiryId, Enquiry e) 
		{
			Optional<Enquiry> op = enquiryRepository.findById(enquiryId);
			
			if(op.isPresent())
			{
				Enquiry enquiry = op.get();
				
				
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
		
		@Override
		public Enquiry getEnquiryById(Long enquiryId) 
		{
			return enquiryRepository.findById(enquiryId).orElseThrow();
		}
		
		@Override
		public void deleteEnquiry(Long enquiryId) 
		{
			enquiryRepository.deleteById(enquiryId);		
		}
		@Override
		public Enquiry updateCibil(Long enquiryId, Integer cibilScore) 
		{
			Enquiry enquiry = enquiryRepository.findById(enquiryId).get();
			
			Cibil cibil = new Cibil();
			cibil.setCibilScore(cibilScore);
			cibil.setCibilScoreDateTime(new Date());
			
			if(cibilScore>=300 && cibilScore < 650)
			{
				cibil.setCibilStatus("Rejected");
				cibil.setCibilRemark("Poor");
			}
			else if(cibilScore>=650 && cibilScore < 700)
			{
				cibil.setCibilStatus("Approved");
				cibil.setCibilRemark("Fair");
			}
			else if(cibilScore>=700 && cibilScore < 750)
			{
				cibil.setCibilStatus("Approved");
				cibil.setCibilRemark("Good");
			}
			else if(cibilScore>=750 && cibilScore <= 900)
			{
				cibil.setCibilStatus("Approved");
				cibil.setCibilRemark("Excellent");
			}
			
			enquiry.setCibil(cibil);
			enquiryRepository.save(enquiry);
			return enquiryRepository.save(enquiry);
			
			
		}
		
	
		
	}
