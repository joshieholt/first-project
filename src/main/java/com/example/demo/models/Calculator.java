
package com.example.demo.models;

public class Calculator {

	double num1;
	double num2;
	String operation = "";
	
	public Calculator(double first, double second, String whichOperation) {
		num1 = first;
		num2 = second;
		operation = whichOperation;
	}
	
	public double calculate() {
		double result = 0;
		if (operation.equals("add")) {
			result = num1 + num2;
		}
		else if (operation.equals("subtract")) {
			result = num1 - num2;
		}
		else if (operation.equals("multiply")) {
			result = num1 * num2;
		}
		else if (operation.equals("divide")) {
			result = num1 / num2;
		}
		else if (operation.equals("modulo")) {
			result = num1 % num2;
		}
		else if (operation.equals("exponent")) {
			result = Math.pow(num1, num2);
		}
		return result;
	}

	
}