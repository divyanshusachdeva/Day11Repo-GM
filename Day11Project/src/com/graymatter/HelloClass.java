package com.graymatter;

public class HelloClass {

	public String sayHello() {
		return "Hello";
	}
	
	public static void main(String[] args) {

		HelloClass hc = new HelloClass();
		System.out.println(hc.sayHello());
		
	}

	public int add(int a, int b) {
		return a+b;
		
		
	}
	
}
