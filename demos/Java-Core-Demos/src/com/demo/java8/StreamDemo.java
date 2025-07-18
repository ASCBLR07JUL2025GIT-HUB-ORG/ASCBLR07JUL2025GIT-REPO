package com.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        // 1. Stream - An object on which operations are defined
        System.out.println("Products starting with 'P':");
        List<String> productList = Arrays.asList("Phone", "Laptop", "Pen", "Pencil", "Printer");

        productList.stream() // Stream is the object
                .filter(p -> p.startsWith("P")) // defining operation
                .forEach(System.out::println);

        // 2. Stream does not change data during computation
        List<Double> prices = Arrays.asList(100.0, 200.0, 300.0);
        List<Double> discountedPrices = prices.stream()
                .map(p -> p * 0.9) // Apply 10% discount
                .collect(Collectors.toList()); // Java 8 compatible

        System.out.println("\nOriginal prices: " + prices);
        System.out.println("Discounted prices: " + discountedPrices);

        // 3. Stream processes data in parallel
        List<String> orders = Arrays.asList("Order#1", "Order#2", "Order#3", "Order#4");

        System.out.println("\nParallel Order Processing:");
        orders.parallelStream()
                .forEach(order -> {
                    System.out.println(Thread.currentThread().getName() + " processing " + order);
                });

        // 4. Reduction - combining stream elements into a single result
        // Individual elements are read from the stream pipeline and combined into a single value
        // using a terminal operation. This is called reduction.
        double totalRevenue = prices.stream()
                .reduce(0.0, (a, b) -> a + b); // sum all prices

        System.out.println("\nTotal Revenue (before discount): $" + totalRevenue);
    }
}
