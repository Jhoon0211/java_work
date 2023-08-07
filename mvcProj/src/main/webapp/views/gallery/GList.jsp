<%@page import="java.util.List"%>
<%@page import="model_p.GalleryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="">
	<tr align="center">
		<td width="50px">번호</td>
		<td width="500px">제목</td>
		<td width="100px">작성자</td>
		<td width="200px">작성일</td>
		<td width="50px">조회수</td>
	</tr>
<%
	int i=0;

	for(GalleryDTO gto : (List<GalleryDTO>) request.getAttribute("mainData")) {
	i++;
%>
	<tr align="center">
		<td><%=gto.getId() %></td>
		<td>
			<img width="100px" src="/mvcProj/up/<%=gto.getUpfile() %>" alt="" />
		</td>
		<td><%=gto.getPname() %></td>
		<td><%=gto.getReg_date() %></td>
		<td><%=gto.getCnt() %></td>
	</tr>
<% } %>
	<tr>
		<td colspan="5"  align="right">
			<a href="">글쓰기</a>
		</td>
	</tr>
</table> 