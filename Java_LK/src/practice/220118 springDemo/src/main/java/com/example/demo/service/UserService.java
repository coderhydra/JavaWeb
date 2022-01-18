package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.vo.User;

@Service
public class UserService {

	private UserDAO dao;
	
	@Autowired
	public UserService(@Qualifier("mysqlDao") UserDAO dao) {
		this.dao = dao;
	}
	

	public boolean insert(User u) {
		return dao.insert(u);
	}
}
