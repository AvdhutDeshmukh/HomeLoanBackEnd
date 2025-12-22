package com.finance.service;

import java.util.List;
import java.util.Optional;

import com.finance.model.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(Enquiry e);

	public List<Enquiry> displayEnquiryDetails();

	public Enquiry getEnquiryById(Long customerId);
	
	public Enquiry updateEnquiry(Long customerId, Enquiry e);

	public void deleteEnquiry(Long customerId);

	public Enquiry updateCibil(Long customerId, Integer cibilScore);


	}
