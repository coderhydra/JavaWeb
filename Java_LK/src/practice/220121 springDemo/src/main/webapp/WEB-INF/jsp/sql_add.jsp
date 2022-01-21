<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User Input Form</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script>
function add(){
	var name = $('#name').val();
	var phone = $('#phone').val();
	var email = $('#email').val();
	if( name=='' ||	phone=='' || email==''){
		alert("plz check all input");
		return false;
	}
	var serData = $("#user_input").serialize();
	$.ajax({
	url:'/user/add',
	method:'post',
	cache:false,
	data:serData,
	dataType:'text',
	success: function (res){
		alert(res?"save sucess":"save fail");
	},
	error: function (xhr,status, err){
		alert("error:"+err);
	}
	});
	return false;
}
</script>
<style>
body {color:white;}
</style>
</head>
<body bgcolor="#664499">
<h1>User Input Form</h1>
   <form id="user_input" onsubmit="return add();">
name<input type="text" id="name" name="name" value="test"/><br>
phone<input type="text" id="phone" name="phone"value="000-000-0000"/><br>
email<input type="text" id="email" name="email" value="test@la.com"/>
<br>
<button type="submit">update</button>
</form>
</body>
</html>