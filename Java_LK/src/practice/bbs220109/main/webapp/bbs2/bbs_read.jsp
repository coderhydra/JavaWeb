<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 보기</title>
</head>
<body bgcolor="#f4c2c2">
<h3>게시판 글 보기</h3>
<div>${board.num} ${board.title} ${board.author} ${board.wdate} ${board.hitcount}</div>
<div>${board.content}</div> 
<hr>
[<a href="/webdemo/bbs?cmd=edit&num=${board.num}">edit</a>]
[<a href="/webdemo/bbs?cmd=list">list</a>]
</body>
</html>