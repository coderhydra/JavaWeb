<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 목록보기</title>
<style>
	a{ text-decoration: none;}
</style>
</head>
<body bgcolor="#f4c2c2">
<h3>게시판 목록보기</h3>
<c:forEach var="b" items="${list}">
	<div>${b.num} 
		<a href="bbs?cmd=read&num=${b.num}">${b.title}</a>
		${b.author} ${b.wdate} ${b.hitcount}
	</div>
</c:forEach>
</body>
</html>