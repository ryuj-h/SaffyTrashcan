package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.Country;
import com.ssafy.Member;
import com.ssafy.model.service.CountryService;
import com.ssafy.model.service.CountryServiceImpl;


@WebServlet("/country")
public class CountryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private CountryService countryService = new CountryServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "":
				break;
			default:	
				response.getWriter().write("wrong request");
				
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write("Internal Server Error");
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 요청");
		//1. 아이디 비밀번호 추출
		String memberId = request.getParameter("memberId");
		
		String password = request.getParameter("password");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setPassword(password);
		
		
		
		//2. DB에 해당 멤버 조회
		Member memberInfo = memberService.login(member);
		
		if (memberInfo !=null) {
			//3. 해당 멤버가 존재한다면 세션에 유저 정보 저장
			System.out.println("로그인한 유저의 정보 : " + memberInfo);
			HttpSession session = request.getSession();
			session.setAttribute("memberInfo", memberInfo);
			//4. index.jsp로 요청을 넘김
			
			
			response.sendRedirect(request.getContextPath());
		}else {
			//로그인 실패
			System.out.println("로그인 실패");
			
			response.sendRedirect(request.getContextPath());
		}
		
		
		//3. 해당 멤버가 존재한다면 세션에 유저 정보 저장
		
		//4. index.jsp로 요청을 넘김
		
	}
}
