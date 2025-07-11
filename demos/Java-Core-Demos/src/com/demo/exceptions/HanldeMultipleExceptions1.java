package com.demo.exceptions;
public class HanldeMultipleExceptions1 {
    public static void main(String[] args) {
        String colors[] = {"Red","Green","Blue"};
        Calculator1 calculator1 = null;
        System.out.println("Normal Calculator");
        try {
            for (int i = 0; i <= 3; i--) {
                System.out.println(colors[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
        {
            try {  calculator1.add(50, 50);  }
            catch(NullPointerException nullPointerException){
                System.out.println("Instantiate the calculator....");
            }
            System.out.println("Check index...");
        }
        System.out.println("Thankyou!");
    }
}
