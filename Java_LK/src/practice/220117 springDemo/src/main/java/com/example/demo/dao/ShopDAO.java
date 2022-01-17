package com.example.demo.dao;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.example.demo.vo.BookVO;

@Component
public class ShopDAO 
{
	private static String fpath = "C:/test/books.data";
	private static String savePath = "C:/test/order.data";
	
	public List<BookVO> bookList(){
		List<BookVO> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			while((line=br.readLine())!=null) {
				list.add(new BookVO(line));
			}
			br.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BookVO bookdetail(int no) {
			BufferedReader br = null;
			String line = null;
			BookVO vo = null;
			try {
				br = new BufferedReader(new FileReader(fpath));
				while((line=br.readLine())!=null) {
					String[] token = line.split("\\|");
					int _no = Integer.parseInt(token[0]);
					if(_no==no) {
						vo = new BookVO();
						vo.setNo(_no);
						vo.setTitle(token[1]);
						vo.setPrice(Integer.parseInt(token[2]));
						vo.setPub(token[3]);
						vo.setPubdate(token[4]);
						vo.setDescribe(token[5]);
						break;
					}
				}
				br.close();
				return vo;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	public boolean saveOrder(String uid, List<BookVO> list) {
		long time = new Date().getTime();
		java.sql.Date ordDate = new java.sql.Date(time);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(savePath,true));
			for(int i=0; i<list.size(); i++) {
				BookVO b = list.get(i);
				pw.printf("%s|%d|%s|%d|%s|%s|%d|%S", 
				uid, b.getNo(), b.getTitle(),
				b.getPrice(),b.getPub(), b.getPubdate(),
				b.getQty(), ordDate);
				pw.println();
			}
			pw.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
