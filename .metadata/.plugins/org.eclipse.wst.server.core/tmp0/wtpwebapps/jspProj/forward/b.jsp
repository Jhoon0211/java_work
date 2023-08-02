<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include > b</title>
</head>
<body>
<h2>include > b</h2>
pname:<%=request.getAttribute("pname") %><br/>
age:<%=request.getParameter("age") %><br/>
nick:<%=request.getParameter("nick") %><br/>
</body>
</html>