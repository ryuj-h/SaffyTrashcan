<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
	<h1>수정 페이지</h1>
	
	<a href="<%=request.getContextPath()%>/country?action=list">목록으로</a>
	
	
	<% Car car = (Car)request.getAttribute("car"); %>
	<form action="<%=request.getContextPath() %>/country" method="post">
		<input type="hidden" name="action" value="update">
		<fieldset>
			<label><input type="text" name="code" value="<%= car.getNumber()%>" readonly> : 번호 </label>
			<br>
			<label><input type="text" name="name" value="<%= car.getBrand()%>"> : 브랜드명 </label>
			<br>
			<label><input type="number" name="gnp" value="<%= car.getPrice()%>"> : 가격 </label>
			<br>
			<label><input type="text" name="name" value="<%= car.getModel()%>"> : 모델명 </label>
			<br>
		</fieldset>
		<button type="submit">수정</button>
	</form>
	<%-- <script>
		document.querySelector("[name=continent]").value="<%=car.getContinent()%>";
	</script> --%>
</body>
</html>