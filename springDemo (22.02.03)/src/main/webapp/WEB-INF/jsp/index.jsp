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
<title>index.jsp</title>
</head>
<body bgcolor="#f4c2c2">
<h1>index.jsp</h1>
<%
   String msg = "Hello World"; // 한글도 가능
%>
<%= msg %>
<p>
<!-- 영역에 들어가면 EL -->
${data} 

<a href="/emp">[EMP]</a>
<a href="/gugu">[gugu]</a>

<form onsubmit="/gugu2">
<div>dan: <input id="dan" name="dan"/></div>
<button type="onsubmit">gugu</button>
<div>
<a href="/user/login">[EMP]</a>
</div>
</form>

</body>
</html>