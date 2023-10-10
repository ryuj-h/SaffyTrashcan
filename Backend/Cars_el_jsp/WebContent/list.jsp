<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자동차 목록 조회</h1>
	<table>
		<tr>
			<th>number</th>
			<th>model</th>
			<th>price</th>
			<th>brand</th>
		</tr>
		
		<c:forEach var="car" items="${requestScope.list}">
			<tr>
				<td>${car.getNumber()}</td>
				<td>${car.getModel()}</td>
				<td>${car.getPrice()}</td>
				<td>${car.getBrand()}</td>
				<td><a href="${pageContext.request.contextPath}/car?action=view&number=${car.getNumber()}">${car.getModel()}</a></td>
			</tr>
		</c:forEach> 
	</table>
</body>
</html>

