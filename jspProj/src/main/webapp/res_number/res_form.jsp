<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//이름, 주민번호 선언
	String [] pnameArr = request.getParameterValues("pname");
	String [] birthArr = request.getParameterValues("birth");
	String [] rescodeArr = request.getParameterValues("rescode");
	
	/* int [] foreign = {5,6,7,8}; */
	LocalDate now = LocalDate.now();
	int nowTime = Integer.parseInt("now");
	
	/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd"); */
	
	// 외국인 회원
	 if(rescodeArr[0].charAt(0) == 5 || rescodeArr[0].charAt(0) == 6 
		|| rescodeArr[0].charAt(0) == 7 || rescodeArr[0].charAt(0) == 8) {
			response.sendRedirect("foreign.jsp");	
	}else if(birthArr[0].charAt(0){
		response.sendRedirect("normal.jsp");	
	} 

	
	

	
	

%>
<%=pnameArr[0] %>
<%=birthArr[0].charAt(0) %>
<%=rescodeArr[0] %>
<%="현재날짜 : " + sdf %> 
</body>
</html>