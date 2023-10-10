package com.ssafy.board.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.util.DBUtil;

public class BoardDao {
	private static DBUtil dbUtil = DBUtil.Getdbu();    
	
	public List<BoardDto> searchListAll() throws SQLException {
        //1. sql 작성
        String sql = "select * from board";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            //2. DB 연결
            conn = dbUtil.getConnection();
            
            //3. 쿼리 실행
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            //4. 조회 결과 파싱
            List<BoardDto> list = new ArrayList<>();
            while(rs.next()) {
                int articleNo = rs.getInt("article_no");
                String userId = rs.getString("user_id");
                String subject = rs.getString("subject");
                String content = rs.getString("content");
                int hit = rs.getInt("hit");
                String resgisterTime = rs.getString("register_time");
                
                //int articleNo, String userId, String subject, String content, int hit, String registerTime
                BoardDto boardDto = new BoardDto(articleNo,userId,subject,content,hit,resgisterTime);
                		//(articleNo, userId, subject, content, resgisterTime);
                list.add(boardDto);
            }
            return list;
            
        } finally {
            //5. 자원 반납
        	if (rs != null)
        		rs.close();
        	if (pstmt != null)
        		pstmt.close();
        	if (conn != null)
        		conn.close();
        }
    }
	
    public void registerArticle(BoardDto boardDto) throws SQLException {
        //1. sql 작성
        String sql = "insert into board\r\n" + 
                "( user_id, subject, content )\r\n" + 
                "values\r\n" + 
                "( ? , ? , ?)";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //2. DB 연결
            conn = dbUtil.getConnection();
            
            //3. 쿼리 실행
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardDto.getUserId());
            pstmt.setString(2, boardDto.getSubject());
            pstmt.setString(3, boardDto.getContent());
            pstmt.executeUpdate();
        } finally {
            //4. 자원 반납
        	if (pstmt != null)
        		pstmt.close();
        	if (conn != null)
        		conn.close();
        }
    }
}
