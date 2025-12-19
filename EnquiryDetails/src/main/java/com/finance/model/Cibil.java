package com.finance.model;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cibil 
	{	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long cibilId;
		private Integer cibilScore;
		private Date cibilScoreDateTime;
		private String cibilStatus;
		private String cibilRemark;
			
		
	}
