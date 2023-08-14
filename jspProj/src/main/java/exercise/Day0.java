package exercise;

import java.util.Scanner;

public class Day0 {
	public static void main(String[] args) {
		
		String h="Hello World";
		
		System.out.println(h+"\n"+h+"\n"+h);	
		
		System.out.println("홍길동\n홍 길 동\n홍  길  동\n");
		
		String name="안재훈";
		String add="경기도 용인시";
		String hp ="010-2521-0999";
		
		System.out.printf("%s, %s, %s", name, add, hp);
		System.out.println("\n============================");
		
		String adnum1="123";
		String adnum2="456";
		System.out.printf("제가 사는곳의 번지수는 %s-%s 입니다.", adnum1, adnum2);
		
		System.out.println(10+5+"a"); // 15a
		System.out.println("a"+10+5); // a105
		System.out.println('a'+10+5); // 112
		
		//Scanner scan = new Scanner(System.in);
		//int a=scan.nextInt();
		//int b=scan.nextInt();
		//System.out.println(a+b);
		//System.out.println(a*b);
		
		
		Scanner scan2 = new Scanner(System.in);
		//int c=scan2.nextInt();
		//int num1=scan2.nextInt();
		//int num2=scan2.nextInt();
		//int num3=scan2.nextInt();
		//int sum = num1+num2+num3;
		//System.out.printf("%d*%d*%d=%d", num1, num2, num3, sum);
		
		Scanner scan3 = new Scanner(System.in);
		//int c=scan2.nextInt();
		int num4=scan2.nextInt();
		int gob = num4*+num4;
		System.out.printf("%d*%d=%d", num4, num4, gob);
		
		
	}
}











