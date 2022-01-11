package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.vo.EmpVO;
import com.example.demo.vo.EmpVO2;

@Service //@Service 선언 기본생성자 셋 겟 필수~!
public class EmpSvc {

	private static String fpath = "D:/JAVATEST/emp.txt";

	public boolean Empsave(EmpVO2 emp) {
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
	
	 public List<EmpVO2> list() {
     BufferedReader br = null;
     String line = null;
     List<EmpVO2> list = new ArrayList<>();
     try {
        br = new BufferedReader(new FileReader(fpath));
        while((line=br.readLine())!=null) {
           String[] token = line.split("\\|");
           EmpVO2 emp = new EmpVO2();
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
	 
		public EmpVO2 find(int no) {
			BufferedReader br = null;
			String line = null;
			EmpVO2 emp = null;
			try {
				br = new BufferedReader(new FileReader(fpath));
				while((line=br.readLine())!=null) {
					String[] token = line.split("\\|");
					int _no = Integer.parseInt(token[0]);
					System.out.println("adfadsf=="+Integer.parseInt(token[0]));
					if(_no==no) {
						emp = new EmpVO2();
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
	
	 
		public boolean EmpEdit(EmpVO2 emp) {
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
	 
}


