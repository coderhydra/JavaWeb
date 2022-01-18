<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order Report</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  <script>
  function detail(no){
   var reqURL="/shop/report/detail/"+no;
   location.href = reqURL;
  }
  function del(no){
	   var reqURL="/shop/report/del/"+no;
	   location.href = reqURL;
	  }
  </script>
  <style>
  body{color: white;}
  </style>
</head>
<body bgcolor="#664499">
<h1>Order Report</h1>

<table>
<tr><th>주문</th><th>품목번호</th>
<th>주문일</th>
<th>주문항목 금액</th>
<th>주문항목 금액</th>
<th>details</th>
<th>5만원?</th>
</tr>
<c:forEach var="item" items="${list}">
   <tr><td>${item.uid}</td>
      <td>${item.no}</td>
      <td>${item.oDate}</td>
      <td>${item.price*item.qty}</td>
      <td>${total}</td>
      <td><button onclick="detail(${item.oNum});">details</button></td>
      <td>${total.total}</td>
      <td><button onclick="del(${item.oNum});">delete</button></td>
   </tr>
</c:forEach>
</table>
</body>
</html>