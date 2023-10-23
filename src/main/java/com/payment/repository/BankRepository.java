package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Bank;


@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
	
	public Bank findByBankNameOrBankAccountNumber(String bankName , String bankAccountNumber);

}
