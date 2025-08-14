package com.demo.java21.m2streamapienhancements;

import java.io.FileFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// The Stream API was introduced in Java 8.
// It provides a functional approach to processing sequences of elements, such as collections or arrays.
public class ModernStreamApiDemo {
    public static void main(String[] args) {
        // 1. Sample data initialization
        List<Transaction> transactions = Arrays.asList(
//                new Transaction("T3", new BigDecimal(400.50)),
                new Transaction("T1", new BigDecimal(100.50)),
                new Transaction("T3", new BigDecimal(400.50)),
                new Transaction("T2", new BigDecimal(200.50)),
                new Transaction("T3", new BigDecimal(300.50)),
                 new Transaction("T1", new BigDecimal(100.50)),
                 new Transaction("T2", new BigDecimal(375.50)),
                 new Transaction("T3", new BigDecimal(400.50)),
                new Transaction("T1", new BigDecimal(100.50)),
                new Transaction("T2", new BigDecimal(200.50)),
                new Transaction("T3", new BigDecimal(300.50)));

        // 2. takeWhile :
        // The takeWhile method allows you to take elements from a stream as long as a
        // given predicate is true.
        // It stops processing as soon as the predicate returns false for the first
        // time.
        // This is useful for processing sorted data or when you want to stop processing
        // as soon as a condition is met.

        System.out.println("========= Small Transaction =============");

        Predicate<Transaction> predicateWithConcreteImplementation = new MyPredicateImplementation();
        boolean status = predicateWithConcreteImplementation.test(new Transaction("T4", new BigDecimal(500.00)));
        System.out.println(status);

        Predicate<Transaction> predicateWithAnonymousImplementation = new Predicate<Transaction>() {
            public boolean test(Transaction transaction) {
                // This method should be overridden to provide the actual predicate logic.
                if (transaction.getAmount().compareTo(BigDecimal.valueOf(400)) < 0)
                    return true;
                return false;
            }
        };
        status = predicateWithAnonymousImplementation.test(new Transaction("T4", new BigDecimal(500.00)));
        System.out.println(status);

        Predicate<Transaction> predicateWithLambdaImplementation = (
                Transaction transaction) -> transaction.getAmount().compareTo(BigDecimal.valueOf(400)) < 0;
        status = predicateWithLambdaImplementation.test(new Transaction("T4", new BigDecimal(500.00)));
        System.out.println(status);

        System.err.println("Processing the transactions!");
        transactions.stream().takeWhile(transaction -> transaction.getAmount().compareTo(BigDecimal.valueOf(400)) < 0 ).
                forEach(System.out::println);

        // The stream() method creates a sequential Stream from the list of
        // transactions.
        // The t -> t.getAmount().compareTo(BigDecimal.valueOf(400)) < 0 condition
        // checks if the amount of each transaction is less than 400.
        // Stream<Transaction> transactionStream = transactions.stream();

        // transactions.stream()
        // .takeWhile(t -> t.getAmount().compareTo(BigDecimal.valueOf(400)) < 0)
        // .forEach(System.out::println);
    }
}

// Concrete implementation of Predicate interface
class MyPredicateImplementation implements Predicate<Transaction> {
    public boolean test(Transaction transaction) {
        // This method should be overridden to provide the actual predicate logic.
        if (transaction.getAmount().compareTo(BigDecimal.valueOf(400)) < 0)
            return true;
        return false;
    }
}

class Transaction {
    private final String id;
    private final BigDecimal amount;

    public Transaction(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", id='" + id + '\'' +
                '}';
    }
}