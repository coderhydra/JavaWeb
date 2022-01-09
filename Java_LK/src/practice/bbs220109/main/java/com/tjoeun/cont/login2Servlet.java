package com.tjoeun.cont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.svc.login2Svc;

@WebServlet("/login2"
		+ "")
public class login2Servlet extends HttpServlet {
            
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String viewPath = new login2Svc(req,res).exec();
		
		if(viewPath!=null) {
			getServletContext().getRequestDispatcher(viewPath).forward(req, res);
		}
	}

}
