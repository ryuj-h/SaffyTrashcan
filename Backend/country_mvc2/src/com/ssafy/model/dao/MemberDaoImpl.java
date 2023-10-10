package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.Member;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private DBUtil dbUtill = DBUtil.getInstance();
	@Override
	public Member login(Member member) throws SQLException {
		// 1. sql 작성
		String sql = "select member_id, name, register_date \r\n"
				+ "from member \r\n"
				+ "where member_id = ? and password = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 2. DB 연결
		
		try {
			conn = dbUtill.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberId());
			rs= pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String registerDate = rs.getNString("register_date");
				
				Member loginMember = new Member(member.getMemberId(),
						null,
						name,
						registerDate);
			}
		}finally {
			
		}
		
		// 3. 쿼리 실행
		
		// 4. 조회 결과 파싱
		
		// 5. 자원 반납
		
		
		return null;
	}

}
