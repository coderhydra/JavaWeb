package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserService;
import com.example.demo.vo.User;

@Controller
@RequestMapping("/user")
public class UserCRUDController {

	@Autowired
	private UserService svc;
	
	@GetMapping("/add")
	@ResponseBody
	public String userAdd() {
		User u = new User();
		u.setName("huhu");
		u.setPhone("010-7777-7777");
		u.setEmail("huhu@gmail.com");
		
		boolean added = svc.insert(u);
		return added+"";
	}
}
