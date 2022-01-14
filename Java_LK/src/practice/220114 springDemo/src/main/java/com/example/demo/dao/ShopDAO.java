package com.example.demo.dao;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.example.demo.vo.BookVO;

@Component
public class ShopDAO 
{
	private static String fpath = "C:/test/books.data";
	
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
}
