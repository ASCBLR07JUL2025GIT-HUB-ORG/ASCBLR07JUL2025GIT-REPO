package com.demo.inheritance;

public class MultiLevelInheritance {
	public static void main(String[] args) {
//		A a = new A();
//		a.disp();
		C1 b = new C1();
		b.disp();
		b.test();
	}
}

class A1 {
	public void disp() {
		System.out.println("base or parent or super");
	}
}

class B1 extends A1 {
	//overriding the base class method
	public void disp() {
		System.out.println("derieved or child or sub");
	}
	
	public void test() {
		System.out.println("Hi");
		super.disp();
		disp();
	}
}

class C1 extends B1 {
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