package com.example.demo.service;

import java.io.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.vo.loginVO;
@Service
public class loginSvc {

	
		private static String fpath = "D:/JAVATEST/users.txt";
		private HttpSession session;
		
		@Autowired //Constructor Injection
		public loginSvc(HttpSession session) {
			this.session = session;
		}
		
		public boolean isLogin() {
			return (session.getAttribute("uid")!=null);
		}
		
			public boolean login(loginVO u) {
				BufferedReader br = null;
				String line = null;
				String uid = u.getUid();
				String pwd = u.getPwd();
				try {
					br = new BufferedReader(new FileReader(fpath));
					while((line=br.readLine())!=null) {
						String[] token = line.split(" ");
						String id= token[0];
						String pw= token[1];
						if( id.equals(uid) && pwd.equals(pwd)) {
							br.close();
							return true;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
}
