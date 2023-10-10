<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가 정보 등록하기</title>
</head>
<body>
	<h1>등록 페이지</h1>
	<a href="<%=request.getContextPath()%>/country?action=list">목록으로</a>
	<form action="<%=request.getContextPath()%>/country" method="POST">
		<input type="hidden" name="action" value="regist">
		<fieldset>
			<label><input type="text" name="code"> : 코드 </label>
			</br>
			<label><input type="text" name="name"> : 국가명 </label>
			</br>
			<select name="continent">
				<option value="Asia">아시아</option>
				<option value="Europe">유럽</option>
				<option value="North America">북아메리카</option>
				<option value="Africa">아프리카</option>
				<option value="Oceania">오세아니아</option>
				<option value="Antarctica">안타티카</option>
				<option value="South America">남아메리카</option>
			</select>
			</br>
			<label><input type="number" name="gnp"> : gnp </label>
		</fieldset>
		<button type="submit">등록</button>
	</form>
</body>
</html>