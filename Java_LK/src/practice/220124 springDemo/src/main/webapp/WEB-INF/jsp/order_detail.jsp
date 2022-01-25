<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>order Detail</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script>
  function del(no){
	  if(confirm("현재 주문정보를 삭제하시겠어요?")){
		  
		  $.ajax({
			  url:"/shop/report/delete/"+no,
		     cache:false,
		     dataType:'text',
		     success: function(res){
		    	 alert(res);
		     },
		     error: function(xhr,status,err){
		    	 alert("error:"+err);
		     }
		  });
	  }
  }
  </script>
<style>
body {color: white;}
</style>
</head>
<body bgcolor="#664499">

<h3>order Detail</h3>

<div>order num: ${detail.oNum}</div>
<div>주문자: ${detail.uid}</div>
<div>num: ${detail.no}</div>
<div>title: ${detail.title} </div>
<div>price: ${detail.price} </div>
<div>pub: ${detail.pub} </div>
<div>pubdate: ${detail.pubdate}</div>
<hr>
<button type="button" onclick="del(${detail.oNum});">[delete]</button>

</body>
</html>