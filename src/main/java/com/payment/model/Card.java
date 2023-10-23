package com.payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "card")
public class Card {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	private String paymentMethod;
	private String payerFirstName;
	private String payerLastName;
	private String cardNumber;
	private String cardExpiryDate;
	private String cardType;
	private Integer bankid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPayerFirstName() {
		return payerFirstName;
	}
	public void setPayerFirstName(String payerFirstName) {
		this.payerFirstName = payerFirstName;
	}
	public String getPayerLastName() {
		return payerLastName;
	}
	public void setPayerLastName(String payerLastName) {
		this.payerLastName = payerLastName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Integer getBankid() {
		return bankid;
	}
	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", paymentMethod=" + paymentMethod + ", payerFirstName=" + payerFirstName
				+ ", payerLastName=" + payerLastName + ", cardNumber=" + cardNumber + ", cardExpiryDate="
				+ cardExpiryDate + ", cardType=" + cardType + ", bankid=" + bankid + "]";
	}
	



}
