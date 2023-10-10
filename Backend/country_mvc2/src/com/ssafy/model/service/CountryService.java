package com.ssafy.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.Country;

public interface CountryService {
    
    //전체 정보 조회
    public List<Country> selectAll() throws SQLException;
    
    
    //2. 나라정보 추가
    public int insertCountry( Country country ) throws SQLException;
    
    
    //3. 나라정보 수정
    public int updateCountry( Country country ) throws SQLException;
    
    //4. 나라정보 삭제
    public int deleteByCode( String code ) throws SQLException;
    
    //5. 상세 조회 버전 2
    public Country selectByCode2(String code) throws SQLException;
}
