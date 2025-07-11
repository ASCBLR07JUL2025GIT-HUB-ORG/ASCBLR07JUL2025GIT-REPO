package com.demo.inheritance;

public class HierarchialInheritance {
	public static void main(String[] args) {
//		A a = new A();
//		a.disp();
		B11 b = new B11();
		b.disp();
		b.test();
	}
}

class A11 {
	public void disp() {
		System.out.println("base or parent or super");
	}
}

class B11 extends A11 {
	//overriding the base class method
	public void disp() {
		System.out.println("derieved or child or sub");
	}
	
	public void test() {
		System.out.println("Hi");
		super.disp();
		//disp();
	}
}

class C11 extends A11 {
	//overriding the base class method
	public void disp() {
		System.out.println("derieved or child or sub");
	}
	
	public void test() {
		System.out.println("Hi");
		super.disp();
		//disp();
	}
}