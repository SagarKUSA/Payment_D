package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.Bank;
import com.payment.model.Card;
import com.payment.service.CardService;

@RestController
public class CardController {
	
	
	@Autowired
	private CardService cardService;
	
	
	@PostMapping("/addCardDetails")
public Card addCardDetails (@RequestBody Card card) {
	Card add= cardService.addCardDetails(card);
    return add;
}
	@PutMapping("/updateCard")
	public Card updateCardDetasils (@RequestBody Card card) {
		Card update = cardService.updateCardDetasils(card);
		return update;
	}
	
	@GetMapping("/getCardDetails/{id}")
	public Card getCardDetails (@PathVariable ("id") Integer id) {
		Card get= cardService.getCardDetails(id);
		return get;
	}
	
	@DeleteMapping("deleteCardDetails")
	public void deleteCardsDetails (@PathVariable ("id") Integer id) {
		cardService.deleteCardsDetails(id);
		
	}
	
	@GetMapping("searchByFirstLastName/")
	public Card searchCard (@RequestParam ("firstName") String payerFirstName ,
			               @RequestParam ("lastName") String payerLastName) {
      Card search=  cardService.searchCard(payerFirstName, payerLastName);
	return search;
}
	@GetMapping("/bankByPage")
	public List<Card> getCardByPage(@RequestParam (defaultValue = "0" )Integer pageNumber, 
			                        @RequestParam (defaultValue = "100") Integer pageSize,
			                        @RequestParam (defaultValue = "paymentMethod")String sortBy){
		
		List<Card> cardByPage = cardService.getAllCards(pageNumber, pageSize , sortBy);
		
		return cardByPage;
	}
	}
