package practice;

import java.util.Random;
import java.util.Scanner;

class Record {
	//제비뽑기 기록 & 출력
	String name;
	int num;
//	static boolean exi = false;
	
	Record(){}
	public Record(String name, int num) {
		setName(name);
		setNum(num);
	}
	void print() {
		System.out.printf("%s가 뽑은 수는 %d! \n", getName() , getNum());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}		
}//end C

public class LKArray2 {

	public static void main(String[] args) {
		
		//재비뽑기 프로그램
		LKArray2 run = new LKArray2();
		//run.lot();
		// 회원 검색!
		//run.search(run.input());
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("제비뽑기:1 회원검색:2 종료는 다른 아무키를 누르세요");
			String pick = sc.nextLine();
			
				if (pick.equals("1")) {
					run.lot();
					continue;
				} else if (pick.equals("2")) {
						run.search(run.input());
						continue;
						}
				
				System.err.println("프로그램 종료!");
				break;
			}
		
		
	} //end M
	
	void lot() {
		 // 4명의 렌덤제비점수를 이름과 함께 기록!
		Random rd = new Random();
//		int[] sv = new int[4];
//		for (int i=0; i<sv.length; i++) {
//			sv[i]= rd.nextInt(99);
//		}
		String[] mem = new String[4];
		mem[0] = "Lucas";
		mem[1] = "Yona";
		mem[2] = "Huhu";
		mem[3] = "Shine";
		
		Record[] lot = new Record[4];
		for (int i=0; i<lot.length; i++) {
			lot[i] = new Record(mem[i],/*sv[i]*/ rd.nextInt(99));
			lot[i].print();
		}
	}
	String input () {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 회원명");
		String name = sc.nextLine();
		return name;
	}
	void search(String name) {

		String[] list = new String[4];
		list[0] = "lucas";
		list[1] = "yona";
		list[2] = "huhu";
		list[3] = "shine";
		for (int i=0; i<list.length; i++) {
			if (list[i].equals(name)) {
			System.out.println("리스트에 존재하는 이름");
			return; //break; 상관 없음
			}else {
				System.out.println("리스트에 이름이 존재하지 않습니다.");
				return; //break; 안됨	
			}
		}	
	}
}//end C
