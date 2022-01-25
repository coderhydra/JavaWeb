package com.example.demo.xml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.User;

@Repository
public class UserDAO 
{
	@Autowired
	private UserXMLMapper userMapper;

	public int insert(User u) {
		return userMapper.insertUser(u);
	}
	
    public int addAndGetKey(User u) {
        return userMapper.addAndGetKey(u);
    }
	public User selectById(int num) {
		return userMapper.getUserById(num);
    }
	
	public List<User> getUserList() {
		return userMapper.getUserList();
    }

	public int update(User u) {
		return userMapper.updateUser(u);
	}
	
	public int delete(int num) {
		return userMapper.deleteUser(num);
	}
	
	public User findWithoutId(User user) {
		return userMapper.findWithoutId(user);
	}
}
