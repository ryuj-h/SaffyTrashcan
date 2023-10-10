package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryController
 */
@WebServlet("/country")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		switch(action) {
		case "mvRegist":
			request.getRequestDispatcher("/regist.jsp");
			break;
		case "mvUpdate":
			request.getRequestDispatcher("/regist.jsp");
			break;
		case "list":
			break;
		case "view":
			break;
		case "regist":
			break;
		case "update":
			break;
		case "delete":
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Post 요청 시 한글 파라미텅 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
