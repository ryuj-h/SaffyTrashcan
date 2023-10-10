package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.Member;

public interface MemberDao {
	Member login(Member member)throws SQLException;
}
