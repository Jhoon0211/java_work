<%@page import="model_p.PageData"%>
<%@page import="model_p.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageData pd = (PageData)request.getAttribute("pd");
	BoardDTO dto = (BoardDTO)request.getAttribute("mainData");
%>    
<!-- 파일 삭제 -->
<script>
	function fileDel() {
		// var myFrm = document.myFrm
		// alert("눌렀냐?") == 연결 TEST
		
		// 삭제 실행 후 BFileDelete로 연결
		myFrm.action="BFileDelete?page=<%=pd.page %>"
		myFrm.submit()
	}
</script>

<form name="myFrm" action="BModifyReg?page=<%=pd.page %>" method="post" enctype="multipart/form-data">
	<table border="">
		<tr>
			<td width="200px">id</td><td width="700px">
				<input type="text" name="id" value="<%=dto.getId() %>" readonly/>
			</td>
		</tr>
		<tr>	
			<td width="100px">제목</td>
			<td width="800px"><input type="text" name="title" value="<%=dto.getTitle() %>"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" value="<%=dto.getPname() %>" /></td>
		<!-- 작성일 % 조회수는 확인용 -->
		<tr>
			<td>작성일</td>
			<td><%=dto.getReg_dateStr() %></td>
		</tr>
		<tr>
			<td>조회수</td><td><%=dto.getCnt() %></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="password" name="pw" /></td>
		</tr>
		<!-- 답변 수정에는 파일기능이 존재하지 않게 -->
		<% if(dto.getSeq()==0) { %>
		<tr>
			<td>파일</td>
			<td>
			<!-- 파일이 있다면 삭제, 파일이 없다면 업로드 가능하게 구현 -->
			<% if(dto.getUpfile().equals("")) { %>
			<input type="file" name="upfile" />
			<% } else { %>
				<%=dto.getUpfile() %><input type="button" value="파일삭제" onclick="fileDel()"/>
			<% } %>
			</td>
		</tr>
		<% } %>
		<tr>
			<td>내용</td>
			<td><textarea name="content" id="" cols="30" rows="10"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기"/>
				<input type="reset" value="초기화"/>
				<a href="BDetail?id=<%=dto.getId() %>&page=<%=pd.page%>">뒤로</a>
			</td>
		</tr>
	</table>
</form>