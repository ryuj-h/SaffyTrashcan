package com.ssafy.jdbctest;

public class DriverLoadingTest {
	public DriverLoadingTest() {
		//Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Load Failed");
			e.printStackTrace();
		}
	}
	
	//c
	
	//r
	
	//u
	
	//d
	
	public static void main(String[] args) {
		new DriverLoadingTest();
		
	}
}
