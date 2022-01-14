package com.example.demo.service;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.vo.EmpVO;

@Service //@Service 선언 기본생성자 셋 겟 필수~!
public class EmpSvc {

	private static String fpath = "D:/JAVATEST/emp.txt";

		public boolean Empsave(EmpVO emp) {
			
		File f = new File(fpath);
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			String str = String.format("%d|%s|%d", emp.getNo(),
					emp.getEname(),emp.getDept());
			pw.print(str);
			pw.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	 public List<EmpVO> list() {
     BufferedReader br = null;
     String line = null;
     List<EmpVO> list = new ArrayList<>();
     try {
        br = new BufferedReader(new FileReader(fpath));
        while((line=br.readLine())!=null) {
           String[] token = line.split("\\|");
           EmpVO emp = new EmpVO();
           emp.setNo(Integer.parseInt(token[0]));
           emp.setEname(token[1]);
           emp.setDept(Integer.parseInt(token[2])); 
           list.add(emp);
        }
        br.close();
        return list;
     } catch (Exception e) {
        e.printStackTrace();
     }
     return null;
  }
	 
		public EmpVO find(int no) {
			BufferedReader br = null;
			String line = null;
			EmpVO emp = null;
			try {
				br = new BufferedReader(new FileReader(fpath));
				while((line=br.readLine())!=null) {
					String[] token = line.split("\\|");
					int _no = Integer.parseInt(token[0]);
					if(_no==no) {
						emp = new EmpVO();
						emp.setNo(_no);
						emp.setEname(token[1]);
						emp.setDept(Integer.parseInt(token[2]));
						emp.setSalary(Integer.parseInt(token[3]));
						System.out.println(Integer.parseInt(token[0]));
						break;
					}
				}
				br.close();
				return emp;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	

		public boolean update(EmpVO emp) {
			System.out.println(" update check");

			BufferedReader br = null;
			String line = null;
			List<String> list = new ArrayList<>();
			try {
				br= new BufferedReader(new FileReader(fpath));
				while((line=br.readLine()) !=null) {
					String[] token = line.split("\\|");
					if(token[0].equals(emp.getNo()+"")) {
							line = String.format("%d|%s|%d|%d", emp.getNo(),
									emp.getEname(),emp.getDept(),emp.getSalary());
					}
					list.add(line);
					}
				br.close();
				return overwrite(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		private boolean overwrite(List<String> list) {
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(fpath));
				for (int i=0; i<list.size(); i++) {
					pw.println(list.get(i));
				}
				pw.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean delete(int no) {
			BufferedReader br = null;
			String line = null;
			List<String> list = new ArrayList<>();
			try {
				br= new BufferedReader(new FileReader(fpath));
				while((line=br.readLine()) !=null) {
					String[] token = line.split("\\|");
					if(token[0].equals(no+"")) {
						continue;
						// list.add(null); 리스트 색션? 이 남음
					}
					list.add(line);
					}
				br.close();
				return overwrite(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

 }



