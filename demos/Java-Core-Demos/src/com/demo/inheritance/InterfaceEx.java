package com.demo.inheritance;

public class InterfaceEx {
public static void main(String[] args) {
	//cannot instantiate an interface
//	Transaction transaction = new Transaction();
	Transaction transaction = null;
	transaction = new CreditCard();
	// a transaction has happened using the credit card
	transaction.saveTransactionReport();
	
//	CreditCard creditCard1 = (CreditCard)transaction;
//	creditCard1.pay(700);
//	((CreditCard)transaction).pay(500);
	
	CreditCard creditCard = new CreditCard();
	creditCard.validate();
	creditCard.pay(500);
	creditCard.saveTransactionReport();
	
	//credit card to only pay
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

//Implement NetBanking class
// open fixed deposits
// transfer funds
// pay