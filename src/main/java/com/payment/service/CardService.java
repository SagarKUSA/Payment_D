package com.payment.service;

import java.util.List;

import com.payment.model.Bank;
import com.payment.model.Card;

public interface CardService {
	
	public Card addCardDetails (Card card);
	
	public Card updateCardDetasils (Card card);
 
	public Card getCardDetails (Integer id);
	
	public void deleteCardsDetails (Integer id);
	
	public Card searchCard (String payerFirstName , String payerLastName);
	
	public List<Card> getAllCards(Integer pageNumber , Integer pageSize , String sortBy);
}
