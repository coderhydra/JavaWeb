package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmpSvc;
import com.example.demo.vo.EmpVO;

@Controller //@===>annotation mean Controller annotation
public class IndexController { // POJO(Plain Object Java Class)

   @GetMapping("/") // _/_ 이름_경로 get방식으로 _/_요청하면 아래 method 발동
   public String index(Model m) { 
  	 // D.I. Dependency injection(의존성 주입)
  	 // Model m = new Model(); 프레임워크라 필요 없음 호출(선언)하면 스프링이 자동으로 생성
  	 // Model =  view 가 보여줄 data
  	 m.addAttribute("data", "Hello World!"); //req.setAttribute 영역개체생성
  	 System.err.println("컨트롤러 실행됨");
      return "index";
   }
   @GetMapping("/gugu") // _/_ 이름_경로 get방식으로 _/_요청하면 아래 method 발동
   public String gugu(Model m) { 
  	 int dan = 5;
  	 List<String> list = new ArrayList<>();
  	 for (int i=1 ; i<10 ; i++) {
  		 list.add(String.format("%d * %d = %d", dan , i ,dan*i));
  		 m.addAttribute("gugu", list);
  	 }
      return "gugu";
   }
   @GetMapping("/emp")
   public String emp(HttpServletRequest req, Model m) { 
  	 //Emp 객체 (사번, 이름, 부서 ,급여)
  	 EmpVO emp = new EmpVO();
  	 emp.setNo(52);
  	 emp.setEname("lucas");
  	 emp.setDept(1);
  	 emp.setSalary(3600);
  	 m.addAttribute("emp",emp);

  	 
  	 return "emp";
   }

   /*Quert String : /gugu?dan= 5 
    * 위의 요청을 처리하는 컨트롤러 메소드를 정의하고 결과를 보여줄 View도 작성해 보세요.
    * */
   @GetMapping("/gugu2")
   public String gugu2(HttpServletRequest req, Model m) { 
  	 List<String> gugu = new ArrayList<>();
  	 int dan =Integer.parseInt( req.getParameter("dan"));
  	 for (int i=1 ; i<10 ; i++) {
  		 String res = String.format("%d * %d = %d", dan , i ,dan*i);
  	 gugu.add(res);
  	 }
  			 m.addAttribute("res",gugu);
  	 return "gugu2";
   }
   
   @Autowired //자동연결 (자동으로 객체 생성 (new)
   private EmpSvc svc;
   
   @Autowired //@Component 넣어주기
   private EmpVO emp;
   
   @GetMapping("/emp2")
   @ResponseBody // 브라우저 출력!
   public boolean emp2(@RequestParam("no") int no,
  		 @RequestParam("ename") String name,
  		 @RequestParam("dept") int dept
  		 ) { 
  	 // EmpVO2 emp = new EmpVO2(); @Autowired
  	 emp.setNo(no);
  	 emp.setEname(name);
  	 emp.setDept(dept);
  	 // EmpSvc e = new EmpSvc(); ---> private EmpSvc svc;
  	 boolean res = svc.Empsave(emp);

		return res;
   }
}

 