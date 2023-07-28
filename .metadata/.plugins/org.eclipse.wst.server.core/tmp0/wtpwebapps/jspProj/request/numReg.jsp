<%@page import="java.util.Arrays"%>
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
    
	String[] noArr = request.getParameterValues("no");

    int sum = 0; // 짝수 합
    for (String str : noArr) { // noArr String 명을 str로 설정
        int num = Integer.parseInt(str); // str을 정수형으로 형변환

        out.println(str); // 정수형으로 넘어왔음
        // str(=noArr의 형변환 ver) 중 짝수인 것을 찾아야 함
        if (num % 2 == 0) { // 만약 넘어온 noArr의 값 중 짝수가 존재한다면
            sum += num; // 값을 누적
        }
    }
%>

<h1>numReg</h1>
no:<%=request.getParameter("no") %><br/>
noArr:<%=Arrays.toString(noArr) %><br/>
sum = <%=sum %>
</body>
</html>