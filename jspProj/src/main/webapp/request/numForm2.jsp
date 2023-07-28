<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>numForm</h1>
	<form action="numReg2.jsp">
		<table border="">
			<tr>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>																
			</tr>
			<% for(int i = 0; i<5; i++){ %>		
			<tr>
				<td><input type="text" name="name" value="<%=(int)(Math.random()*10) + "name" %>"/></td>
				<td><input type="text" name="kor" value="<%=(int)(Math.random()*100)%>"/></td>
				<td><input type="text" name="eng" value="<%=(int)(Math.random()*100) %>"/></td>
				<td><input type="text" name="math" value="<%=(int)(Math.random()*100) %>"/></td>
			</tr>
			<% } %>			
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="계산" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>