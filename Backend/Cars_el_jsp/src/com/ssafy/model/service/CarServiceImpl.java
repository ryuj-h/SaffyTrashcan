package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Car;
import com.ssafy.model.dao.CarDao;
import com.ssafy.model.dao.CarDaoImpl;
import com.ssafy.util.DBUtil;

public class CarServiceImpl implements CarService {
	private CarDao carDao = new CarDaoImpl();
	@Override
	public List<Car> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return carDao.selectAll();
	}
	@Override
	public Car selectByNumber(String number) throws SQLException {
		// TODO Auto-generated method stub
		return carDao.selectByNumber(number);
	}
	@Override
	public int updateCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
		return carDao.updateCar(car);
	}
	@Override
	public int deleteByNumber(String number) throws SQLException {
		// TODO Auto-generated method stub
		return carDao.deleteByNumber(number);
	}

}
