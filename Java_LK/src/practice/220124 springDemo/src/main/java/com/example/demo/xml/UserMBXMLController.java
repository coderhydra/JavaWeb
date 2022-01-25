package com.example.demo.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.xml.*;
import com.example.demo.vo.User;

@RestController
@RequestMapping("/mbxml")
public class UserMBXMLController {

	@Autowired
	private UserDAO dao;
	
	@GetMapping("/")
	public String index() {
		return "Spring boot MyBatis Test";
	}
	
	@GetMapping("/user/add")
	public int insertUser() {
		return dao.insert(new User(0,"obama","010-6541-6239","obama@usa.com"));
	}
	
	/* 한 행을 추가하고 저장된 자동증가 필드의 값을 가져오는 예*/
	@GetMapping("/user/add/getkey")
	public int insertAndGetKey() {
		User u = new User(0,"trump","010-3910-2540","trump@gmail.com");
		int rows = dao.addAndGetKey(u);
		int key = u.getNum();
		return key;
	}

	@GetMapping("/user/{num}")
	public String getUser(@PathVariable int num) 
	{
		return dao.selectById(num).toString();
	}
	
	@GetMapping("/user/list")
	public String getUserList() 
	{
		return dao.getUserList().toString();
	}
	
	@GetMapping("/user/update")
	public int updateUser() {
		return dao.update(new User(6,null,"010-1111-2222","updated@gmail.com"));
	}
	
	@GetMapping("/user/delete/{num}")
	public int deleteUser( @PathVariable("num") int num) {
		return dao.delete(num);
	}
	
	@GetMapping("/user/findWithoutId")
	public String findWithoutId() {
		User u = new User();
		u.setName("lucas");
		return dao.findWithoutId(u).getEmail();
	}
}