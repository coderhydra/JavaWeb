<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
body{color: white;}
</style>
</head>
<body bgcolor="#664499">
<h1>User List</h1>

<c:forEach var="user" items="${list}">
   <div>${user.num} ${user.name} ${user.phone} ${user.email}</div>
</c:forEach>

</body>
</html>