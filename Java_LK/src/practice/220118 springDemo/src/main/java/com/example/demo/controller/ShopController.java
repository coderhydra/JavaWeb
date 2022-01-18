package com.example.demo.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

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
	
	@GetMapping("/report/detail/{no}")
	public String rDetail(@PathVariable("no")int no,Model m) {
		m.addAttribute("detail",svc.rDetail(no));
		return "order_detail";
	}
	
	@GetMapping("/report")
	public String report(Model m) {
		m.addAttribute("list", svc.report());
		return "report";
	}
	
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
	
	@GetMapping("/report/del/{no}")
	public String reportdel(@PathVariable("no")int no,Model m) {
		//report에서 삭제하는 기능
  	svc.reportdel(no);
     return "report";
  }
	
	@GetMapping("/report/delete/{no}")
	@ResponseBody
	public String rdel(@PathVariable("no")int no,Model m) {
  	boolean deleted = svc.rdelete(no);
     return String.format("{\"deleted\"%b}", deleted);
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
  public Map<String, Object> updateQty(@RequestParam("no")int no,
                    @RequestParam("qty")int qty) {
     boolean updated = svc.updateQty(no, qty);
     int total = svc.getTotal();
     
     String sTotal = NumberFormat.getInstance().format(total);  //정수가 문자열로 바뀜
     
     Map<String, Object> map = new HashMap<>();
     map.put("updated", updated);
     map.put("total", sTotal);
     return map;
  }
  
  @GetMapping("/book/del/{no}")
  public String deleteBook(@PathVariable("no")int no, Model model) {
  	svc.delete(no);
     return "redirect:/shop/book/showcart";
  }
  
  @GetMapping("/book/cartempty")
  public String cartEmpty() {
     svc.cartEmpty();
     return "redirect:/shop/book/showcart";
  }
  
  @GetMapping("/book/order")
  @ResponseBody
  public String order() {
     boolean ok = svc.order();
     return String.format("{\"ok\":%b}", ok);
  }
  

}