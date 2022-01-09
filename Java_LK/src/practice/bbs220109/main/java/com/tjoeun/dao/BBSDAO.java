package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.*;

import com.tjoeun.vo.BBSVO;

public class BBSDAO 
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection getConn() {
	   try{
	      String url = "jdbc:mysql://localhost:3306/"
	      		+ "mydb?characterEncoding=UTF-8&serverTimezone=UTC&SSL=false";
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      conn = DriverManager.getConnection(url, "root", "5227");
	      return conn;
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return null;
	}
	
	public BBSVO saveCheck(String author) {
		String sql = "SELECT * FROM bbs WHERE num="
				   + "("
				   +	 "SELECT MAX(num) FROM bbs WHERE author=?"
				   + ")";
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BBSVO bbs = new BBSVO();
				bbs.setNum(rs.getInt("NUM"));
				bbs.setTitle(rs.getString("TITLE"));
				bbs.setAuthor(rs.getString("AUTHOR"));
				bbs.setWdate(rs.getDate("WDATE"));
				bbs.setHitcount(rs.getInt("HITCOUNT"));
				bbs.setContent(rs.getString("CONTENT"));
				return bbs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteBoard(int num) {
		String sql = "DELETE FROM bbs WHERE num=?";
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n = pstmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return false;
	}
	
	public boolean updateBoard(BBSVO vo) {
		String sql = "UPDATE bbs SET title=?, content=? WHERE num=?";
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3,  vo.getNum());
			int n = pstmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return false;
	}
	
	public BBSVO getBoard(int num) {
		String sql = "SELECT * FROM bbs WHERE num=?";
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BBSVO vo = new BBSVO();
				vo.setNum(rs.getInt("NUM"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setAuthor(rs.getString("AUTHOR"));
				vo.setWdate(rs.getDate("WDATE"));
				vo.setHitcount(rs.getInt("HITCOUNT"));
				vo.setContent(rs.getString("CONTENT"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
	
	public boolean insert(BBSVO bbs) {
		conn = getConn();
		String sql = "INSERT INTO bbs(title, author, wdate, hitcount, content )"
					+ "VALUES(?,?,NOW(),0,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getAuthor());
			pstmt.setString(3, bbs.getContent());
			
			int n = pstmt.executeUpdate();
			return n>0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return false;
	}
	
	public List<BBSVO> getList(){
		String sql = "SELECT num, author, title, wdate, hitcount "
					+ "FROM bbs";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BBSVO> list = new ArrayList<>();
			while(rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				java.sql.Date wdate = rs.getDate("WDATE");
				int hitcount = rs.getInt("HITCOUNT");
				BBSVO bbs = new BBSVO();
				bbs.setNum(num);
				bbs.setAuthor(author);
				bbs.setTitle(title);
				bbs.setWdate(wdate);
				bbs.setHitcount(hitcount);
				list.add(bbs);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
	
	private void closeAll() {
		try{
			if(rs!=null) rs.close();
		    if(pstmt!=null) pstmt.close();
		    if(conn!=null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
