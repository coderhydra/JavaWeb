package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopDAO;
import com.example.demo.vo.BookVO;

@Service
public class ShopSVC 
{
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ShopDAO dao;
	
	public List<BookVO> bookList(){
		return dao.bookList();
	}
	
	public BookVO detail(int no) {
	return dao.bookdetail(no);
	}
}
