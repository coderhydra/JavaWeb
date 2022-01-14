package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopDAO;
import com.example.demo.util.Cart;
import com.example.demo.vo.BookVO;

@Service
public class ShopSVC 
{
	@Autowired
	private HttpSession session;
	//session 쓸때 autowired 하기!!!
	
	@Autowired
	private ShopDAO dao;
	
	public List<BookVO> bookList(){
		return dao.bookList();
	}
	
	public BookVO detail(int no) {
	return dao.bookdetail(no);
	}

	public boolean toCart(BookVO book) {
//		Object objcart = session.getAttribute("cart");
//		if(objcart == null ) { 한번만 사용하면 간결하게하기 위해 하기...
	if( session.getAttribute("cart") == null ) { 
			session.setAttribute("cart", new Cart());
		}
		Cart cart = (Cart) session.getAttribute("cart");
		// casting ---> vo???
		System.out.println("서비스" + cart);
		return cart.add(book);
	}
	
	public List<BookVO> showCart() {
		Cart cart = (Cart) session.getAttribute("cart");
		System.out.println("Svc-showcart item 수 :" + cart.getList().size());
		return cart.getList();
	}

	public int getTotal() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.total();
	}

	public boolean updateQty(int no, int qty) {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.updateQty(no,qty);
	}
}
