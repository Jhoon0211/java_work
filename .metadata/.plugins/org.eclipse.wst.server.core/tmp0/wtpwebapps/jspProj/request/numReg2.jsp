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
	
	// 배열 가져오기
	String[] nameArr = request.getParameterValues("name");
	String[] korArr = request.getParameterValues("kor");
	String[] engArr = request.getParameterValues("eng");
	String[] mathArr = request.getParameterValues("math");
	
	// 
	int[] sum = new int[5];
	int[] avg = new int[5];
	
	for(int i=0; i<5; i++){
		// 총점
		sum[i] = Integer.parseInt(korArr[i]) + Integer.parseInt(engArr[i]) + Integer.parseInt(mathArr[i]);
		
		// 평균
		avg[i] = sum[i] / 3;
		
	}
	
	/* // 국어 총점
    int korsum = 0; // 총점
  
    for (String str : korArr) { // noArr String 명을 str로 설정
        int num = Integer.parseInt(str); // str을 정수형으로 형변환
        korsum += num;
    }
    
    // 영어 총점
    int engsum = 0; // 총점
    
    for (String str : engArr) { // noArr String 명을 str로 설정
        int num = Integer.parseInt(str); // str을 정수형으로 형변환
        engsum += num;
    }
    
    // 수학 총점
    int mathsum = 0; // 총점
    
    for (String str : mathArr) { // noArr String 명을 str로 설정
        int num = Integer.parseInt(str); // str을 정수형으로 형변환
        mathsum += num;
    } */
    
%>

<h1>numReg</h1>
	<table border="">
		<tr>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>		
			<td>평균</td>														
		</tr>
		<% for(int i = 0; i<5; i++){ %>		
		<tr>
			<td><input type="text" name="name" value="<%=nameArr[i]%>"/></td>
			<td><input type="text" name="kor" value="<%=korArr[i]%>"/></td>
			<td><input type="text" name="eng" value="<%=engArr[i]%>"/></td>
			<td><input type="text" name="math" value="<%=mathArr[i]%>"/></td>
			<td><input type="text" name="sum" value="<%=sum[i] %>"/></td>			
			<td><input type="text" name="avg" value="<%=avg[i] %>"/></td>			
		</tr>
		<% } %>			
	</table>

korArr:<%=Arrays.toString(korArr) %><br/>
<%-- 국어점수 총 합 : <%=korsum %> 점</br>
영어점수 총 합 : <%=engsum %> 점</br>
수학점수 총 합 : <%=mathsum %> 점</br></br> --%>

학생 1의 점수 : <%=korArr[0] + engArr[0] + mathArr[0] %></br>
학생 2의 점수 : <%=korArr[1] + engArr[1] + mathArr[1] %></br>
학생 3의 점수 : <%=korArr[2] + engArr[2] + mathArr[2] %></br>
학생 4의 점수 : <%=korArr[3] + engArr[3] + mathArr[3] %></br>
학생 5의 점수 : <%=korArr[4] + engArr[4] + mathArr[4] %>
<%-- 영어점수 총합 engArr:<%=Arrays.toString(korArr) %><br/>
수학점수 총합 mathArr:<%=Arrays.toString(korArr) %><br/> --%>

</body>
</html>