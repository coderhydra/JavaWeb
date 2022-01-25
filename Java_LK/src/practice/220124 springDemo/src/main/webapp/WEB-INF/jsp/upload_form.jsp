<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload Form</title>
<style>
body {color: white;}
a:link {color : pink;}
</style>
</head>
<body bgcolor="#664499">
<h3>Spring boot 파일 업로드 테스트</h3>
<form action="upload" method="post" enctype="multipart/form-data">
   <!-- enctype="multipart/form-data"
   안해주면 파일이 안올라감. 텍스트+바이너리(파일) 데이터
   메소드는 포스트로 
   포스트 방식에 이엔씨 멀티타입 필수!
    -->
   작성자 <input type="text" name="author" value="lucas"><br>
   File <input type="file" name="files" multiple="multiple"><br>
   <!-- 파일을 올리는 인풋박스
   multiple 파일 여러개 선택가능 -->
   <button type="submit">업로드</button>
   <br>
   <a href="/download/LK.jpg">프로필 다운로드</a>
</form>
</body>
</html>