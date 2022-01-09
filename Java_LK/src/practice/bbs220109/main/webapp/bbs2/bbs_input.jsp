<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 쓰기</title>
<style>
	form {width: 17em;}
	textarea{position: relative; left:4em; width:13em;}
	#div_btn{ text-align: center; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script>
	function save(){
		var author = $('#author').val();
		var title = $('#title').val();
		var content = $('#content').val();
		if(author=='' || title=='' || content==''){
			alert('모든 항목을 반드시 입력해주세요');
			return false;
		}
		var serData = $('#input_form').serialize();
		$.ajax({
			url:'/webdemo/bbs',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.saved?'저장 성공':'저장 실패');
				if(res.saved){
					location.href='/webdemo/bbs?cmd=save_check&author='+author;
				}
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
<h3>게시판 글 쓰기</h3>
<form id="input_form" onsubmit="return save();">
	<input type="hidden" name="cmd" value="save">
	<div><label>작성자 <input type="text" id="author" name="author" value="daniel"></label></div>
	<div><label>글제목 <input type="text" id="title" name="title" value="글쓰기 연습"></label></div>
	<div><label for="content">글내용</label></div>
	<div><textarea id="content" name="content" placeholder="여기에 입력~"></textarea></div>
	<p>
	<div id="div_btn">
		<button type="submit">저장</button>
		<button type="reset">취소</button>
	</div>
</form>
</body>
</html>