package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.User;
@Repository("mysqlDao")
public class UserMysqlDAO implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(User u) {
		
		String sql = "INSERT INTO user VALUES(NULL,?,?,?)";
		int rows = jdbcTemplate.update(sql,
				u.getName(),u.getPhone(),u.getEmail());
		return rows>0;
	}

	@Override
	public int insertAndGetId(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User select(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
