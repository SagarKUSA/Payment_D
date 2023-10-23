package com.payment.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Bank;
import com.payment.model.Card;
import com.payment.repository.BankRepository;
import com.payment.service.BankService;

@Service
public class BankServiceImpl  implements BankService{
	@Autowired
	private BankRepository bankRepository;

	@Override
	public Bank addDetails(Bank bank) {
		Bank save = bankRepository.save(bank);
		return save;
	}

	@Override
	public Bank updateDetails(Bank bank) {
		 Bank update = bankRepository.save(bank);
		return update;
	}

	@Override
	public Bank getDetails(Integer id) {
		Optional<Bank>  get =bankRepository.findById(id);
		
		if(get.isPresent()) {
			return get.get();
			}else {
			throw new ResourceNotFoundException("No records found :" +id);	
			}
		
	}

	@Override
	public void deleteDetails(Integer id) {
		
		
		if(bankRepository.existsById(id)) {
			bankRepository.findById(id);
		}else {
			throw new ResourceNotFoundException("Bank details are not avilable :" +id);
		}
		
	}

	@Override
	public Bank search(String bankName, String bankAccountNumber) {
		 Bank bank= bankRepository.findByBankNameOrBankAccountNumber(bankName, bankAccountNumber);

	    if (bank != null) {
	        return bank;
	    } else {
	        throw new ResourceNotFoundException("Bank with bank name '" + bankName + "' or bank account number '" + bankAccountNumber + "' not found.");
	}

	
	}
}
