package com.example.demo.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapperDAO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;

@Service
public class UserMBSVC {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserMapperDAO dao;
	
	public boolean login(User user) {
		User u = dao.login(user);
		if(u!=null) {
			session.setAttribute("uid", u.getName());
			return true;
		}
		else {
			return false;
		}
	}
}