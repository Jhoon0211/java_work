<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="res_form.jsp">
		<table border="">
			<tr>
				<td>이름</td>
				<td><input type="text" name="pname"/></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth"/></td>
			</tr>
			<tr>
				<td>주민등록번호 뒷자리</td>
				<td><input type="text" name="rescode"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="제출"></input>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>