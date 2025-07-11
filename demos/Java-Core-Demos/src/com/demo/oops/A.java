package com.demo.oops;
import java.lang.Object;
class A
   {
    int i;
    int j;
     A() 
     {
      i = 1;
      j = 2;
       }
    }
   class Output extends Object
   {
    public static void main(String args[])
      {
       A obj1 = new A();
       A obj2 = new A();
       // This checks for identicality by default.
     System.out.print(obj1.equals(obj2));
      }
    }