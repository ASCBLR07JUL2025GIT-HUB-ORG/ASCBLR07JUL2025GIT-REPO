package com.demo.solid.srp.violation;

public class PaymentServiceSRPViolation {

    public void processPayment(String gateway, double amount, String customerEmail) {
        // Payment processing logic
        if ("Stripe".equals(gateway)) {
            System.out.println("Processing Stripe payment of $" + amount);
        } else if ("PayPal".equals(gateway)) {
            System.out.println("Processing PayPal payment of $" + amount);
        }

        // Fraud detection
        if (amount > 10000) {
            System.out.println("Fraud detected: Amount too high");
            return;
        }

        // Logging
        System.out.println("Logged payment of $" + amount + " via " + gateway);

        // Notification
        System.out.println("Sending email to " + customerEmail + " for payment confirmation");
    }
}