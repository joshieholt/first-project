
package com.example.demo.models;

public class Whisperer {
	
	String secretMsg;
	
	public Whisperer(String message) {
		secretMsg = message;
	}
	
	public String whisper() {
		return secretMsg.toLowerCase();
	}
}
