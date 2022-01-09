<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
   integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
   crossorigin="anonymous"></script>
   <script>
   function login() {
	   var uid = $('#uid').val();
	   var pwd = $('#pwd').val();
	   if(uid=='' || pwd=='') {
		   alert ('Plz input ID & PW!');
	   }
	   var serData = $('#login_form').serialize();
	   $.ajax({
		   url : '/webdemo/login2',
		   method:'post',
		   cache:false,
		   data:serData,
		   dataType:'json',
		   success:function(res){
			   alert(res.login?'로그인 성공':'로그인 실패');
			   location.href='/webdemo/bbs';
		   },
		   error:function(xhr,status,err){
			   alert('에러:'+err);
		   }
	   });
	   return false;
   }
   </script>
</head>
<body bgcolor="#f4c2c2">
<h3>LOGIN</h3>
<form id="login_form" onsubmit="return login();">
<input type="hidden" id="cmd" name="cmd" value="login">
<div>NAME :<input type="text" id="uid" name="uid" value="lucas"></div>
<div>NUM :<input type="text" id="pwd" name="pwd" value="1"></div>
      <button  type="submit">login</button>
      <button  type="reset">cancel</button>
</form>
</body>
</html>