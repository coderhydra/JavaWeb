<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Detail</title>
</head>
<body>
<h3>사원 정보</h3>
<div>${emp.no}</div>
<div>${emp.ename}</div>
<div>${emp.dept}</div>
<div>${emp.salary}</div>

<a href="/emp/edit?no=${emp.no}">edit</a>
</body>
</html>