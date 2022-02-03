package com.example.demo.Lamda;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest 
{
	@FunctionalInterface //함수형 인터페이스의 문법 검사를 컴파일러에게 의뢰함
	public interface SUM 
	{
		public int add(int a, int b);
	}// 인터페이스 안에 메소드를 한개!!!만 가지고 있다.

	@FunctionalInterface
	public interface AVG
	{
		public int avg(List<Integer> list);  /* (li)->{return 평균;} */
	}
	
	public static void main(String[] args) 
	{
		/* 클래스의 상속 및 오버라이드 예 */
		class MyThread/*부모 클래스*/ extends Thread /*자식 클래스*/ 
		{
			@Override
			public void run() {
				System.out.println("실행");
			}
		}
		Thread t1 = new MyThread();
		//t1.start();
		
		/* 익명 클래스(Anonymous Class)로 구현한 쓰레드 */
		Thread t = new Thread/*부모클래스 이름없으니 선언과 동시에 실행
				다른 곳에서 호출할 필요없는 로직__일회성?
				익명클래스는 반드시 상속이나 구현을 해야함 즉 부모가 있어야 함
				*/
				() {
			/*^^^ 익명 표현*/
			@Override //상속해오면서 개조하겠다. (문법검사...)
			public void run() {
				System.out.println("실행");
			}
		};
		//t.start();
		
		/* 익명 클래스의 객체를 참조변수 없이 사용하는 예 
		new Thread() {
			@Override
			public void run() {
				System.out.println("실행");
			}
		}.start(); */
		
		/* 익명 클래스의 객체를 아규먼트로 받아서 사용하는 예
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("실행");
			}
		}).start(); */
		/*일회성으로 사용할것이기 떄문에 객체생성/클래스 선언/매소드 한번에....
		 * 인터페이스는 able을 관례적으로 명명시 붙여준다.
		 */
		
		/* 함수형 인터페이스를 사용하는 예(Lambda Expression) */
		new Thread(()->{
			System.out.println("실행");
		}).start();
		
		//Sum mul = (a,b)->{return a+b;};
		SUM mul =  (a,b)->a+b;  // SUM인터페이스의 add()메소드 구현
		test(mul);
		test( (a,b)->a+b );  // 위와 동일한 표현
		
		
		/*List<Integer>를 파라미터로 받아서 평균을 구하여 리턴하는 함수형 인터페이스를
		  선언하고 다른 메소드에 전달하여 평균을 출력해보세요.
		*/
		
		List<Integer> list = new ArrayList<>();
		list.add(1); list.add(3); list.add(5);
		
		AVG avgObj = li->{
//		AVG avgObj /*(li)*/li/*파라미터 변수 선언*/->{
			int sum = 0;
			for(int i=0;i<li.size();i++) {
				sum += li.get(i);
			}
			return sum/li.size();
		};
		System.out.println(avgObj.avg(list));
		
		test2(list, li->{ // 파라미터가 있을 때는 '()' 생략가능
			int sum = 0;
			for(int i=0;i<li.size();i++) {
				sum += li.get(i);
			}
			return sum/li.size();
		});
	}
	
	public static void test(SUM sum) {
		System.out.println(sum.add(3,5));
	}
	
	public static void test2(List<Integer> list, AVG a) {
		System.out.println(a.avg(list));
	}
}
