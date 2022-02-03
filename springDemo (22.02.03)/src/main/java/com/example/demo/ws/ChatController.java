package com.example.demo.ws;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController 
{
// 인덱스 중복 주석처리
//    @RequestMapping(value="/")
//    public String main() {
//        return "index";
//    }
    
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Locale locale, Model model) {
        return "chat";
    }
}