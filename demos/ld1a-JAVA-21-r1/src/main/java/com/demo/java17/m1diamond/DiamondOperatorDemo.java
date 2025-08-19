package com.demo.java17.m1diamond;

import java.math.BigDecimal;
// BigDecimal is used for precise financial calculations
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

        // Legacy [Java 7] allows type inference
        Map<String, List<Transaction>> legacyTransactions1 = new HashMap<>();
        legacyTransactions1.put("EUR", new ArrayList<Transaction>());

        // Java 7
        TransactionProcessor<Transaction> legacyProcessor = new TransactionProcessor<Transaction>() {
            @Override
            public void process(Transaction transaction) {
                System.out.println("Modern Transaction: " + transaction);
            }
        };
        // Java 9+ Diamond operator with anonymous inner class
        TransactionProcessor<Transaction> modernProcessor = new TransactionProcessor<>() {
            @Override
            public void process(Transaction transaction) {
                System.out.println("Modern Transaction: " + transaction);
            }
        };
    }
}

// Generic interface for processing transactions
// The advantage of using a generic interface is that it allows for type safety and reusability across different transaction types.
interface TransactionProcessor<T> {
    void process(T transaction);
}