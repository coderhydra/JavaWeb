<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Input</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script>
function logout(){
	if(!confirm("정말로 로그아웃하시겠습니까?")) return;
    $.ajax({
        url:'/user/logout',
        method:'get',
        cache:false,
        dataType:'text',
        success: function(res) {
           alert(eval(res) ? "로그아웃 성공":"로그아웃 실패");
        },
        error: function(xhr, status, err) {
           alert("error:"+err);
        }
     });
	}
</script>
</head>
<body bgcolor="#f4c2c2"> 
<h3>input form!</h3>
<a href="javascript:logout();">[Logout]</a>

<form action ="/emp/add" method="post">

<div>num: <input type="text" id="no" name="no" value="11"></div> 
<div>name: <input type="text" id="ename" name="ename" value="ename"></div> 
<div>dept: <input type="text" id="dept" name="dept" value="11"></div> 

<button type="submit">save</button>
<button type="reset">cancel</button>
</form>
</body>
</html>
