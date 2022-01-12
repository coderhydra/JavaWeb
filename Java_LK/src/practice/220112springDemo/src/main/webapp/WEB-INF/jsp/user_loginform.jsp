<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login form</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script>
  function login() {
		   var uid = $("#uid").val();
		   var pwe = $("#pwd").val();
		   if ((uid=="")||(pwd=="")){
			   alert("PLZ input ID&PW!");
			   return false;
		   }
		      var serData = $('#login_form').serialize();
		        $.ajax({
		             url:'/user/login',
		             method:'post',
		             cache:false,
		             data:serData,
		             dataType:'json',
		             success:function(res){
		              alert(res.check ?'로긴 성공':'로긴 실패');
		             },
		             error:function(xhr,status,err){
		                alert('error:'+err);
		             }
		          });
		      return false;
	}
  </script>
</head>
<body bgcolor="#f4c2c2">
<h3>Login Form</h3>
<form id="login_form" onsubmit="return login();">
<div>ID:<input type="text" id="uid" name="uid" value="lucas"/></div>
<div>PW:<input type="text" id="pwd" name="pwd" value="52"/></div>
<button type="submit">login</button>
<button type="reset">cancel</button>
</form>
</body>
</html>