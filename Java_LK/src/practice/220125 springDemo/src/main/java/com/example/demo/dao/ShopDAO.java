package com.example.demo.dao;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.orderVO;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

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
			int maxOrdNum = getMaxOrdNum();
			PrintWriter pw = new PrintWriter(new FileWriter(savePath,true));
			for(int i=0; i<list.size(); i++) {
				BookVO b = list.get(i);
				pw.printf("%d|%s|%d|%s|%d|%s|%s|%d|%S", 
				i+maxOrdNum+1 ,uid, b.getNo(), b.getTitle(),
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

	private int getMaxOrdNum() {
		String line = null;
		String lastLine = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(savePath));
			while((line=br.readLine())!=null){
				lastLine = line;
			}
			br.close();
			return Integer.parseInt(lastLine.split("\\|")[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int total() {
		List<BookVO> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			while((line=br.readLine())!=null) {
				list.add(new BookVO(line));
			}
			int total=0;
			for (int i=0 ; i<list.size(); i++) {
				BookVO order = list.get(i);
				total += order.getPrice()*order.getQty();
			}
			br.close();
			return total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;	
	}
	
	public List<orderVO> report() {
		List<orderVO> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			while((line=br.readLine())!=null) {
				list.add(new orderVO(line));
			}
			br.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
		}


	public int rtotal() {
		List<orderVO> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			while((line=br.readLine())!=null) {
				list.add(new orderVO(line));
			}
			int total=0;
			for (int i=0 ; i<list.size(); i++) {
				orderVO order = list.get(i);
				total = order.getPrice()*order.getQty();
//				System.out.println("dao---"+order.getPrice());
				return total;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;	
	}

	public orderVO orderdetail(int no) {
		BufferedReader br = null;
		String line = null;
		orderVO vo = null;
		try {
			br = new BufferedReader(new FileReader(savePath));
			while((line=br.readLine())!=null) {
				String[] token = line.split("\\|");
				int _oNo = Integer.parseInt(token[0]);
				if(_oNo==no) {
					vo = new orderVO();
					vo.setoNum(_oNo);
					vo.setUid(token[1]);
					vo.setNo(Integer.parseInt(token[2]));
					vo.setTitle(token[3]);
					vo.setPrice(Integer.parseInt(token[4]));
					vo.setPub(token[5]);
					vo.setPubdate(token[6]);
					vo.setQty(Integer.parseInt(token[7]));
					vo.setoDate(token[8]);
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

	public void reportdel(int no) {
		List<orderVO> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			orderVO vo = null;
			while((line=br.readLine())!=null) {
				String[] token = line.split("\\|");
				int _oNo = Integer.parseInt(token[0]);
				if(_oNo==no) {
					System.out.println("delete");
					System.out.println(line);
					continue;
				}
				vo.setoNum(Integer.parseInt(token[0]));
				vo.setUid(token[1]);
				vo.setNo(Integer.parseInt(token[2]));
				vo.setTitle(token[3]);
				vo.setPrice(Integer.parseInt(token[4]));
				vo.setPub(token[5]);
				vo.setPubdate(token[6]);
				vo.setQty(Integer.parseInt(token[7]));
				vo.setoDate(token[8]);
				list.add(vo);
//			PrintWriter pw = new PrintWriter(new FileWriter(savePath));
//			//객체생성시 오버라이트 되므로 삭제됨
//			//PrintWriter pw = new PrintWriter(new FileWriter(savePath,true)); 이어쓰기
//			pw.print(line);
				roverwrite(list);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void roverwrite(List<orderVO> data) {
	try {
		PrintWriter pw = new PrintWriter(new FileWriter(savePath));
		for(int i=0; i<data.size(); i++) {
			orderVO b = data.get(i);
			pw.printf("%d|%s|%d|%s|%d|%s|%s|%d|%s", 
			b.getoNum(), b.getUid() , b.getNo(), b.getTitle(),
			b.getPrice(),b.getPub(), b.getPubdate(),
			b.getQty(), b.getoDate());
			pw.println();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

		
	}

	public boolean orderDel(int no) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			List<String> list = new ArrayList<>();
			while((line=br.readLine())!=null) {
				if(line.split("\\|")[0].equals(""+no)) continue;
				list.add(line);
			}
			return overwrite(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean orderDel2(int no) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(savePath));
			String line = null;
			List<orderVO> list = new ArrayList<>();
			while((line=br.readLine())!=null) {
				if(line.split("\\|")[0].equals(""+no)) continue;
				list.add(new orderVO(line));
			}
			return overwrite2(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean overwrite(List<String> list) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(savePath));
			for(int i=0; i<list.size(); i++) {
				pw.println(list.get(i));
			}
			pw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
	private boolean overwrite2(List<orderVO> list) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(savePath));
			for(int i=0; i<list.size(); i++) {
				pw.println(list.get(i));
			}
			pw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
}	
