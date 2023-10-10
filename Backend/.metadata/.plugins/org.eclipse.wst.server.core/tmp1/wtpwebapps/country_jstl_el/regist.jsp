<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록페이지</title>
</head>
<body>
	<h1>등록 페이지</h1>
	<a href="<%=request.getContextPath()%>/country?action=list">목록으로</a>
	<form action="<%=request.getContextPath() %>/country" method="post">
		<input type="hidden" name="action" value="regist">
		<fieldset>
			<label><input type="text" name="code"> : 코드 </label>
			<br>
			<label><input type="text" name="name"> : 국가명 </label>
			<br>
			<select name="continent">
				<option value="Asia">아시아</option>
				<option value="Europe">유럽</option>
			</select>
			<br>
			<label><input type="number" name="gnp"> : gnp </label>
		</fieldset>
		<button type="submit">등록</button>
	</form>
	
</body>
</html>