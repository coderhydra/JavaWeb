package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.User;
@Repository("mysqlDao")//DI (객체생성시 이 이름을 사용 newX)
//다오에 붙이는 어노테이션
public class UserMysqlDAO implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(User u) {
		
		String sql = "INSERT INTO user VALUES(NULL,?,?,?)";
		int rows = jdbcTemplate.update(sql,
				u.getName(),u.getPhone(),u.getEmail());
		//preparedstatement
		//스프링이 연결,문장실행, 결과도출(행수 리턴), 
		//오토와이어드 필요 jdbcTemplate
		return rows>0;
	}

	@Override
  public int insertAndGetId(User u) {
     String sql = "INSERT INTO user VALUES(NULL,?,?,?)";
     KeyHolder keyHolder = new GeneratedKeyHolder();
     jdbcTemplate.update(conn->{
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement(sql, new String[] {"num"});
        pstmt.setString(1, u.getName());
        pstmt.setString(2, u.getPhone());
        pstmt.setString(3, u.getEmail());
        return pstmt;
     }, keyHolder);
     return keyHolder.getKey().intValue();
  }

	@Override
	public User select(int num) {
		String sql = "SELECT* FROM user WHERE num=?";
		return jdbcTemplate.queryForObject(sql, (rs,i)->
		//select ---> queryforObject
		new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4))
				,num);
	}
	/*
	@Override
	public User select(int num) {
		String sql = "SELECT* FROM user WHERE num=?";
		return jdbcTemplate.queryForObject(sql, (rs,i)->{
			User u = new User();
			u.setNum(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setPhone(rs.getString(3));
			u.setEmail(rs.getString(3));
			return u;
		}.sum();
	}
	*/
	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET email=? WHERE num=?";
		int rows = jdbcTemplate.update(sql, u.getEmail(), u.getNum());
		return rows>0;
	}

	@Override
	public boolean delete(int num) {
		String sql = "DELETE FROM user WHERE num=?";
		int rows = jdbcTemplate.update(sql,num);
		return rows>0;
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user";
		return jdbcTemplate.query(sql, (rs,i)->
			new User(rs.getInt(1),rs.getString(2),
					rs.getString(3),rs.getString(4))
					);
	}

}
