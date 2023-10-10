<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.Member" %>
<nav>
    <%-- 로그인 하지 않은 경우 메뉴 --%>
    
    <%
        Member memberInfo = (Member)session.getAttribute("memberInfo");
    %>
    <%
        if(memberInfo==null){
    %>
    <ul>
        <li><a href="<%=request.getContextPath()%>/member?action=mvLogin">로그인</a></li>
        <li>회원가입</li>
    </ul>
    <%
        }
        else{
    %>
    <%-- 로그인 한 경우 메뉴 --%>
    <ul>
        <li>님 로그인</li>
        <li>로그아웃</li>
    </ul>
    <%
        }
    %>
</nav>