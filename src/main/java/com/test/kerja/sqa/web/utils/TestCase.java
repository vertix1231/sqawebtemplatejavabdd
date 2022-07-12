package com.test.kerja.sqa.web.utils;

public enum TestCase {
	T1("Register Account"),
	T2("Login Account");
	
	private String TestNama;

	TestCase(String value){
		this.TestNama  = value;
	}
	
	public String getTestNama() {
		return TestNama;
	}
	
	
	
}
