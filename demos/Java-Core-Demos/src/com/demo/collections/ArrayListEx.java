package com.demo.collections;

import java.lang.reflect.Array;
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

        numbersList.add(20.5);
        numbersList.add(30.0f);
        numbersList.add(null);

        // 10 is an int but it is autoboxed to Integer
        // Boxing converts primitive types to their corresponding wrapper classes.
        int primitiveInt = 10;
        // Explicitly boxing to Integer by using Integer.valueOf()
        Integer boxedInt = Integer.valueOf(primitiveInt);
        numbersList.add(Integer.valueOf(primitiveInt)); // Boxing to Integer
        numbersList.add(primitiveInt); // Autoboxing to Integer
        numbersList.add(boxedInt);
        System.out.println(numbersList);
        // Write an ArrayList to hold meeting
    }

    public static void workingWithArrayList() {
        ArrayList<String> shoppingCartList = new ArrayList<String>();
        // methods from Collection interface
        shoppingCartList.add("Man's Search For Meaning"); //0
        shoppingCartList.add("Start With Why"); //1
        shoppingCartList.add("JaVa"); //2
        shoppingCartList.add("Start With Why"); //3 
        shoppingCartList.add("Deep Work"); //4
        // The set method replaces the element at the specified position
        // with the specified element and returns the old element.
        shoppingCartList.set(1,"Start With Why - Updated");
        System.out.println("1 :  " + shoppingCartList.get(3));
        shoppingCartList.remove(3) ; // Removes the element at index 3
        System.out.println(shoppingCartList);
        shoppingCartList.add(null); // Adding null elements
        shoppingCartList.add(null); // Adding another null element
        System.out.println(shoppingCartList);

        for(String item: shoppingCartList) {
            System.out.println(item); // Iterating through the list
        }

        System.out.println("Size of shopping cart: " + shoppingCartList.size());

        ArrayList<String> removeItemsList = new ArrayList<String>();
        removeItemsList.add(null);
        removeItemsList.add("Deep Work");
        removeItemsList.add("Start With Why");
        removeItemsList.add("Java");

        // Removes all elements in removeItemsList from shoppingCartList
        shoppingCartList.removeAll(removeItemsList);
        System.out.println("After removing items: " + shoppingCartList);
    }   
}
