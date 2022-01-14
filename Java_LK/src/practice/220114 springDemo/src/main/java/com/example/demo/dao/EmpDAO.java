package com.example.demo.dao;

import java.io.*;

public class EmpDAO {

	
	public boolean Empsave(int no, String ename, int dept) {
		String fpath = "D:/JAVATEST/emp.txt";
		File f = new File(fpath);
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			String str = String.format("%d|%s|%d", no,ename,dept);
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
