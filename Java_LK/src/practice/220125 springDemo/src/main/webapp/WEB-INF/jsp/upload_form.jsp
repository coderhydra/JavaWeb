<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload Form</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
   integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
   crossorigin="anonymous"></script>
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
   <a href="download/LK.jpg">프로필 다운로드</a>
</form>
<form id="FILE_FORM" method="post" enctype="multipart/form-data" action="">
   <input type="file" id="FILE_TAG" name="FILE_TAG">
   <input type="file" id="FILE_TAG2" name="FILE_TAG2">
   <a class="ui-shadow ui-btn ui-corner-all" href="javascript:uploadFile();">전송</a>
</form>
<script>
function uploadFile(){
     var form = $('#FILE_FORM')[0];
     var formData = new FormData(form);
     formData.append("fileObj", $("#FILE_TAG")[0].files[0]);
     formData.append("fileObj2", $("#FILE_TAG2")[0].files[0]);
     $.ajax({
         url: '/up_down/upload',
         processData: false, /* Query String 변환하지 말것 */
         contentType: false, /* utf-8 방식의 문자열이 아니고 파일 테이터*/
         data: formData,
         type: 'POST',
         success: function(result){
              alert("업로드 성공!!");
         }
    });
}
</script>

</body>
</html>