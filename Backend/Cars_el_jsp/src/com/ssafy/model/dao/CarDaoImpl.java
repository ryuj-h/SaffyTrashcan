package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.Car;
import com.ssafy.util.DBUtil;

public class CarDaoImpl implements CarDao {

	private DBUtil dbUtil = DBUtil.getInstance();
	@Override
	public List<Car> selectAll() throws SQLException {
		

		String sql = "select *\r\n" + 
				"from car";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//2. DB와 연결
			conn = dbUtil.getConnection();
			
			//3. sql 실행
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//4. 조회 데이터 파싱
			List<Car> list = new ArrayList<>();
			while(rs.next()) {
				String number = rs.getString("number");
				String model = rs.getString("model");
				int price = rs.getInt("price");
				String brand = rs.getString("brand");
				
				Car country = new Car(number, model, price, brand);
				list.add(country);
			}
			return list;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	@Override
	public Car selectByNumber(String number) throws SQLException {
		String sql = "select *\r\n" + 
				"from car\r\n" + 
				"where number = ?";
		try (
				//2. DB연결
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, number);
			try(
					//3. 쿼리 실행
					ResultSet rs = pstmt.executeQuery();
					){
				
				//4. 조회 결과 파싱
				if(rs.next()) {
					//String number = rs.getString("number");
					String model = rs.getString("model");
					int price = rs.getInt("price");
					String brand = rs.getString("brand");

					Car car = new Car(number, model, price, brand);
					return car;
				}
				return null;
			}
		}
	}
	@Override
	public int updateCar(Car car) throws SQLException {//1. sql 작성
		String sql = "update car\r\n" + 
				"set model=?, price=?, brand=?\r\n" + 
				"where number=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//2. DB 연결
			conn = dbUtil.getConnection();
			
			//3. 쿼리 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getModel());
			pstmt.setInt(2, car.getPrice());
			pstmt.setString(3, car.getBrand());
			pstmt.setString(4, car.getNumber());
			int cnt = pstmt.executeUpdate();
			
			return cnt;
		} finally {
			//4. 자원 반납
			dbUtil.close(pstmt, conn);
		}
	}
	@Override
	public int deleteByNumber(String number) throws SQLException {		//1. 쿼리문 작성
		String sql = "delete from car\r\n" + 
				"where number = ?";
		
		try( 
				//2. db 연결
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
			//3. 쿼리 실행
			pstmt.setString(1, number);
			int cnt = pstmt.executeUpdate();
			
			return cnt;
		} 
	}

}
