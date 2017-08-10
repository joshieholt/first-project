
package com.example.demo.models;

public class Yeller {
	
	String secretMsg;
	
	public Yeller(String message) {
		secretMsg = message;
	}
	
	public String yell() {
		return secretMsg.toUpperCase();
	}

}
