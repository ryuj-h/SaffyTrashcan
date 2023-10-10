package com.ssafy.member.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao boardservice = new MemberDaoImpl();
	//생성자를 private로 만들기
	private MemberDaoImpl() {
		
	}
	//getter 싱글톤 객체 return
	public static MemberDao getBoardservice() {
		return boardservice;
	}
	
	
	@Override
	public void registerMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into member(user_id, user_name, user_password, join_date)\n");
			sql.append("values( ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.setString(4, "sysdate()");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(pstmt,conn);
		}
		
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub

	}

}
