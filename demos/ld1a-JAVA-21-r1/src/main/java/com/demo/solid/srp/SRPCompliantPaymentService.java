package com.demo.solid.srp;// Abstractions

import java.util.Map;

interface PaymentProcessor {
    void process(double amount);
}

interface FraudChecker {
    boolean isFraudulent(double amount);
}

interface Logger {
    void log(String message);
}

interface Notifier {
    void notify(String email, double amount);
}

// Concrete Implementations

class StripeProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Stripe processed $" + amount);
    }
}

class PayPalProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("PayPal processed $" + amount);
    }
}

class ThresholdFraudChecker implements FraudChecker {
    public boolean isFraudulent(double amount) {
        return amount > 10000;
    }
}

class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class EmailNotifier implements Notifier {
    public void notify(String email, double amount) {
        System.out.println("Sent confirmation to " + email + " for $" + amount);
    }
}

// Orchestrator — has only one reason to change: payment orchestration

public class SRPCompliantPaymentService {
    private final Map<String, PaymentProcessor> gateways;
    private final FraudChecker fraudChecker;
    private final Logger logger;
    private final Notifier notifier;

    public SRPCompliantPaymentService(Map<String, PaymentProcessor> gateways,
                                      FraudChecker fraudChecker,
                                      Logger logger,
                                      Notifier notifier) {
        this.gateways = gateways;
        this.fraudChecker = fraudChecker;
        this.logger = logger;
        this.notifier = notifier;
    }

    public void handle(String gateway, double amount, String email) {
        logger.log("Initiating payment");

        if (fraudChecker.isFraudulent(amount)) {
            logger.log("Fraud blocked payment of $" + amount);
            return;
        }

        PaymentProcessor processor = gateways.get(gateway);
        if (processor == null) {
            logger.log("Invalid gateway: " + gateway);
            return;
        }

        processor.process(amount);
        logger.log("Processed $" + amount + " via " + gateway);
        notifier.notify(email, amount);
    }
}