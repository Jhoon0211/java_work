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

	// 전체 선언부
	String[] nameArr = request.getParameterValues("name");
	String[] korArr = request.getParameterValues("kor");
	String[] engArr = request.getParameterValues("eng");
	String[] mathArr = request.getParameterValues("math");
	String[] gradeArr = new String[nameArr.length];
	int[] totArr = new int[nameArr.length];
	float[] avgArr = new float[nameArr.length];
	int[] rankArr = new int[nameArr.length];
	int[] scoreArr = new int[nameArr.length];
	
	// 초기화
	String name = null;
	int kor=0;
	int eng=0;
	int math=0;
	int tot = 0;
	int avg = 0;
	int buf = 0;
	int score = 0;

%>

<h1>examReg</h1>
	<table border="">
		<tr>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>		
			<td>평균</td>	
			<td>등급</td>
			<td>순위</td>																										
		</tr>
		
<% 
	// 입력부	
	for (int i = 0; i < nameArr.length; i++) {
		name = nameArr[i];
		kor = Integer.parseInt(korArr[i]);
		eng = Integer.parseInt(engArr[i]);
		math = Integer.parseInt(mathArr[i]);
		
	    // 총합
	    tot = kor + eng + math;
	    totArr[i] = tot;
	    
		// 평균
		avg = tot / 3;
	    avgArr[i] = avg;

	    
	 	// 등급 선정 배열 선언
	   	gradeArr[i] = "가가가가가가양미우수".charAt((int)avgArr[i]/10)+"";
	}
		 
		// avgArr[0~4] 평균값이 나옴   
	    for (int i = 0; i < nameArr.length; i++) { //arr0~4[i]번인덱스 반복
	    	rankArr[i]=1;
	    	for(int j=0; j < nameArr.length; j++){ //비교할 arr[j]0~4번인덱스 반복
		        if (totArr[i] < totArr[j]) {
		            rankArr[i]++;
		        }
	    	}
	    }
		
		//랭크값에 따른 정렬
	   	for (int me = 0; me < rankArr.length; me++) { //rank0~4[i]번인덱스 반복
	   		score=4;
			for (int you = 0; you < rankArr.length; you++) {
				if(rankArr[me]<rankArr[you]) { // 너가 나보다 랭킹값이 클때, 너의 값이 내거
					score --;
					
					
				}
			}
			scoreArr[score]=me;
			out.println(me+"번 index의 순위 : " + score + "등</br>" );
			
	   	}
			for (int i = 0; i < nameArr.length; i++) { //rank0~4[i]번인덱스 반복
				
 %>
		<tr>
			<td><%=nameArr[scoreArr[i]] %></td>
			<td><%=korArr[scoreArr[i]] %></td>
			<td><%=engArr[scoreArr[i]] %></td>
			<td><%=mathArr[scoreArr[i]] %></td>
			<td><%=totArr[scoreArr[i]] %></td>
			<td><%=avgArr[scoreArr[i]] %></td>
			<td><%=gradeArr[scoreArr[i]] %></td>
			<td><%=rankArr[scoreArr[i]] %></td>
		
			<%-- <td><input type="text" name="name" value="<%=name%>"/></td>
			<td><input type="text" name="kor" value="<%=kor%>"/></td>
			<td><input type="text" name="eng" value="<%=eng%>"/></td>
			<td><input type="text" name="math" value="<%=math%>"/></td>
			<td><input type="text" name="tot" value="<%=tot%>"/></td>			
			<td><input type="text" name="avg" value="<%=avg%>"/></td> --%>			 
		</tr>
<%} %>			
	</table>
</body>
</html>