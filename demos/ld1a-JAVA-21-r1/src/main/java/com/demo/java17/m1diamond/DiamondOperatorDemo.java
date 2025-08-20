package com.demo.java17.m1diamond;

import java.math.BigDecimal;
// BigDecimal is used for precise financial calculations
// The BigDecimal 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Common domain classes
class Transaction {
    private String id;
    private BigDecimal amount;

    public Transaction(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + "}";
    }
}

public class DiamondOperatorDemo {
    public static void main(String[] args) {

        System.out.println("==== Diamond Operator Demo ====");
        // Legacy [Pre Java 7]
        Map<String, List<Transaction>> legacyTransactions = new HashMap<String, List<Transaction>>();
        legacyTransactions.put("USD", new ArrayList<Transaction>());
        // Add a transaction to the USD list
        // legacyTransactions.get("USD").add(new Transaction("USD1", BigDecimal.valueOf(100.50)));
        List<Transaction> usdTransactions = legacyTransactions.get("USD");
        usdTransactions.add(new Transaction("USD1", BigDecimal.valueOf(100.50)));
        System.err.println(legacyTransactions);
        // Legacy [Java 7] allows type inference
        Map<String, List<Transaction>> legacyTransactions1 = new HashMap<>();
        legacyTransactions1.put("EUR", new ArrayList<Transaction>());
        System.out.println(legacyTransactions1);
        // Java 7
        TransactionProcessor<Transaction> legacyProcessor = new TransactionProcessor<Transaction>() {
            @Override
            public void process(Transaction transaction) {
                System.out.println("Modern Transaction: " + transaction);
            }
        };
        legacyProcessor.process(new Transaction("JPY", BigDecimal.valueOf(500.5f)));
        // Java 9+ Diamond operator with anonymous inner class
        TransactionProcessor<Transaction> modernProcessor = new TransactionProcessor<>() {
            @Override
            public void process(Transaction transaction) {
                System.out.println("Modern Transaction: " + transaction);
            }
        };
        modernProcessor.process(new Transaction("GBP", BigDecimal.valueOf(1000.75f)));
    }
}

// Generic interface for processing transactions
// The advantage of using a generic interface is that it allows for type safety and reusability across different transaction types.
interface TransactionProcessor<T> {
    void process(T transaction);
}