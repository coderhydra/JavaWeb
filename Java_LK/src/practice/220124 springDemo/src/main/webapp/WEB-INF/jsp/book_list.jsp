<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서 목록</title>
<style>
body {color: white;}
 a{text-decoration: none; color: white;}
</style>
</head>
<body bgcolor ="#664499">
<h3>도서 목록</h3>
<c:forEach var="book" items="${list}">
	<div><a href="/shop/book/detail/${book.no}">${book.no} ${book.title} ${book.price} ${book.pub} ${book.pubdate}</a></div>
</c:forEach>
</body>
</html>