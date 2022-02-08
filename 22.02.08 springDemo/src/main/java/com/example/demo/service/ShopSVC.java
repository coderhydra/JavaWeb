package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopDAO;
import com.example.demo.util.Cart;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.orderVO;

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
		return cart.add(book);
	}
	
	public List<BookVO> showCart() {
		Cart cart = (Cart) session.getAttribute("cart");
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

	public boolean delete(int no) {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.delete(no);
	}

	public boolean cartEmpty() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.cartEmpty();
	}

	public boolean order() {
		Cart cart = (Cart) session.getAttribute("cart");
		String uid = (String) session.getAttribute("uid");
		boolean saved = dao.saveOrder(uid, cart.getList());
		if(saved) cart.cartEmpty();
		return saved;
	}

	public  List<orderVO> report() {
		return dao.report();
	}

	public int orderTotal() {
		return dao.rtotal();
	}

	public orderVO rDetail(int no) {
		return dao.orderdetail(no);
	}

	public boolean rdelete(int no) {
		boolean deleted = dao.orderDel(no);
		return deleted;
	}

	public void reportdel(int no) {
		dao.orderDel(no);
	}

}