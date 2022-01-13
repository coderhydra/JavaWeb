<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Detail</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script>
  function del(){
      if(!confirm("정말로 삭제하시겠어요?")) return;
      $.ajax({
          url:'/emp/del?no=${emp.no}',
          dataType:'json',
          success:function(res){
           alert(res.deleted ?'삭제 성공':'삭제 실패');
           location.href="/emp/list";
          },
          error:function(xhr,status,err){
             alert('error:'+err);
          }
       });
  }

</script>
</head>
<body bgcolor="#f4c2c2">
<h3>사원 정보</h3>
<div>${emp.no}</div>
<div>${emp.ename}</div>
<div>${emp.dept}</div>
<div>${emp.salary}</div>

<a href="/emp/edit?no=${emp.no}">edit</a>
   <a href="javascript:del();">정보 삭제</a>
</body>
</html>