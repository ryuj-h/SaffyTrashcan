<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.ssafy.Country"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>나라 상세  조회</h1>
    <a href="<%=request.getContextPath()%>/country?action=list">목록으로</a>
    <table>
        <tr>
            <th>나라코드</th>
            <th>국가명</th>
            <th>대륙</th>
            <th>GNP</th>
        </tr>
        <tr>
        <%
        	Country country = (Country) request.getAttribute("country");
        %>
        	<td><%=country.getCode()%></td>
        	<td><%=country.getName()%></td>
        	<td><%=country.getContinent()%></td>
        	<td><%=country.getGnp()%></td>
        </tr>
    </table>
    <a href="<%=request.getContextPath()%>/country?action=mvUpdate&code=<%=country.getCode() %>">수정화면 이동</a>
    <button type="button" onclick="deleteCountry()">삭제</button>
    <script>
    	function deleteCountry() {
    		location.href="<%=request.getContextPath() %>/country?action=delete&code=<%=country.getCode() %>"
    	}
    </script>
</body>
</html>