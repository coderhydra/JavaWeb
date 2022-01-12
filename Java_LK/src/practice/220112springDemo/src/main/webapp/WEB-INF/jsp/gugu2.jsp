<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>index.jsp</title>
</head>
<body bgcolor="#f4c2c2">
<h1>gugu.jsp</h1>
<p>
<!-- 영역에 들어가면 EL -->
<h1>gugudan view</h1> 
<c:forEach var="line" items="${res}">
<div>${line}</div>
</c:forEach>
<a href="/">[Main]</a>
</body>
</html>