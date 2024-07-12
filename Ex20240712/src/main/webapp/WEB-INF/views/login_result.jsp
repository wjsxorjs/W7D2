<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_result</title>
</head>
<body>
	<h2>로그인 결과</h2>
	<c:if test="${mvo ne null }">
		<p><strong style="font-size: 20px; font-weight: bold;">${mvo.m_name}</strong>님 환영합니다.</p>
	</c:if>
	<c:if test="${mvo eq null }">
		<p>아이디 또는 비밀번호가 일치하지 않습니다.</p>
	</c:if>
</body>
</html>