<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.ssafy.Country"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>나라 상세 조회</h1>
    <a href="${pageContext.request.contextPath }/country?action=list">목록으로</a>
    <table>
        <tr>
            <th>나라코드</th>
            <th>국가명</th>
            <th>대륙</th>
            <th>GNP</th>
        </tr>
		<tr>
			<td>${country.code}</td>
			<td>${country.name}</td>
			<td>${country.continent}</td>
			<td>${country.gnp}</td>
		</tr>
    </table>
    <a href="${pageContext.request.contextPath }/country?action=mvUpdate&code=${country.code}">수정화면 이동</a>
    <button type="button" onclick="deleteCountry()">삭제</button>
    <script>
    	function deleteCountry(){
    		console.log("삭제 메소드 실행");
    		location.href="${pageContext.request.contextPath }/country?action=delete&code=${country.code}";
    	}
    </script>
</body>
</html>










