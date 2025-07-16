package com.demo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayListEx {
   public static void main(String[] args) {
//        rawTypes();
//        genericTypes();
//        compatibilityRawAndGeneric();
//        workingWithArrayList();
       arrayListOfObjects();
   }

   private static void arrayListOfObjects() {
       ArrayList<Object> objectArrayList = new ArrayList<Object>();
       objectArrayList.add("Welcome");
       Integer integer = 500;
       objectArrayList.add(integer);
       objectArrayList.add(true);
       objectArrayList.add(55.5f);
       System.out.println(objectArrayList);
   }

   private static void workingWithArrayList() {
       List<String> shoppingCartList = new ArrayList<String>();
//        methods from Collection interface
       shoppingCartList.add("Man's Search For Meaning"); //0
       shoppingCartList.add("Start With Why"); //1
       shoppingCartList.add("Java"); //2
       shoppingCartList.add("Start With Why"); //3
       shoppingCartList.add("Deep Work"); //4
       shoppingCartList.set(1,"Man's Search For Meaning");
       System.out.println("1 :  " + shoppingCartList.get(3));
       System.out.println(shoppingCartList);
//        shoppingCartList.remove("Start With Why");
       shoppingCartList.remove(3);
       System.out.println(shoppingCartList);
       shoppingCartList.add(null);
       shoppingCartList.add(null);
       System.out.println(shoppingCartList);
       for(String item : shoppingCartList) {
           System.out.println(item);
       }
       System.out.println(shoppingCartList.size());
//        shoppingCartList.clear();
//        System.out.println(shoppingCartList.size());

       List<String> removeItemsList = new ArrayList<String>();
//        methods from Collection interface
       removeItemsList.add("Man's Search For Meaning");
       removeItemsList.add("Deep Work");
       removeItemsList.add(null);

       shoppingCartList.removeAll(removeItemsList);
       System.out.println(shoppingCartList);
   }

   private static void compatibilityRawAndGeneric() {
       ArrayList rawArrayList = new ArrayList<String>();
       rawArrayList.add(5);
       ArithmeticException arithmeticException = new ArithmeticException();
       rawArrayList.add(arithmeticException);

       List<Integer> secondList = rawArrayList;
       System.out.println(secondList);

//        ArrayList<String> rawArrayList1 = new ArrayList<String>();
//        rawArrayList1.add(5);
//        rawArrayList1.add(arithmeticException);
   }

   private static void rawTypes() {;
       //        Raw types
//        Dynamic polymorphism
       List colors = new ArrayList();
       colors.add("Green");
       ArithmeticException arithmeticException = new ArithmeticException();
       colors.add(arithmeticException);
       System.out.println(colors);
       colors = new Stack();
   }
   private static void genericTypes() {
       // Generic types with type safety
       List<String> colors = new ArrayList<String>();
       colors.add("Green");
       ArithmeticException arithmeticException = new ArithmeticException();
//        colors.add(arithmeticException);
       System.out.println(colors);
//        colors = new Stack();
   }
}
