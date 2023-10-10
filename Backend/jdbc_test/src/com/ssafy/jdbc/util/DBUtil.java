package com.ssafy.jdbc.util;

import java.sql.*;

public class DBUtil {
	
	//싱글톤 패턴
	private static DBUtil dbu = new DBUtil();
	
	public static DBUtil Getdbu(){
		return dbu;
	}
	
	private DBUtil(){

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	public Connection getConnection() throws SQLException {
		
		//2. Connection 얻어오기
		String url = "jdbc:mysql://127.0.0.1:3306/world";
		String user =  "ssafy";
		String password = "ssafy";
		return DriverManager.getConnection(url, user, password);
				
				
	}
}
