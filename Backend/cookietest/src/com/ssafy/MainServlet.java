package com.ssafy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("testCookie","안녕하세요");
		cookie.setMaxAge(60*5);//5분
		response.addCookie(cookie);
		response.setCharacterEncoding("text/plain;charset=utf-8");
		response.getWriter().write("응답을 받음");
	}


}
