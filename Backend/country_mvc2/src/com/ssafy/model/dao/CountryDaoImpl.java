package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.Country;
import com.ssafy.util.DBUtil;

public class CountryDaoImpl implements CountryDao {

    private DBUtil dbUtil = DBUtil.getInstance();
    
    
    //1. 전체 나라정보 조회
    public List<Country> selectAll() throws SQLException{
    	
        //1. sql 작성
        String sql = "select *\r\n" + 
                "from country";
        
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
            List<Country> list = new ArrayList<>();
            while(rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String continent = rs.getString("continent");
                double gnp = rs.getDouble("gnp");
                
                Country country = new Country(code, name, continent, gnp);
                list.add(country);
            }
            return list;
        } finally {
            //5. 자원 반납
//            if(rs!=null) rs.close();
//            if(pstmt!=null) pstmt.close();
//            if(conn!=null) conn.close();
            dbUtil.close(rs, pstmt, conn);
        }
    }
    
    
    //2. 나라정보 추가
    public int insertCountry( Country country ) throws SQLException{
        
        //1. sql 작성
        String sql = "insert into country\r\n" +
                "(code, name, continent, gnp)\r\n" + 
                "values\r\n" + 
                "( ? , ? , ?, ? )";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //2. DB 연결
            conn = dbUtil.getConnection();
            
            //3. 쿼리 실행
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, country.getCode() );
            pstmt.setString(2, country.getName() );
            pstmt.setString(3, country.getContinent() );
            pstmt.setDouble(4, country.getGnp() );
            int cnt = pstmt.executeUpdate();
            
            return cnt;
        } finally {
            //4. 자원 반납
            dbUtil.close(pstmt, conn);
        }
    }
    
    
    //3. 나라정보 수정
    public int updateCountry( Country country ) throws SQLException {
        //1. sql 작성
        String sql = "update country\r\n" + 
                "set name=?, continent=?, gnp=?\r\n" + 
                "where code=?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //2. DB 연결
            conn = dbUtil.getConnection();
            
            //3. 쿼리 실행
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, country.getName() );
            pstmt.setString(2, country.getContinent() );
            pstmt.setDouble(3, country.getGnp());
            pstmt.setString(4,  country.getCode());
            int cnt = pstmt.executeUpdate();
            
            return cnt;
        } finally {
            //4. 자원 반납
            dbUtil.close(pstmt, conn);
        }
    }
    
    
    //4. 나라정보 삭제
    public int deleteByCode( String code ) throws SQLException {
        //1. 쿼리문 작성
        String sql = "delete from country\r\n" + 
                "where code = ?";
        
        try( 
                //2. db 연결
                Connection conn = dbUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            
            //3. 쿼리 실행
            pstmt.setString(1, code);
            int cnt = pstmt.executeUpdate();
            
            return cnt;
        } 
    }
    
    //5. 상세 조회(try with resource)
    public Country selectByCode(String code) throws SQLException {
        //1. sql 작성
        String sql = "select *\r\n" + 
                "from country\r\n" + 
                "where code = ?";
        try (
                //2. DB연결
                Connection conn = dbUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setString(1, code);
            try(
                    //3. 쿼리 실행
                    ResultSet rs = pstmt.executeQuery();
                    ){
                
                //4. 조회 결과 파싱
                if(rs.next()) {
                    String name = rs.getString("name");
                    String continent = rs.getString("continent");
                    double gnp = rs.getDouble("gnp");
                    
                    Country country = new Country(code, name, continent, gnp);
                    return country;
                }
                return null;
            }
        }
    }
    
    //5. 상세 조회 버전 2
    public Country selectByCode2(String code) throws SQLException {
        //1. sql 작성
        String sql = "select *\r\n" + 
                "from country\r\n" + 
                "where code = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            //2. DB 연결
            conn = dbUtil.getConnection();
            //3. 쿼리 실행
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            
            //4. 조회 결과 파싱
            if(rs.next()) {
                String name = rs.getString("name");
                String continent = rs.getString("continent");
                double gnp = rs.getDouble("gnp");
                
                Country country = new Country(code, name, continent, gnp);
                return country;
            }
            return null;
        } finally {
            dbUtil.close(rs, pstmt, conn);
        }
    }
}
