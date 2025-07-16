package com.demo.collections;

import java.util.ArrayList;

public class ArrayListEx {

    public static void main(String[] args) {

        // rawTypes();
        genericTypes();
    }

    private static void rawTypes() {
        // ArrayList without generics (raw type)
        // ArrayList allows any type of object to be added.
        // This is not type-safe and can lead to runtime errors.
        // It is recommended to use generics for type safety.
        // ArrayList allows duplicate elements and maintains insertion order.
        // Allows null elements.
        ArrayList colorsList = new ArrayList();
        colorsList.add("Red");
        colorsList.add(null);
        colorsList.add("null");
        colorsList.add("Green");
        ArithmeticException arithmeticException = new ArithmeticException("Sample Exception");
        colorsList.add(arithmeticException);
        System.out.println(colorsList);
    }

    private static void genericTypes() {

        ArrayList<String> colorsList = new ArrayList<String>();
        // Using generics ensures type safety, allowing only String objects to be added.
        colorsList.add("Red");
        colorsList.add(null);
        colorsList.add("null");
        colorsList.add("Green");
        ArithmeticException arithmeticException = new ArithmeticException("Sample Exception");
        // colorsList.add(arithmeticException);
        colorsList.add(arithmeticException.toString());
        System.out.println(colorsList);

        // Collections do not support primitive types directly.
        // Instead, use wrapper classes like Integer, Double, etc.
        ArrayList<Integer> integersList = new ArrayList<Integer>();
        integersList.add(10);
        integersList.add(20);
        // integersList.add(30.05f);
        integersList.add(null);
        System.out.println(integersList);

        ArrayList<Number> numbersList = new ArrayList<Number>();
        numbersList.add(10);
        numbersList.add(20.5);
        numbersList.add(30.0f);
        numbersList.add(null);
        System.out.println(numbersList);

        // Write an ArrayList to hold meeting objects.
    }
}
