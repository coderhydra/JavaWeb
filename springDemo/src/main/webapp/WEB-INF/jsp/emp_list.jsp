<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사원정보 리스트</title>
</head>
<body>
<h3>사원 정보 리스트</h3>
<c:forEach var="emp" items="${list}">
<div><a href="/emp/detail?no=${emp.no}">${emp.no} ${emp.ename} ${emp.dept}</a></div>
</c:forEach>

</body>
</html>