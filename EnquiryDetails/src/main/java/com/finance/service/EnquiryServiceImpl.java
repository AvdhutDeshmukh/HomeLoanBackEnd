package com.finance.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.finance.model.Cibil;
import com.finance.model.Enquiry;
import com.finance.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService
	{

		@Autowired
		EnquiryRepository enquiryRepository;

		@Autowired
		JavaMailSender mailSender;
		
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
		public Enquiry updateEnquiry(Long customerId, Enquiry e) 
		{
			Optional<Enquiry> op = enquiryRepository.findById(customerId);
			
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
		public Enquiry getEnquiryById(Long customerId) 
		{
			return enquiryRepository.findById(customerId).orElseThrow();
		}
		
		@Override
		public void deleteEnquiry(Long customerId) 
		{
			enquiryRepository.deleteById(customerId);		
		}
		
		@Override
		public Enquiry updateCibil(Long customerId, Integer cibilScore) 
		{

		    Enquiry enquiry = enquiryRepository.findById(customerId).orElseThrow();
		    
		    Cibil cibil = new Cibil();
		    cibil.setCibilScore(cibilScore);
		    cibil.setCibilScoreDateTime(new Date());

		    if (cibilScore >= 300 && cibilScore < 650) 
		    {
		        cibil.setCibilStatus("Rejected");
		        cibil.setCibilRemark("Poor");
		        enquiry.setLoanStatus("REJECTED");
		    }
		    else if (cibilScore >= 650 && cibilScore < 700) 
		    {
		        cibil.setCibilStatus("Approved");
		        cibil.setCibilRemark("Fair");
		        enquiry.setLoanStatus("APPROVED");
		        enquiry.setLoanStatus("FORWARD-TO-OE");;
		    }
		    else if (cibilScore >= 700 && cibilScore < 750) 
		    {
		        cibil.setCibilStatus("Approved");
		        cibil.setCibilRemark("Good");
		        enquiry.setLoanStatus("APPROVED");
		        enquiry.setLoanStatus("FORWARD-TO-OE");
		    }
		    else if (cibilScore >= 750 && cibilScore <= 900) 
		    {
		        cibil.setCibilStatus("Approved");
		        cibil.setCibilRemark("Excellent");
		        enquiry.setLoanStatus("APPROVED");
		        enquiry.setLoanStatus("FORWARD-TO-OE");
		    }

		    enquiry.setCibil(cibil);
		    

		    try {
		    	
		        SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(enquiry.getEmail());
		        message.setFrom("deshmukhavdhut756@gmail.com");
		        message.setSubject("CIBIL Score Check");

		        boolean approved = "Approved".equalsIgnoreCase(cibil.getCibilStatus());

		        message.setText(
		            "Dear " + enquiry.getFirstName() + " " + enquiry.getLastName() + ",\n\n" +
		            "Your CIBIL score has been evaluated.\n\n" +
		            "CIBIL Score: " + cibilScore + "\n" +
		            "Status: " + cibil.getCibilStatus() + "\n" +
		            "Remark: " + cibil.getCibilRemark() + "\n\n" +
		            (approved
		                ? "Congratulations! You are eligible for home loan processing."
		                : "Unfortunately, you are currently not eligible for a home loan.") +
		            "\n\nRegards,\nHome Loan Team"
		        );

		        mailSender.send(message);
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }

		    return enquiryRepository.save(enquiry);
		}
		
		
	
		
	
}
		
	
