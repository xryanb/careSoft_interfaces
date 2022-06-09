package com.caresoft.clinicapp;

public class User {
	protected Integer id;
	protected int pin;
	
	public User () {}
	
	public User(int id) {
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public void setPin(int p) {
		this.pin=p;
	}
}
