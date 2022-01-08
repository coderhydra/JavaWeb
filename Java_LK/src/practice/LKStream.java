package practice;
//22.1.1 bbs 만들기! 작성자 작성일자 제목 내용
//Create Read Update Delete
import java.io.*;
import java.time.*;
import java.util.Scanner;

public class LKStream {

static Scanner kbd = new Scanner(System.in);
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();

public static void main(String[] args) {


	//txtReader();
	LKStream tw = new LKStream();
		String txt = tw.txtInput();
	System.out.println("입력하신 내용을 txt에 저장할까요? y/n");
	String q = kbd.next();
	if (q.equals("y")) {
		tw.txtWriter(txt); // 저장 메소드!  업데이트됨 전파일 지워짐!
	} else if (q.equals("n")) {
		System.out.println("저장 하지 않았습니다.");
	} else if ( !(q.equals("y") || q.equals("n")) ) {
		System.err.println("잘못 입력하셨습니다.");
		//다시 돌아가서 다시입력해주세요.
	}
	System.err.println("System END BYE~!");
	
	
} //end M

public static void txtReader( ) {
	String fileRoot = "/Users/lucas/JavaTest/lk.txt";
	File f = new File(fileRoot);
	try {
		FileReader fr = new FileReader(f); // Node 스트림(Source 스트림)
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line=br.readLine()) != null) {
		System.out.println(line);

		}
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void txtWriter(Object txt) {
	String fp = "/Users/lucas/JavaTest/lkcreate.txt";
	try {
		FileWriter fw = new FileWriter(fp);
		PrintWriter pw = new PrintWriter(fw);
		pw.printf("%s\t%s\n",date,time);//작성시간
		pw.print(txt);
		System.out.println("저장이 완료 되었습니다!");
		pw.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//내용입력받는 메소드
String txtInput() {
	System.out.println("내용 입력 :");
	String ti = kbd.nextLine();
	System.out.println("입력한 내용:");
	System.out.println(ti);
	return ti;
}


}// end C