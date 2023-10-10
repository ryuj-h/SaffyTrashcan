package com.ssafy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDto;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDao boarddao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 파라미터 추출
		
		
		request.setCharacterEncoding("utf-8");
		
		//1. 요청 파라미터 추출
		String userId = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardDto boardDto = new BoardDto();
		boardDto.setUserId(userId);
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		
		
		//2. DB로부터 해당 글 정보 조회
		
		try {
			List <BoardDto> list = boarddao.searchListAll();
		
			for(BoardDto board: list) {
				System.out.println(board);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		//3. 상세 페이지 반환
	}
}
