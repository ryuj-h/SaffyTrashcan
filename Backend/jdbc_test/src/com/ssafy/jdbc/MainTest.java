package com.ssafy.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.jdbc.model.CountryDao;

import jdbc_test.Country;

public class MainTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		CountryDao countryDao = new CountryDao();
		List<Country>list = countryDao.selectAll();
		
		for(Country cty : list) {
			System.out.println(cty);
		}
		
		
		Country country = new Country("DDD", "나라2","Asia",3333);
		int cnt = countryDao.insertCountry(country);
		System.out.println("cnt : "+ cnt);
	}

}
