package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmpSvc;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.EmpVO2;


@Controller
@RequestMapping("/emp")
public class EmpController {
  @Autowired
  private EmpSvc svc;
  
  @Autowired
  private EmpVO vo;

//   @GetMapping("/emp/add") 
  //@RequestMapping("/emp")
  @GetMapping("/add")
  public String inputForm() {
  	return "emp_inputForm";
  }
	
  //@PostMapping("/emp/add")
  //@RequestMapping("/emp")
	@PostMapping("/add")
	@ResponseBody
  public boolean save( EmpVO vo
//  		@RequestParam("no") int no,
//  		@RequestParam("ename") String ename,
//  		@RequestParam("dept") int dept 
  		) { 
//		vo.setNo(no);
//		vo.setEname(ename);
//		vo.setDept(dept);
		boolean res = svc.Empsave(vo);
 	 return res;
  }
	
	// 이용자가 list를 요청한 경우 파일에서 emp 리스트를 
	// 모두 가져와서 화면에 보여준다
	@GetMapping("/list")
	public String list(Model m) {
		m.addAttribute("list", svc.list());
		return "emp_list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no,
			Model m) {
		System.out.println("svsres=="+no);
		m.addAttribute("emp",svc.find(no));
		return "emp_detail";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("no") int no, Model m) {
		m.addAttribute("emp", svc.find(no));
		return "emp_edit";
	}
	@PostMapping("/update")
	@ResponseBody
//  public String update(EmpVO vo) { 
//		boolean updated = svc.update(vo);
// 	 return String.format("{\"updated\":%b}", updated);
//  }
  public Map<String, Boolean> update(EmpVO vo) { 
		HashMap<String, Boolean> map = new HashMap<>();
		map.put("updated", svc.update(vo));
		return map;
  }

@GetMapping("/del")
@ResponseBody
public String del(@RequestParam("no") int no) {
	System.out.println("del");
	System.out.println("del jsStr"+svc.delete(no));
	return String.format("{\"deleted\": %b}", svc.delete(no));
}

}