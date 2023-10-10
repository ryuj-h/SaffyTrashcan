<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setAttribute("root", request.getContextPath());
%>
<c:set var="root" value="${ pageContext.request.contextPath }" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="/include/nav.jsp" %> --%>
	메인 화면
	<br>
	<a href="${requestScope.root}/car?action=list">자동차 목록 조회</a>
	<br>
	<a href="${root}/car?action=mvRegist">자동차 정보 등록 페이지</a>
	<br>
	<a href="${root}/car?action=login">로그인</a>
</body>
</html>