package com.finance.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Registration 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long customerId;
		private String customerDateOfBirth;
		private Integer requiredTenure;
		private double customerAdditionalMobileNumber;
		private double customerAmountPaidForHome;
		private double customerTotalLoanRequired;
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

//		@OneToOne(cascade = CascadeType.ALL)
//		private AllPersonalDocuments allpersonalDocument;
		
	}
