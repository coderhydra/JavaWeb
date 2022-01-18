<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Book Detail</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script>
  function inCart() {
	  if($("#qty").val()<1) {
		  alert('Plz input qty!');
		  return false;
	  }
	  var serData = $('#order_form').serialize();
	     $.ajax({
	         url:'/shop/book/tocart',
	         method:'post',
	         cache:false,
	         data:serData,
	         dataType:'json',
	         success:function(res){
	            alert(res.incart ? '장바구니 저장 성공':'실패');
	            location.href = '/shop/book/showcart';
	         },
	         error:function(xhr, status, err){
	            alert("error"+err);
	         }
	      });
	  return false;
  }
  </script>
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
<hr>
<form id="order_form" onsubmit="return inCart();">
<input type= "hidden" id="no" name="no" value="${detail.no}">
<input type= "hidden" id = "title" name="title" value="${detail.title}">
<input type= "hidden" id = "price" name="price" value="${detail.price}">
<input type= "hidden" id = "pwd" name="pub" value="${detail.pub}">
<input type= "hidden" id = "pubdate" name="pubdate" value="${detail.pubdate}">
<div>how?<input type= "number" min="1" max="100" id="qty" name="qty" value="1"/></div>
<br>
<button type="submit">add</button>
<button type="reset">cancel</button>
</form>



<input type="range" id="a" name="ages" min="1" max="100" step="1">
<select><option>1<option>2<option>3</select>
<br>
</body>
</html>