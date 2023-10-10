package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Car;

public interface CarDao {
	public List<Car>selectAll() throws SQLException;
	public Car selectByNumber(String number) throws SQLException;
	public int updateCar(Car car) throws SQLException;
	public int deleteByNumber(String number) throws SQLException;
}
