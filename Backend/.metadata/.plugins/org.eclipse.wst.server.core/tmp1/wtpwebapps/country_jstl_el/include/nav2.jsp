<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<%-- 로그인 하지 않은 경우 메뉴 --%>
	<c:choose>
		<c:when test="${ empty sessionScope.memberInfo }">
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/member?action=mvLogin">로그인</a></li>
				<li>회원가입</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li>${memberInfo.memberId}님로그인</li>
				<li><button type="button" onclick="logout()">로그아웃</button></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>
<script>
	function logout() {
		location.href = "${pageContext.request.contextPath}/member?action=logout";
	}
</script>