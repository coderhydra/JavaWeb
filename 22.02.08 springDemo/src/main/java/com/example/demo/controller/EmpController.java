package com.example.demo.controller;

import java.util.*;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.EmpSvc;
import com.example.demo.service.loginSvc;
import com.example.demo.vo.EmpVO;


@Controller
@RequestMapping("/emp")
public class EmpController {
  @Autowired
  private EmpSvc svc;
  
  @Autowired
  private EmpVO vo;
  
  @Autowired
  private loginSvc uSVC;

//   @GetMapping("/emp/add") 
  //@RequestMapping("/emp")
  @GetMapping("/add")
  public String inputForm(Model model) {
  	if(uSVC.isLogin()){
  		return "emp_inputForm";
  	} else {
  		model.addAttribute("msg","로그인 후에 사용해주세요");
  	return "user_loginform";
  	}
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
	return String.format("{\"deleted\": %b}", svc.delete(no));
}


@GetMapping("/report/{no}")
public String report(@PathVariable("no")int no ,Model m){
	//패스 경로에서 값을 가져옴.
	m.addAttribute("emp",svc.find(no));
	return "emp_detail";
	}

}