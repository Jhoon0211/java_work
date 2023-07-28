<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_third</title>
</head>
<body>
<h1>03_third</h1>

<%!

	// declaration : 클래스 정의부
	
	// 멤버 변수
	String name = "나는 문어";
	int age = 27;
	boolean marriage = true;
	
	void meth_1(){
		System.out.println("meth_01() 실행");
	}
	
	// System.out.println("정의부에서 실행구문 불가");
	
	public void jspInit() {
		System.out.println("jspInit() 실행");
	}
	
	public void jspDestroy() {
		System.out.println("jspdestroy() 실행");
	}
%>

<%!

	// int age = 23; 멤버변수 중첩 불가
	int [] arr = {11, 22, 33, 44 ,55};

%>

<%

	// scriptlet :: _jspService()
	System.out.println("scriptlet 실행:" + age);
	int age = 23; // 지역 변수 ::> 멤버변수와 중첩 가능
	System.out.println("scriptlet 실행:" + age);
	// int age = 17; 지역변수 중첩 불가
	
	String str = "아기상어";
	/* // 메소드 정의 불가 --> scriptlet은 :: _jspService() 인 메소드 이므로 중첩 정의 불가
	void meth_2(){
		System.out.println("meth_01() 실행");
	}
	*/
	
	// 내장 객체
	out.println("str:" + str);
%>

</body>
</html>