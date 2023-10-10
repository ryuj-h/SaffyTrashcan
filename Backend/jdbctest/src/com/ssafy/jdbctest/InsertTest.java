package com.ssafy.jdbctest;

import java.sql.*;

public class InsertTest {
	public InsertTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Load Failed");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String id = "hissam";
		String name = "하이쌤";
		String pwd = "9988";
		int cnt = it.register(id,name,pwd);
		if (cnt != 0)
			System.out.println("회원 가입 성공!");
		else
			System.out.println("회원 가입 실패!");
	}
	private int register(String id, String name, String pwd) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		
		//String url = "jdbc:mysql://127.0.0.1:3306/ssafydb";
		//private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
			System.out.println("DB 연결 성공");
			StringBuilder sql = new StringBuilder("insert into ssafy_member(userid,username,userpwd) \n");
			sql.append("values ('"+id +"','"+name +"','"+pwd +"')");
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
}
