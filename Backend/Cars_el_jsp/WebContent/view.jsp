<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.ssafy.Car"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>차량	 상세 조회</h1>
    <a href="${pageContext.request.contextPath }/car?action=list">목록으로</a>
    <table>
        <tr>
			<th>number</th>
			<th>model</th>
			<th>price</th>
			<th>brand</th>
		</tr>
		<tr>
			<td>${car.getNumber()}</td>
			<td>${car.getModel()}</td>
			<td>${car.getPrice()}</td>
			<td>${car.getBrand()}</td>
		</tr>
    </table>
    <!-- <a href="${pageContext.request.contextPath }/country?action=mvUpdate&code=${country.code}">수정화면 이동</a>
    <button type="button" onclick="deleteCountry()">삭제</button>
    <script>
    	function deleteCountry(){
    		console.log("삭제 메소드 실행");
    		location.href="${pageContext.request.contextPath }/country?action=delete&code=${country.code}";
    	}
    </script> -->
</body>
</html>










