package com.payment.service;

import com.payment.model.Bank;

public interface BankService {
	
	public Bank addDetails (Bank bank);
	
	public Bank updateDetails (Bank bank);
	
	public Bank getDetails (Integer id);
	
	public void deleteDetails (Integer id);
	
	public Bank search (String bankName , String bankAccountNumber);

}
