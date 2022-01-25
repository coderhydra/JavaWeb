<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   response.setHeader("Cache-Control","no-store"); 
   response.setHeader("Pragma","no-cache"); 
   response.setDateHeader("Expires",0); 
   if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>emp.jsp</title>
</head>
<body bgcolor="#f4c2c2"> 
<h1>gugu.jsp</h1>
<p>
<!-- 영역에 들어가면 EL -->
<div>${emp.num }</div>
<div>${emp.name }</div>
<div>${emp.title }</div>
<div>${emp.salary }</div>
<a href="/">[Main]</a>
</body>
</html>