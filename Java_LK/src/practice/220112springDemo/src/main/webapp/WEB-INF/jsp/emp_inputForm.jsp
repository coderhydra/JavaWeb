<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Input</title>
</head>
<body bgcolor="#f4c2c2"> 
<h3>input form!</h3>
<form action ="/emp/add" method="post">

<div>num: <input type="text" id="no" name="no" value="11"></div> 
<div>name: <input type="text" id="ename" name="ename" value="ename"></div> 
<div>dept: <input type="text" id="dept" name="dept" value="11"></div> 

<button type="submit">save</button>
<button type="reset">cancel</button>
</form>
</body>
</html>
