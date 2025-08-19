package com.demo.solid.ocp.violation;

public class OCPViolationPaymentService {
    public void process(String gateway, double amount, String account) {
        if ("Stripe".equalsIgnoreCase(gateway)) {
            System.out.println("Processing via Stripe: $" + amount);
        } else if ("PayPal".equalsIgnoreCase(gateway)) {
            System.out.println("Processing via PayPal: $" + amount);
        } else if ("Crypto".equalsIgnoreCase(gateway)) {
            System.out.println("Processing via Crypto Wallet: $" + amount);
        } else {
            throw new IllegalArgumentException("Unsupported gateway: " + gateway);
        }
    }
}