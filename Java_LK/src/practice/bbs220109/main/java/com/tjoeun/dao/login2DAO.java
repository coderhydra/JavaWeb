package com.tjoeun.dao;

import java.sql.*;
import com.tjoeun.vo.login2VO;

public class login2DAO {
//link sql unlink sql from Svc num name
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection getConn() {
		try {
			String url = "jdbc:mysql://localhost:3306/mydb?"
					+ "characterEncoding=UTF-8&serverTimezone=UTC&SSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","5227");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void closeAll() {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	public boolean login(login2VO u) {
		conn = getConn(); //connect DB
		String sql = "SELECT num, name FROM member "
				+ "WHERE num=? AND name=?;";
		//System.out.println("dao no="+u.getNum()); ok
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getNum());
			pstmt.setString(2, u.getName());
			rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return false;
	}


}//end C
