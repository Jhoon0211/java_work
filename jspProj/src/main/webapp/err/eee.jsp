<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/excep/ex02.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eee</title>
</head>
<body>
<h1>eee 입니다.</h1>
<%
	int [] arr = {11,22,33,44};
	
	out.println("정상 실행 2 : " + arr[7] + "<br/>");
%>
</body>
</html>