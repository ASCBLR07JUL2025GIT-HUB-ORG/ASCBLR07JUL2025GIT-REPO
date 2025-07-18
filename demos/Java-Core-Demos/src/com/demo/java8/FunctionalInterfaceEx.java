package com.demo.java8;

public class FunctionalInterfaceEx {
    public static void main(String[] args) {

        // Anonymous Class Implementation
        // Anonymous classes are used to create instances of functional interfaces
        // without explicitly defining a class.
        Discount summerSale = new Discount() {
            @Override
            public double apply(double price) {
                return price * 0.8;
            }
        };
        // Lambda Expressions are an Alternate Way of Creating Anonymous Class Instances
        // The Type of Lambda Expression is a Functional Interface
        // Lambda Expressions (lambdas) can be stored in a variable
        Discount summerSale1 = (price) -> price * 0.8; // 20% off

        double originalPrice = 100;
        System.out.println("Discounted price: $" + summerSale1.apply(originalPrice));
    }
}

// interfaces with a single abstract method (functional interfaces).
@FunctionalInterface
interface Discount {
    double apply(double price);
}


class DiscountImpl implements Discount {
    @Override
    public double apply(double price) {
        return price * 0.8; // 20% off
    }
}