<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit</title>
</head>
<body>
<h3>edit</h3>
<form action="submit" method="post">
<div>num: ${emp.no} </div>
<div>name:<input type="text" id="ename" name="ename" value="${emp.ename}" readonly/></div>
<div>dept:<input type="text" id="dept" name="dept" value="${emp.dept}"/></div>
<div>salary:<input type="text" id="salary" name="salary" value="${emp.salary}"/></div>

<button type="submit">save</button>
<button type="reset">cancel</button>

</form>
</body>
</html>