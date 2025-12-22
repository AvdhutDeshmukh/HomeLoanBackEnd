package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.model.Registration;
import com.finance.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController 
	{
		@Autowired
		RegistrationService registrationService;
			
		@PostMapping("/save/{customerId}")
		public ResponseEntity<Registration> saveRegistration(@PathVariable ("customerId") Long customerId,@RequestBody Registration registration)
		{
			Registration register = registrationService.saveRegistration(customerId,registration);
			
			return new ResponseEntity<Registration> (register,HttpStatus.CREATED);
			
		}
	}
