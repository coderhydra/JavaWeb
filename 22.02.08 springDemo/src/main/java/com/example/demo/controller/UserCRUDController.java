package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserService;
import com.example.demo.vo.User;

@Controller
@RequestMapping("/user")
public class UserCRUDController {

	@Autowired
	private UserService svc;
	
	@GetMapping("/add")
	public String userAddGet() {
		return "sql_add";
	}
	@PostMapping("/add")
	@ResponseBody
	public String userAddPost(
//			@RequestParam("name") String name,
//			@RequestParam("phone") String phone,
//			@RequestParam("email") String email
			User u
			) {
//		User u = new User();
//		u.setName(name);
//		u.setPhone(phone);
//		u.setEmail(email);
		boolean added = svc.insert(u);
		return added+"";
	}
	
	@GetMapping("/add_and_getpk")
	@ResponseBody
	public String userAddNo() {
		User u = new User();
		u.setName("lucas");
		u.setPhone("213.909.1687");
		u.setEmail("lucas@cp.com");
		int pk = svc.insertAndGetId(u);
		return pk+"";
	}
	
	@GetMapping("/read/{no}") /*  /user/get/5/  */
	@ResponseBody
	public String read(@PathVariable("no")int no,Model m) {
		User u = svc.read(no);
		m.addAttribute("user",u);
		String num = u.getNum()+"";
		String res = num+" | "+u.getName()+" | "+
		u.getNum()+" | "+u.getEmail();
		return res;
	}
	
	@GetMapping("/update/{no}/{email}")
	@ResponseBody
	public String update (
		@PathVariable("no") int no,
		@PathVariable("email") String email) {
		User u = new User();
		u.setNum(no);
		u.setEmail(email);
	return svc.update(u)+"";
	}
	
	@GetMapping("/del/{no}")
	@ResponseBody
	public String delete (
		@PathVariable("no") int no) {
	return svc.delete(no)+"";
	}
	
	@GetMapping("/list/line")
	@ResponseBody
	public String listline() {
		System.out.println("ch");
		List<User> list = new ArrayList<>();
		list= svc.list();
		return list.size()+"";
	}
	
	@GetMapping("/list")
	public String list(Model m){
		List<User> list = new ArrayList<>();
		list=svc.list();
		m.addAttribute("list",list);
		return "sql_list";
	}
	
	@GetMapping("/update")
	public String asdf() {
		return "sql_update";
	}
	@PostMapping("/update")
	@ResponseBody
	public String asdfasdf(
			@RequestParam("no") int no,
			@RequestParam("email") String email
			) {
		User u = new User();
		u.setNum(no);
		u.setEmail(email);
		boolean ok= svc.update(u);
		return ok+"";
	}
}
