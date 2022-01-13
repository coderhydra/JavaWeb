package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ShopSVC;

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
}
