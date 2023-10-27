package com.payment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Bank;
import com.payment.model.Card;
import com.payment.repository.CardRepository;
import com.payment.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardRepository cardRepository;

	@Override
	public Card addCardDetails(Card card) {
		Card add = cardRepository.save(card);
		return add;
	}

	@Override
	public Card updateCardDetasils(Card card) {
		Card update = cardRepository.save(card);
		return update;
	}

	@Override
	public Card getCardDetails(Integer id) {
		Optional<Card> get = cardRepository.findById(id);
		
		return get.orElse(null);
	}

	@Override
	public void deleteCardsDetails(Integer id) {
		
		if(cardRepository.existsById(id)) {
			cardRepository.deleteById(id);
		}else {
		  throw new ResourceNotFoundException ("No card found with id : "+id);
		}
		
		
	}

	@Override
	public Card searchCard(String payerFirstName, String payerLastName) {
		 Card search = cardRepository.findByPayerFirstNameAndPayerLastName(payerFirstName, payerLastName);

		    if (search != null) {
		        return search;
		    } else {
		        throw new ResourceNotFoundException("Card for payer with first name '" + payerFirstName + "' and last name '" + payerLastName + "' not found.");
		
	}
}

	@Override
public List<Card> getAllCards(Integer pageNumber, Integer pageSize , String sortBy) {
		
		Pageable paging = PageRequest.of(pageNumber, pageSize , Sort.by("paymentMethod").ascending());
		
		Page< Card> cardResult = cardRepository.findAll(paging);
		
		if(cardResult.hasContent()) {
			return cardResult.getContent();
	}
         return new ArrayList<Card>();
}
}
