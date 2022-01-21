package com.example.demo.controller;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping//("/up_down")
public class UploadController 
{
   @Autowired
   ResourceLoader resourceLoader; //스프링인 가지고 있는 io

   @GetMapping("upload") //겟방식으로 주소요청시 업로드 폼으로 포워딩
   public String getForm() {
      return "upload_form";
   }
   
   @PostMapping("upload") //포스트요청시 실행로직
   @ResponseBody
   public String upload(@RequestParam("files")MultipartFile[] mfiles,
         HttpServletRequest request,
         @RequestParam("author") String author) {
  	 //files-> 멀티파트파일(스프링이 지원하는 클래스)에서 다룸->mfiles 의 배열로 받음
      ServletContext context = request.getServletContext();
      String savePath = context.getRealPath("/WEB-INF/upload");
      // /WEB-INF 는 자바로 웹을 만들때 반드시 있어야하는 표준 디렉토리
      // 절대경로로만 작동한다. 
      // getRealPath 절대경로를 상대경로로 바꾸어주는 메소드
      try {
         for(int i=0;i<mfiles.length;i++) {
            mfiles[i].transferTo( //파일경로를 mfiles로 보냄 getOriginalFilename() 파일이름구하는 메소드
              new File(savePath+"/"+mfiles[i].getOriginalFilename()));
            //mfiles 이용자에게서 온 파일정보(배열_(메모리))를 디스크의 해당경로로 이동
            /* MultipartFile 주요 메소드
            String cType = mfiles[i].getContentType(); 내용의 타입
            String pName = mfiles[i].getName(); 클라이언트가 보낸 파일의 경로+이름
            Resource res = mfiles[i].getResource(); 리소스구하는 뒤에 .
            long fSize = mfiles[i].getSize(); 파일의 크기구하기
            boolean empty = mfiles[i].isEmpty(); 파일의 내용유무
            */
         }
         String msg = String.format("파일(%d)개 저장성공(작성자:%s)", mfiles.length,author);
         return msg;
      } catch (Exception e) {
         e.printStackTrace();
         return "파일 저장 실패:";
      }
   }
   
   @GetMapping("download/{filename}")//다운로드 요청 패스배리어블이 다루기 편하다
   public ResponseEntity<Resource> download(
         HttpServletRequest request,
         @PathVariable String filename){
      Resource resource = resourceLoader.getResource("WEB-INF/upload/"+filename);
      //파일 경로 리소스로더로 리소를 구한다.
      System.out.println("파일명:"+resource.getFilename());
      //파일이름 구하는 메소드 겟파일네임 debug
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            // 절대경로를 구해서 브라우저에서 서버로 전달되는 데이터타입 (알아야지 유저가 형식을 알수 있음)
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        if(contentType == null) {
            contentType = "application/octet-stream";
            //타입이 없을때! (이것이 없으면 브라우저에서 열려버림)
            //서버디스크에서 이용자의 디스크로 스트림함
            //즉 브라우저에서 열지 않고 다운로드 창을 만들기 위해
        }
        return ResponseEntity.ok()
        		//스트림을 이용하여 브라우저에게 전달하는 로직_스프링에서 지원
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
                 //http 프로토콜 형식 다운로드창에 파일이름 표시와 브라우저에서 열리지 않고 다운로드 창을 띄움
                 //ok() 바디를 만들어준다. ~@Responsebody
                 // 변경사항은 파일이름 바꾸는 부분
   }
}