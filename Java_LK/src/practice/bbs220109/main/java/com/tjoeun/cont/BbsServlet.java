package com.tjoeun.cont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.svc.BbsSvc;

@WebServlet("/bbs")
public class BbsServlet extends HttpServlet 
{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");

		String viewPath = new BbsSvc().exec(req, res);
		if(viewPath!=null) {
			getServletContext().getRequestDispatcher(viewPath).forward(req, res);
		}
	}
}