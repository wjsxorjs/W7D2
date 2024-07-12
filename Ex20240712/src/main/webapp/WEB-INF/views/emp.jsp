<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp</title>
<style>
 table, thead, tbody, tr, th, td{
 	border: 1px solid #000;
 	border-collapse: collapse;
 }
  
 thead{
 	border: 1px solid #000;
 }
  
 th, td{
 	padding: 5px;
 }
 
 th{
	border-right: 1px solid #fff;
 	background: rgb(40,40,40);
 	color: rgb(175,175,175);
 }
 
 th:last-child {
	border-right: 1px solid #000;
 }
 
 
 
</style>
</head>
<body>
	<h2>사원 테이블</h2>
	<form action="emp" method="post">
		사번:<input type="text" name="empno"/>
		<button type="submit">검색</button>
	</form>
	<hr/>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직종</th>
				<th>부서</th>				
			</tr>
		</thead>
		<tbody>
	<c:if test="${e_list ne null }">
		<c:forEach var="evo" items="${e_list }">
			<tr>
				<td>${evo.empno }</td>
				<td>${evo.ename }</td>
				<td>${evo.job }</td>
				<td>${evo.dname }</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${e_list eq null }">
		<tr>
			<td colspan="4">${e_list}사원이 존재하지 않습니다.</td>
		</tr>
	</c:if>
		</tbody>
	</table>
</body>
</html>