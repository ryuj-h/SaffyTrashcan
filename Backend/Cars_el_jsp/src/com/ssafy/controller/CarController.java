package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.Car;
import com.ssafy.model.service.CarService;
import com.ssafy.model.service.CarServiceImpl;


@WebServlet("/car")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarService carService = new CarServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String action  = request.getParameter("action");

		try {
			switch (action) {
			case "list":
				list(request, response);
				break;
			case "view":
				view(request,response);
				break;
			default : 
				response.getWriter().write("<h1>wrong request</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("Internal Server Error");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("전체 목록 조회 요청 수신");
		List<Car> list = carService.selectAll();

		for(Car car : list) {
			System.out.println(car.toString());
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("상세 목록 조회 요청 수신");
		
		System.out.println("상세 조회 요청 수신");
		//1. code 정보 추출
		String number = request.getParameter("number");
		System.out.println("조회할 코드명 : "+number);
		
		//2. code 정보를 통해 상세국가 정보 조회
		Car car = carService.selectByNumber(number);
		
		//3. Country정보와 함께 view.jsp로 포워딩
		request.setAttribute("car", car);
		request.getRequestDispatcher("/view.jsp").forward(request, response);
	}
}
