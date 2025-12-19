package com.finance.service;

import java.util.List;
import java.util.Optional;

import com.finance.model.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(Enquiry e);

//	public List<Enquiry> getAllEnquiries();
//
//	public Optional<Enquiry> getEnquiryById(Long enquiryId);
//
	public Enquiry updateEnquiry(Long enquiryId, Enquiry e);
//
//	public void deleteEnquiry(Long enquiryId);
//	

	
	

}
