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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@PostMapping("/addCardDetails")
	@ApiOperation(value = "Request to add card details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Card addCardDetails(@RequestBody Card card) {
		Card add = cardService.addCardDetails(card);
		return add;
	}

	@PutMapping("/updateCard")
	@ApiOperation(value = "Request to edit card details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Card updateCardDetasils(@RequestBody Card card) {
		Card update = cardService.updateCardDetasils(card);
		return update;
	}

	@GetMapping("/getCardDetails/{id}")
	@ApiOperation(value = "Request to get card details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Card getCardDetails(@PathVariable("id") Integer id) {
		Card get = cardService.getCardDetails(id);
		return get;
	}

	@DeleteMapping("deleteCardDetails")
	@ApiOperation(value = "Request to delete card details using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public void deleteCardsDetails(@PathVariable("id") Integer id) {
		cardService.deleteCardsDetails(id);

	}

	@GetMapping("searchByFirstLastName/")
	@ApiOperation(value = "Request to get card details using payer firstname and lastname")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public Card searchCard(@RequestParam("firstName") String payerFirstName,
			@RequestParam("lastName") String payerLastName) {
		Card search = cardService.searchCard(payerFirstName, payerLastName);
		return search;
	}

	@GetMapping("/cardByPage")
	@ApiOperation(value = "Request to get all card details in pages")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public List<Card> getCardByPage(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "100") Integer pageSize,
			@RequestParam(defaultValue = "paymentMethod") String sortBy) {

		List<Card> cardByPage = cardService.getAllCards(pageNumber, pageSize, sortBy);

		return cardByPage;
	}
}
