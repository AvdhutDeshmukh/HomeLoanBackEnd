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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enquiry 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long enquiryId;
		private String firstName;
		private String lastName;
		private Integer age;
		private String email;
		private Long mobileNo;
		private String gender;
		private String aadharNo;
		private String panNo;
		private String employeeType;
		
		
		@OneToOne(cascade = CascadeType.ALL)
		private Cibil cibil;	
		
		

	}
