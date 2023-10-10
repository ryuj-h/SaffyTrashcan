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
			System.out.println("수정 페이지 이동 요청");
			//request.getRequestDispatcher("/regist.jsp");
			
			//1. 수정할 국가의 code값을 파라미터로부터 추출
			String code = request.getParameter("code");
			//2. code값을 통해 기존의 국가 데이터를 DB에서 조회
			
			
			//3. 수정 페이지 반환은 update.jsp로 넘김
			break;
		case "list":
			list(request,response);
			break;
		case "view":
			break;
		case "regist":
			break;
		case "update":
			break;
		case "delete":
			break;
		default:
			
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<Country> list = countryService.selectAll();
		
		request.setAttribute("list", list);
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
