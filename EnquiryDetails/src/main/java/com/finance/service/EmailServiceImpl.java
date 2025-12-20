package com.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService
	{
		@Autowired
		JavaMailSender mailSender;
		
	@Override
	public void sendEnquiryConfirmation(String toEmail, String firstName, String lastName) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Home Loan Enquiry Received");
        message.setText(
                "Dear " + firstName + " " + lastName  + ",\n\n" +
                "Thank you for submitting your home loan enquiry.\n" +
                "Our bank team will review your details and contact you soon.\n\n" +
                "Regards,\n" +
                "Finance Bank"
        );

        mailSender.send(message);
    
	}
		
	}
