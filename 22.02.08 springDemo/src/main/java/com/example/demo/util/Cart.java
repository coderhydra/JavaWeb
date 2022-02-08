package com.example.demo.util;

import java.util.*;

import com.example.demo.vo.BookVO;

public class Cart {

	private List<BookVO> list= new ArrayList<>();
	
	public boolean add(BookVO book) {
//		list.add(book);
//		return true;
//		동일 도서가 이미 장바구니에 있다면 수량만 증가시킨다.
		for (int i = 0; i<list.size(); i++) {
			BookVO _book = list.get(i);
			if ( (_book.getNo()==book.getNo()) &&
					(_book.getTitle().equals(book.getTitle())) ) {
						_book.setQty(_book.getQty()+book.getQty());
						return true;
			}
		}
		list.add(book);
		return true;
		
	}
	
	public List<BookVO> getList() {
		return list;
	}
	
	public int total() {
		int total=0;
		for (int i=0 ; i<list.size(); i++) {
			BookVO book = list.get(i);
			total += book.getPrice()*book.getQty();
		}
		return total;
	}

	public boolean updateQty(int no, int qty) {
		for(int i=0; i<list.size(); i++) {
			BookVO vo = list.get(i);
			if(vo.getNo()==no) {
				vo.setQty(qty);
				return true;
			}
		}
		return false;
	}

	public boolean delete(int no) {
		for (int i = 0; i<list.size(); i++) {
			BookVO book = list.get(i);
			if ( book.getNo()== no ){
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean cartEmpty() {
		list.clear();
		return true;
	}
}
