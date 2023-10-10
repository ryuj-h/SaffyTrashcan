package com.ssafy.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ssafy.Car;

public interface CarService {
	public List<Car> selectAll() throws SQLException;
	public Car selectByNumber(String number) throws SQLException;
	public int updateCar(Car car) throws SQLException;
	public int deleteByNumber(String number) throws SQLException;
}
