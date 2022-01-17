<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script>
  function update() {
      var dept = $('#dept').val();
      var salary = $('#salary').val();
      if(dept=='' || salary=='') {
         alert('입력란을 확인하세요');
         return false;
      }
      var serData = $('#update_form').serialize();
         $.ajax({
             url:'/emp/update',
             method:'post',
             cache:false,
             data:serData,
             dataType:'json',
             success:function(res){
              alert(res.updated ?'수정 성공':'수정 실패');
              location.href="/emp/detail?no=${emp.no}";
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
<h3>edit</h3>
<form id="update_form" action="submit" method="post"
onsubmit="return update();">
<div>num: ${emp.no} </div><input type="hidden" id="no" name="no" value="${emp.no}" readonly/>
<div>name:<input type="text" id="ename" name="ename" value="${emp.ename}" readonly/></div>
<div>dept:<input type="text" id="dept" name="dept" value="${emp.dept}"/></div>
<div>salary:<input type="text" id="salary" name="salary" value="${emp.salary}"/></div>

<button type="submit">save</button>

<button type="reset">cancel</button>

</form>
</body>
</html>