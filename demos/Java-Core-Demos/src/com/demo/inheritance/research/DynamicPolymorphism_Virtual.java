package com.demo.inheritance.research;

public class DynamicPolymorphism_Virtual {
	public static void main(String[] args) {
		B b = null;
		if(Math.random() > 0.5)
		{
			b = new D();
		}
		else {
			b = new E();
		}
		b.m();
	}
}

class B {
	public void m() {
		System.out.println("virtual method");

	}
}

class D extends B {
//	public void m() {
//		System.out.println("virtual method");
//
//	}
	@Override
	public void m() {
		System.out.println("D actual method");

	}
}
class E extends B {
//	public void m() {
//		System.out.println("virtual method");
//
//	}
	@Override
	public void m() {
		System.out.println("E actual method");

	}
}