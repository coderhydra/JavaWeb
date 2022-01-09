package com.tjoeun.svc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.dao.BBSDAO;
import com.tjoeun.vo.BBSVO;

public class BbsSvc 
{
	public String exec(HttpServletRequest req, HttpServletResponse res) {
		String cmd = req.getParameter("cmd");
		String viewPath = null;
		if(cmd==null) {
			viewPath = "/bbs2/index.jsp";
		}
		else if(cmd.equals("list")) {
			BBSDAO dao = new BBSDAO();
			List<BBSVO> list = dao.getList();
			req.setAttribute("list", list);
			viewPath = "/bbs2/bbs_list.jsp";
		}
		else if(cmd.equals("read")) {
			BBSDAO dao = new BBSDAO();
			String sNum = req.getParameter("num");
			BBSVO board = dao.getBoard(Integer.parseInt(sNum));
			req.setAttribute("board", board);
			viewPath = "/bbs2/bbs_read.jsp";
		}
		else if(cmd.equals("input")) {
			viewPath = "/bbs2/bbs_input.jsp";
		}
		else if(cmd.equals("save")) {
			String author = req.getParameter("author");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			BBSDAO dao = new BBSDAO();
			BBSVO bbs = new BBSVO();
			bbs.setAuthor(author);
			bbs.setTitle(title);
			bbs.setContent(content);
			boolean saved = dao.insert(bbs);
			/*
			req.setAttribute("saved", saved);
			viewPath = "/bbs2/bbs_save_result.jsp";
			*/
			try {
				res.setContentType("application/json; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.printf("{\"saved\":%b}", saved);
				out.flush();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(cmd.equals("save_check")) {
			String author = req.getParameter("author");
			BBSDAO dao = new BBSDAO();
			BBSVO bbs = dao.saveCheck(author);
			req.setAttribute("board", bbs);
			viewPath = "/bbs2/bbs_read.jsp";
		}
		else if(cmd.equals("edit")) {
			int num = Integer.parseInt(req.getParameter("num"));
			BBSDAO dao = new BBSDAO();
			BBSVO board = dao.getBoard(num);
			req.setAttribute("board", board);
			viewPath = "/bbs2/bbs_edit.jsp";
		}
		return viewPath;
	}

}
