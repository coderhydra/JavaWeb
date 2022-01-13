<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Book Detail</title>
<style>
body {color: white;}
</style>
</head>
<body bgcolor="#664499">

<h3>Book Detail</h3>

<div>num: ${detail.no}</div>
<div>title: ${detail.title} </div>
<div>price: ${detail.price} </div>
<div>pub: ${detail.pub} </div>
<div>pubdate: ${detail.pubdate}</div>

<form id="bag" action="" method="get">
<div>how?<input type= "text" id="" name="" value="3"/></div>
<button type="submit">go</button>
<select><option>1<option>2<option>3</select>
</form>

</body>
</html>