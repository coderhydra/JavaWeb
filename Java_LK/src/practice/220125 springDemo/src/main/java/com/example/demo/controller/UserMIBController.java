package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserMapperDAO;
import com.example.demo.service.UserMBSVC;
import com.example.demo.vo.User;

/*모든 메소드가 리스폰스 바디 역활을 하게 하는 어노테이션==responsebody*/
@RestController
@RequestMapping("/mb")
public class UserMIBController {


  @Autowired
  private UserMapperDAO dao;
  
  @Autowired
  private UserMBSVC svc;
  
  @GetMapping("/")
  public String index() {
     return "index";
  }
  
  @GetMapping("user/add")
  public int insertUser() 
  {
     return dao.insert(new User(0,"obama","010-6541-6239","obama@usa.com"));
  }
     
  /* 한 행을 추가하고 저장된 자동증가 필드의 값을 가져오는 예*/
  @GetMapping("user/add/getkey")
  public int insertAndGetKey() {
     User u = new User(0,"trump","010-3910-2540","trump@gmail.com");
     /*키값 리턴(프라이머리키)*/
     int rows = dao.addAndGetKey(u);
     int generatedKey = u.getNum();
     return generatedKey;
  }
  

  @GetMapping("user/{num}")
  public Map <String,Object> getUser(@PathVariable int num) 
  {
  	Map<String,Object> map = new HashMap<>();
  	User u =dao.selectById(num);
  	map.put("num",u.getNum());
  	map.put("name",u.getName());
  	map.put("phone",u.getPhone());
  	map.put("email",u.getEmail());
  	/* 주소값 리턴됨*/
     //return dao.selectById(num).toString();
   return map;
  }
  
  @GetMapping("/user/login")
  public String login() {
  	User u = new User();
  	u.setNum(1);
  	u.setName("lucas");
  	return "로그인 결과"+svc.login(u);
  }

  
  @GetMapping("user/list")
  public String getUserList() 
  {
     return dao.getUserList().toString();
  }
  
  @GetMapping("user/update/{num}")
  public int updateUser(@PathVariable("num") int num) {
     return dao.update(new User(num,null,"010-3671-2105","updated@gmail.com"));
  }
  
  @GetMapping("user/delete/{num}")
  public int deleteUser(@PathVariable("num") int num) {
     return dao.delete(num);
  }

}
