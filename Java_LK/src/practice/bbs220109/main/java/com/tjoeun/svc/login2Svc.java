package com.tjoeun.svc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.dao.login2DAO;
import com.tjoeun.vo.login2VO;

public class login2Svc {

		private HttpServletRequest req;
		private HttpServletResponse res;
		private String cmd;
		
		public login2Svc() {}

		public login2Svc(HttpServletRequest req, HttpServletResponse res) {
			this.req = req;
			this.res = res;
			this.cmd = req.getParameter("cmd");
		}

		
		public String exec() {
			System.out.println("exec: "+cmd);
			if (cmd==null) {
				String add = "/bbs2/login2.jsp";
				return add;
			}
			switch(cmd) {
			case "login": return login();
			default: System.out.println("Error");
				return null;
			}
		}
		
		private String login() {
			String id = req.getParameter("uid");
			String pwd = req.getParameter("pwd");
			System.out.println("암호" +pwd);
			int nPwd = Integer.parseInt(pwd);
			login2VO user = new login2VO();
			user.setName(id);
			user.setNum(nPwd);
			
			login2DAO loginDao = new login2DAO();
			boolean ok = loginDao.login(user);
			
			if (ok) {
				req.getSession().setAttribute("uid", id);
			}
			
			try {
				res.setContentType("application/json; charset=utf-8");
				PrintWriter out = res.getWriter();
				String jsStr = String.format("{\"login\":%b}", ok);
				//System.out.println("서버측 응답"+jsStr);
				out.print(jsStr);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		


	
}
