package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;

@Repository
public class UserMapperDAO {

	/*인터페이스 주입 마이바티스가 구현한 클래스*/
  @Autowired
  private UserMapper userMapper;

  public User selectById(int num) {
     return userMapper.getUserById(num);
   }
  
  public User login(User user) {
  	return userMapper.getUser(user);
  }

  public int insert(User user) {
     return userMapper.insertUser(user);
  }

  public int addAndGetKey(User user) {
     return userMapper.addAndGetKey(user);
  }

  public List<User> getUserList() {
     return userMapper.getUserList();
  }

  public int update(User user) {
     return userMapper.updateUser(user);
  }

  public int delete(int num) {
     return userMapper.deleteUser(num);
  }

}
