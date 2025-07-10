package com.demo.exceptions;
import java.lang.Exception;
public class HandledException {
	public static void main(String[] args) {
		// value from some other alien module
		int i = 100;
		int result;
		result = 0;
		System.out.println("divide by zero");
		// The try-catch block is used to handle exceptions gracefully.
		// If an exception occurs, the program will not terminate abruptly,
		// but will instead execute the code in the catch block.
		// The catch block can be used to log the exception or take other actions.
		try {
//			result = i / 0;
			result = i /10;
		}
		// The Exception class is the superclass of all exceptions in Java.
		// It is used to catch any exception that is not caught by a more specific catch block.
		// In this case, it catches the ArithmeticException that occurs when dividing by zero.
		// The catch block is executed when an exception occurs in the try block.
		catch(Exception exception) {
			System.out.println(exception);
			System.out.println(exception.getMessage());
//			System.out.println("abruptly terminated, so this does not execute");
			System.out.println("Gracefully handled.");
		}
		System.out.println(result);
	}
}
