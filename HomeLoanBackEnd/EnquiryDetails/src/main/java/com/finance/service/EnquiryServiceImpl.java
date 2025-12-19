package com.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.model.Enquiry;
import com.finance.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService
	{
		@Autowired
		EnquiryRepository er;
	@Override
	public void saveEnquiry(Enquiry e) 
		{
			er.save(e);
		}
		
	}
