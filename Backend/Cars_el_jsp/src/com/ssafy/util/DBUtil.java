package com.ssafy.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * mysql 드라이버 클래스 로딩
 * 
 * Connection 객체 반환 기능
 * 
 * @author SSAFY
 *
 */
public class DBUtil {

	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	//싱글톤 패턴
	//1. 생성자 막기
	//2. 인스턴스 생성
	//3. 인스턴스 반환하는 메소드 만들기
	private DBUtil(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static DBUtil instance = new DBUtil();
	public static DBUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/train";
		String user = "ssafy";
		String password = "ssafy";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(AutoCloseable...autoCloseables) {
		for(AutoCloseable obj : autoCloseables) {
			if(obj!=null)
				try {
					obj.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
