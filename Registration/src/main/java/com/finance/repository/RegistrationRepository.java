package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>
	{

	}
