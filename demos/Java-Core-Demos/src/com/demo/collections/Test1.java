package com.demo.collections;

import java.util.*;
public class Test1{
   public static void main(String a[]){
     Set s = new TreeSet();
     s.add(new Person(20));
     s.add(new Person(10));
     System.out.println(s);
   }
}
class Person{
   Person(int i){}
}