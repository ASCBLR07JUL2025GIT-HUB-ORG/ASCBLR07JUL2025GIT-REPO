package com.demo.exceptions;

public class UnhandledException {
	public static void main(String[] args) {
		// value from some other alien module
		int i = 100;
		System.out.println("divide by zero");
		int result = i / 0;
		System.out.println("abruptly terminated, so this does not execute");
		System.out.println(result);

	}
}
