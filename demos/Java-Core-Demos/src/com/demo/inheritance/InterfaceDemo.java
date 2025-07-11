package com.demo.inheritance;

public class InterfaceDemo {
}

interface CreditCard5 {
// By default methods in an interface are public and abstract
//    void makePayment();
//    public void makePayment();
public abstract void makePayment();
}

interface NetBanking5 {
    public abstract void transferMoney();
}

class BankAccount implements CreditCard5, NetBanking5 {
    public  void makePayment(){

}
    public  void transferMoney(){

    }
}

interface VIPCreditCard extends CreditCard5 {

}