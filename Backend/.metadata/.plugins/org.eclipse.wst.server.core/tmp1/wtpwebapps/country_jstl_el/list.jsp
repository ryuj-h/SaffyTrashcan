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
	<h1>나라 목록 조회</h1>
	<table>
		<tr>
			<th>나라코드</th>
			<th>국가명</th>
			<th>대륙</th>
			<th>GNP</th>
		</tr>
		<c:forEach var="country" items="${requestScope.list}">
			<tr>
				<td>${country.getCode()}</td>
				<td><a href="${pageContext.request.contextPath}/country?action=view&code=${country.code}">${country.name}</a></td>
				<td>${country.continent}</td>
				<td>${country.gnp}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

