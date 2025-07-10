package com.demo.exceptions;

class Test1 {
	int value = 10;
}

public class NestedTryBlock {
	public static void main(String[] args) {
//		m1();
//		m2();
		try {
			m3();
		}
		catch(ArithmeticException a) {
			System.out.println("Caught you, how can you escape?");
		}
		System.out.println("Hurray, handled the exception");
	}

	private static void m1() {
		Test1 test = null;
		test = new Test1();
		try {
			System.out.println("outer try begin");
			System.out.println(test.value);
			try {
				int i = 200;
				int j = 10;
				int result = i / j;
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("Arithmetic problem");
			}
			System.out.println("outer try end");
		} catch (NullPointerException e) {
			System.out.println("Test instance not created");
		}
	}
	private static void m2() {
		Test1 test = null;
		test = new Test1();
		try {
			System.out.println("outer try begin");
			System.out.println(test.value);
			try {
				int i = 200;
				int j = 0;
				int result = i / j;
				System.out.println(result);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Arithmetic problem");
			}
			System.out.println("outer try end");
		} catch (NullPointerException | ArithmeticException e) {
			System.out.println("Test instance not created");
		}
	}
	private static void m3() {
		Test1 test = null;
		test = new Test1();
		try {
			System.out.println("outer try begin");
			System.out.println(test.value);
			try {
				int i = 200;
				int j = 0;
				int result = i / j;
				System.out.println(result);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Arithmetic problem");
			}
			System.out.println("outer try end");
		} catch (NullPointerException  e) {
			System.out.println("Test instance not created");
		}
	}
}