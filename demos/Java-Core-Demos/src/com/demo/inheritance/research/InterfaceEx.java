package com.demo.inheritance.research;

public class InterfaceEx {
public static void main(String[] args) {
	//cannot instantiate an interface
//	Transaction transaction = new Transaction();
	Transaction transaction = null;
	transaction = new CreditCard();
//	transaction = new Crypto();
	// a transaction has happened using the credit card
	transaction.saveTransactionReport();
	
//	CreditCard creditCard1 = (CreditCard)transaction;
//	creditCard1.pay(700);
//	((CreditCard)transaction).pay(500);
	
	CreditCard creditCard = new CreditCard();
	creditCard.validate();
	creditCard.pay(500);
	creditCard.saveTransactionReport();
	
//	Dynamic Polymorphsim
//  Till the point of execution you never know what implementation if powering your functionality.
	Payment payment = null;
	//credit card to only pay
	if(Math.random() > 0.5) {
	payment	 = new PowerCreditCard();		
	}
	else
	{
		payment	 = new CreditCard();	
	}
	payment.pay(500);
}
}


interface Transaction {
//	public abstract void saveTransactionReport();
//	abstract public  void saveTransactionReport();
//	abstract void saveTransactionReport();
//	public  void saveTransactionReport();
	void saveTransactionReport();
}

interface Payment extends Transaction{
	void pay(float amount);
	
}

interface FundTransfer extends Transaction{
	void transferFunds(float amount);
	
}

class CreditCard implements Payment {

	@Override
	public void saveTransactionReport() {
		System.out.println("Save report and can be viewed in the credit card statement.");
	}
	@Override
	public void pay(float amount) {
		System.out.println("Pay using card number and CVV " + amount);
	}
	
	public void validate() {
		System.out.println("Validate Credit card.");
	}
}

class PowerCreditCard implements Payment {

	@Override
	public void saveTransactionReport() {
		System.out.println("Save report and can be viewed in the credit card statement.");
	}
	@Override
	public void pay(float amount) {
		System.out.println("Pay using finger print " + amount);
	}
	
	public void validate() {
		System.out.println("Validate Credit card.");
	}
}

class Crypto implements Transaction{
	@Override
	public void saveTransactionReport() {
		System.out.println("Some other means");
	}
}
//Implement NetBanking class
// open fixed deposits
// transfer funds
// pay