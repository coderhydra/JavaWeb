package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.service.loginSvc;
import com.example.demo.vo.loginVO;

@Controller
@SessionAttributes("uid")
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
	  public String login( loginVO vo, //HttpSession session
	  		Model model
	  		) { 
			boolean ok = svc.login(vo);
			if(ok) {
				//session.setAttribute("uid", vo.getUid());
				model.addAttribute("uid", vo.getUid());
			}
			return String.format("{\"check\": %b}", ok);
	  }
		
		//로그아웃기능
		@GetMapping("/logout")
		@ResponseBody
		public boolean logout(SessionStatus status) {
			status.setComplete(); 
			// 세션에 저장된 모든 데이터를 삭제!
			//바구니 비우기!
			return true;
		}
		
}//end C
