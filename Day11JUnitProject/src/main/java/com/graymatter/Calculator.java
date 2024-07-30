package com.graymatter;

public class Calculator {
	
	Calculator calc = new Calculator();

	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int sub(int a, int b) {
		return a-b;
	}
	
	public static int mul(int a, int b) {
		return a*b;
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
	
	public static boolean isEven(int a) {
		if(a%2==0)
			return true;
		return false;
	}
	
	public static int[] arrayEquals(int a[]) {
		return a;
	}
	
	public static String checkString() {
		String str = null;
		return str;
	}
	
	public static Student createStudent() {
		return new Student(110, "Divyanshu", 21);
	}
	
	public static void main(String[] args) {
		
	}

}
