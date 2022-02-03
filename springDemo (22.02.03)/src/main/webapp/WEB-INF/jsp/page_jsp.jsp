<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원 목록</h2>
<table>
<tr><th>번 호</th><th>이 름</th><th>전 화</th><th>메 일</th></tr>
<c:forEach var="u" items="${pageInfo.list}">
   <tr><td>${u.num}</td><td>
      <a href="javascript:getInfo(${u.num});">${u.name}</a>
   </td>
   <td>${u.phone}</td><td>${u.email}</td>
   </tr>
</c:forEach>
</table>
<div id="pagination">
   <c:forEach var="i" items="${pageInfo.navigatepageNums}">
      <c:choose>
         <c:when test="${i==pageInfo.pageNum}">
            [${i}] 
         </c:when>
         <c:otherwise>
            [<a href="/mybatis/user/list/page/${i}">${i}</a>] 
         </c:otherwise>
      </c:choose> 
   </c:forEach>
</div>

</body>
</html>