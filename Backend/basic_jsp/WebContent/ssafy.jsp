<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
String name = null;

public void init(){
	System.out.println("init 실행");
	name ="이름";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello SSAFY!!!</h3>
	<h3>안녕</h3>
	<h1> 안녕하세요 <%out.println(name); %> 님!</h1>
	<h1> 안녕하세요 <%= name %> 님!</h1>
</body>
</html>