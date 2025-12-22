package com.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.finance.RegistrationLoanApplication;
import com.finance.dto.EnquiryDTO;
import com.finance.model.Registration;
import com.finance.repository.RegistrationRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService
	{

    private final RegistrationLoanApplication registrationLoanApplication;

		@Autowired
		RegistrationRepository registrationRepository;
		
		@Autowired
		RestTemplate restTemplate;

        RegistrationServiceImpl(RegistrationLoanApplication registrationLoanApplication) {
            this.registrationLoanApplication = registrationLoanApplication;
        }

		@Override
		public Registration saveRegistration(Long customerId, Registration registration) 
		{

			EnquiryDTO enquiry = restTemplate.getForObject("http://localhost:1111/enquiry/"+customerId,EnquiryDTO.class);
			System.out.println(enquiry.getEmail());
			registration.setFirstName(enquiry.getFirstName());
			registration.setLastName(enquiry.getLastName());
			registration.setAge(enquiry.getAge());
			registration.setMobileNo(enquiry.getMobileNo());
			registration.setGender(enquiry.getGender());
			registration.setAadharNo(enquiry.getAadharNo());
			registration.setPanNo(enquiry.getPanNo());
			registration.setEmployeeType(enquiry.getEmployeeType());
			registration.setLoanStatus(enquiry.getLoanStatus());
			registration.setEmail(enquiry.getEmail());
			
			
			registrationRepository.save(registration);
			return registration;
		}
		
		
	}
