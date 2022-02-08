package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafTestController 
{
   @GetMapping("/test") 
   public String test(Model model) 
   { 
      List<String> list = new ArrayList<>();
      
      list.add("Hello");
      list.add("World");
      
      model.addAttribute("list", list);
      
      return "thymeleaf/main"; 
   } 
}
