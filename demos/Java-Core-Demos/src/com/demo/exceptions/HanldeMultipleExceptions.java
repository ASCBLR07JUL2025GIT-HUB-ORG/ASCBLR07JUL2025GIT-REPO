package com.demo.exceptions;

public class HanldeMultipleExceptions {
    public static void main(String[] args) {
        // The datatype is String
        // The array is colors
        // An array is a collection of elements of the same type.
        // The array is initialized with three elements: "Red", "Green", and "Blue
        String colors[] = {"Red","Green","Blue"};
        Calculator calculator = null;
        System.out.println("Normal Calculator");
        try {
            for (int i = 0; i <= 3; i--) {
                System.out.println(colors[i]);
            }
        }
//        System.out.println("compile time error!");
//      IP one catch block for handling both the exceptions
//        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
//        {   calculator.add(50, 50);
//            System.out.println("Check index...");
//        }
//        catch(NullPointerException nullPointerException){
//            System.out.println("Instantiate the calculator....");
//        }

        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
        {
            try {
                calculator.add(50, 50);
            }
            catch(NullPointerException nullPointerException){
                System.out.println("Instantiate the calculator....");
            }
            System.out.println("Check index...");
        }
        System.out.println("Thankyou!");
    }
}
