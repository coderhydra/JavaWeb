package com.example.demo.xml;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.User;

@Mapper
public interface UserXMLMapper 
{
	int insertUser(User user);
    int addAndGetKey(User user);
	User getUserById(int num);
	List<User> getUserList();
	int updateUser(User u);
	int deleteUser(int num);
	User findWithoutId(User user);
}
