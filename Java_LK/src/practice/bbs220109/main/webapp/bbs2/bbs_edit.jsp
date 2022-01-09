<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 수정</title>
</head>
<body bgcolor="#f4c2c2">
<h3>게시판 글 수정</h3>
<form id="update_form" onsubmit="return update();">
	<input type="hidden" name="cmd" value="update">
	<div><label>글 번호 <input type="text" id="num" name="num" value="${board.num}" readonly></label></div>
	<div><label>글 제목 <input type="text" id="title" name="title" value="${board.title}"></label></div>
	<div><label>글 내용 <textarea id="content" name="content" value="${board.content}"></textarea></label></div>
</form>
</body>
</html>