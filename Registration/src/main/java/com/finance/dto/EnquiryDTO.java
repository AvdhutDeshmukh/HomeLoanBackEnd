package com.finance.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnquiryDTO 
	{
		
		private Long customerId;
	
		private String firstName;
		private String lastName;
		private Integer age;
		private String email;
		private Long mobileNo;
		private String gender;
		private String aadharNo;
		private String panNo;
		private String employeeType;
		private String loanStatus;
		
		
	}
