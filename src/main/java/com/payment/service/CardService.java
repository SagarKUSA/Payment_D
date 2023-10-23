package com.payment.service;

import com.payment.model.Card;

public interface CardService {
	
	public Card addCardDetails (Card card);
	
	public Card updateCardDetasils (Card card);
 
	public Card getCardDetails (Integer id);
	
	public void deleteCardsDetails (Integer id);
	
	public Card searchCard (String payerFirstName , String payerLastName);
}
