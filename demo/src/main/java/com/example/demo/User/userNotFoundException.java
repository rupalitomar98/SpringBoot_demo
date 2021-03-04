package com.example.demo.User;

public class userNotFoundException extends Exception {
	public userNotFoundException(String message) {
		super(message +" Not found in the record!!");
	}
}
