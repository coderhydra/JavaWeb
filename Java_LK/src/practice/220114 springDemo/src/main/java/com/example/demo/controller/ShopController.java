package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ShopSVC;
import com.example.demo.vo.BookVO;

@Controller
@RequestMapping("/shop")
public class ShopController
{
	@Autowired
	private ShopSVC svc;
	
	@GetMapping("/book/{page}") /* localhost:8080/shop/book/1 */
	public String show(@PathVariable("page")int pg, Model model) {
		model.addAttribute("list", svc.bookList());
		return "book_list";
	}
	
	@GetMapping("/book/detail/{no}")
	public String detail(@PathVariable("no")int no,Model m) {
		m.addAttribute("detail",svc.detail(no));
		return "book_detail";
	}
	
	@PostMapping("/book/tocart")
	@ResponseBody
	public String toCart(BookVO book
			//,@RequestParam("qty")int qty vo 에 추가
			) {
		//return book.getTitle()+", qty" +qty; bookvo 변경
		//return book.getTitle()+", qty" +book.getQty();
		return String.format("{\"incart\":%b}", svc.toCart(book));
	}
	
	@GetMapping("/book/showcart") /* /shop/book/showcart 화면보여줄때 Model 영역 저장*/
	public String showcart(Model m ) {
		m.addAttribute("list", svc.showCart());
		m.addAttribute("total", svc.getTotal());
		return "book_showcart";
	}
	
	@PostMapping("/book/updateqty")
	@ResponseBody
	public String updateQty(
			@RequestParam("no") int no,
			@RequestParam("qty") int qty ) {
		//Mpdel은 jsp에서 서블릿역활을 통해 문자열화 ajax는 못받음
		//그리고 ResponseBody는 Model 사용불가!
		System.out.println(svc.updateQty(no,qty));
		return String.format("{\"updated\":%b}", svc.updateQty(no,qty));
	}
	
}
