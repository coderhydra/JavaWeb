package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.loginSvc;
import com.example.demo.vo.loginVO;

@Controller
@RequestMapping("/user")
public class loginController {

	  @Autowired
	  private loginSvc svc;
	  
		@GetMapping("/login")
		public String loging() {
			return "user_loginform";
		}
		@PostMapping("/login")
		@ResponseBody
	  public String login( loginVO vo) { 
			System.out.println("cont login");
			boolean result = svc.login(vo);
			System.out.println("login() res " + result);
			return String.format("{\"check\": %b}", result);
	  }
}//end C
