package com.demo.solid.lsp;

// Core abstraction
interface PaymentProcessor {
    void process(double amount, String account);
}

// Refundable abstraction
interface RefundablePaymentProcessor extends PaymentProcessor {
    void refund(double amount, String account);
}

// Stripe supports refunds
class StripeProcessor implements RefundablePaymentProcessor {
    public void process(double amount, String account) {
        System.out.println("Stripe charged $" + amount);
    }
    public void refund(double amount, String account) {
        System.out.println("Stripe refunded $" + amount);
    }
}

// Crypto does NOT support refunds
class CryptoProcessor implements PaymentProcessor {
    public void process(double amount, String account) {
        System.out.println("Crypto sent $" + amount);
    }
}