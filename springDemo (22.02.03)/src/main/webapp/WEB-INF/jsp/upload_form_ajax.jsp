<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload Form</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function upload(){
		if($('#author').val()=='' ||
				$('files').val()==''){
			alert('필수항목을 입력해주세요');
			return false;
		}
		var form = $('#uploadForm')[0]
		var formData = new FormData(form);
		$.ajax({
			url:'/up_down/ajax_upload',
			method:'post',
			enctype:'multipart/form-data',
			data: formData,
			dataType:'text',
			processData:false,  /* Query String 변환하지 말것 */
			contentType:false,  /* utf-8형식의 문자열이 아니고 파일 데이터 */
			cache:false,
			timeout:000000,
			success:function(res){
				alert(res);
			},
			error:function(xhr,status,err){
				alert('에러:'+err);
			}
		});
		return false;
	}
</script>
</head>
<body>
<h3>Spring boot 파일 업로드 테스트</h3>
<form id="uploadForm" onsubmit="return upload();">
	작성자 <input type="text" id='author' name="author" value="smith"><br>
	File <input type="file" id='files' name="files" multiple="multiple"><br>
	<button type="submit">업로드</button>
</form>
</body>
</html>