package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Bank;
import com.payment.model.Card;
import com.payment.service.BankService;
import com.payment.service.CardService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;

	@Autowired
	private CardService cardService;

	@PostMapping("/addBankCardDetails")
	@ApiOperation(value = "Request to add bank card details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Bank addBankDetailsWithCard(@RequestBody Bank bank) {

		Bank addBank = bankService.addDetails(bank);

		if (bank.getCardList() == null) {
			throw new ResourceNotFoundException("Given bank with card details are not avilable :" + bank);
		}

		List<Card> cards = bank.getCardList();
		for (Card card : cards) {
			card.setBankid(bank.getId());
			cardService.addCardDetails(card);
		}
		return addBank;

	}

	@PutMapping("/updateDetails")
	@ApiOperation(value = "Request to edit bank card details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Bank updateDetails(@RequestBody Bank bank) {

		Bank update = bankService.updateDetails(bank);

		List<Card> cards = bank.getCardList();

		for (Card card : cards) {
			card.setBankid(bank.getId());
			cardService.addCardDetails(card);
		}
		return update;
	}

	@GetMapping("/getDetails/{id}")
	@ApiOperation(value = "Request to get bank card details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Bank getDetails(@PathVariable("id") Integer id) {
		Bank get = bankService.getDetails(id);
		return get;
	}

	@DeleteMapping("/deleteDetails/{id}")
	@ApiOperation(value = "Request to delete bank card details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public void deleteDetails(@PathVariable("id") Integer id) {
		bankService.deleteDetails(id);
	}

	@GetMapping("/getDetailsNameAccount")
	@ApiOperation(value = "Request to get bank card details using name and account number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error")})
	public Bank search(@RequestParam("bankName") String bankName,
			@RequestParam("bankAccountNumber") String bankAccountNumber) {
		Bank search = bankService.search(bankName, bankAccountNumber);
		return search;
	}
	@GetMapping("/bankByPage")
	public List<Bank> getBankByPage(@RequestParam (defaultValue = "0" )Integer pageNumber, 
			                        @RequestParam (defaultValue = "100") Integer pageSize,
			                        @RequestParam (defaultValue = "bankName")String sortBy){
		
		List<Bank> bankByPage = bankService.getAllBank(pageNumber, pageSize , sortBy);
		
		return bankByPage;
}
}
