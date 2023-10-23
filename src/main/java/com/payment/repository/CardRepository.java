package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Card;
import com.payment.service.BankService;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

	public Card findByPayerFirstNameAndPayerLastName (String payerFirstName , String payerLastName);
	
	}
