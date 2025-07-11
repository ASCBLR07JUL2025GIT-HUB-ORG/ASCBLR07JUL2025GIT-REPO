package com.demo.inheritance;

public class SingleInheritance {
	public static void main(String[] args) {
		A a = new A();
		a.disp();
		B b = new B();
		b.disp();
		System.out.println(b.message);
//		 b.test();
	}
}

class A {
	public String message = "welcome";

// defualt constructor
	public A() {
//		super();
		System.out.println("A()");
	}

// parameterized constructor
	public A(String message) {
		System.out.println("A(String message)");
		this.message = message;
	}

	public void disp() {
		System.out.println("base or parent or super");
	}
}

class B extends A {
	public B() {
		super("Java");
		System.out.println("B()");
	}

	// public String message = "good evening";
	// overriding the base class method
	public void disp() {
		super.disp();
		System.out.println(super.message);
		System.out.println("derieved or child or sub");
	}
//	
//	public void test() {
//		System.out.println("Hi");
//		super.disp();
//		//disp();
//	}
}