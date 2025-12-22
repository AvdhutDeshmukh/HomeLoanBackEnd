package com.finance.model;

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
@Entity
public class AllPersonalDocuments 
	{	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer documentID;
		private byte[] addressProof;
		private byte[] panCard;
		private	byte[] incomeTax;
		private	byte[] aadharCard;
		private	byte[] photo;
		private	byte[] signature;
		private	byte[] bankCheque;
		private	byte[] salarySlips;

	}
