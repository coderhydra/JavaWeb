package com.example.demo.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.xml.*;
import com.github.pagehelper.PageInfo;
import com.example.demo.vo.User;

@Controller
//@RestController
@RequestMapping("/mbxml")
public class UserMBXMLController {

	@Autowired
	private UserDAO dao;
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Spring boot MyBatis Test";
	}
	
	@GetMapping("/user/add")
	@ResponseBody
	public int insertUser() {
		return dao.insert(new User(0,"obama","010-6541-6239","obama@usa.com"));
	}
	
	/* 한 행을 추가하고 저장된 자동증가 필드의 값을 가져오는 예*/
	@GetMapping("/user/add/getkey")
	@ResponseBody
	public int insertAndGetKey() {
		User u = new User(0,"trump","010-3910-2540","trump@gmail.com");
		int rows = dao.addAndGetKey(u);
		int key = u.getNum();
		return key;
	}

	@GetMapping("/user/{num}")
	@ResponseBody
	public String getUser(@PathVariable int num) 
	{
		return dao.selectById(num).toString();
	}
	
	@GetMapping("/user/list")
	@ResponseBody
	public String getUserList() 
	{
		return dao.getUserList().toString();
	}
	
	@GetMapping("/user/update")
	@ResponseBody
	public int updateUser() {
		return dao.update(new User(6,null,"010-1111-2222","updated@gmail.com"));
	}
	
	@GetMapping("/user/delete/{num}")
	@ResponseBody
	public int deleteUser( @PathVariable("num") int num) {
		return dao.delete(num);
	}
	
	@GetMapping("/user/findWithoutId")
	@ResponseBody
	public String findWithoutId() {
		User u = new User();
		u.setName("lucas");
		return dao.findWithoutId(u).getEmail();
	}
	@GetMapping("/user/list/page/{pgNum}")
  public String getListByPage(@PathVariable("pgNum")int pg, Model model) {
		PageInfo<User> pgInfo = dao.getUserListPage(pg, 2);
     model.addAttribute("pageInfo", pgInfo);
   //  return pgInfo.getList().size()+"";
   return "page_jsp";
  }
	
}