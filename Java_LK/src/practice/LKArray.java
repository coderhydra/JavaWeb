package practice;

import java.util.*;

public class LKArray {

	public static void main(String[] args) {

		LKArray run = new LKArray();	
		while (true) {
			run.Run();
		}
	}
	void Run() {
		//요일을 구하고자 하는 년, 월, 일을 사용자로부터 입력받는다.
		Scanner kbd = new Scanner(System.in);
		System.out.print("알고 싶은 날짜(YYYY MM DD) 요일은?");
		int year = kbd.nextInt();
		int month = kbd.nextInt();
		int day = kbd.nextInt();
		//kbd.close();  오류 스케너 사용을 종료하는 메소드!
		
		/* 1step
		 * 전년도까지의 날수를 계산
		 * 윤년 계산
		 * 3년에 한 번씩은 윤년이 아님
		 * 100년에 한 번씩은 4년으로 나누어져도 윤년이 아님
		 * 400년에 한 번씩은 윤년
		 */
		
		int preYear = year-1;

		int leepYear = year/4 - year/100 + year/400;
		System.out.printf("%d년의 윤년이 있었습니다.\n ", leepYear);
		int numOfDays = preYear*365 + leepYear ;
		
		/* 2step
		 * 입력받은 년도의 입력 받은 월 전월까지의 날수를 기존에 계산된 날수에 추가
		 */
		int[] monthArray =  {31,28,30,31,31,30,31,31,30,31,30,31};
		for (int i=0; i<(month-1); i++) {
			numOfDays += monthArray[i]; 
		}
		
		/* 3step
		 * 입력받은 년도가 윤년이면서, 입력받은 월이 3월 이상인 경우는 기존 계산에 1추가
		 * 2월을 28일로 계산 했으므로 윤년인 경우 보정 
		 */
		
		if (month>3 && (year%4==0 && year%100!=0 || year%400==0)) {
			numOfDays++;
		}
		
		/* final step
		 * 입력받은 일까지의 날짜수 추가
		 */
		numOfDays += day;
		
		// 실수 계산값을 7로 나눈 나머지 구하기. 요일 배열의 [방번호].
		int dayOfWeek = numOfDays % 7;
		
		// 나머지 값에 따라서 적당한 요일 출력
		String[] dayArray = {"일","월","화","수","목","금","토"};
		System.out.printf("%d월 %d일는(은) 1월 1일로 부터: %,d일 이고 %n",
				month, day, numOfDays);
		System.out.printf("%s요일 입니다!\n", dayArray[dayOfWeek]);
		
	}
} // end
