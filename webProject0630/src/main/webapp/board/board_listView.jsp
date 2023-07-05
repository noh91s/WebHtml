<%@page import="org.web.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<BoardDto> boards=
(ArrayList<BoardDto>) request.getAttribute("boards");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 페이지</title>
</head>
<body>
<body>
<div class="gnb">
	<ul>
		<li> <a href="index.do">HOME</a> </li>
		<li> <a href="member_index.mo">회원 메인페이지</a> </li>
		<li> <a href="member_join.mo">회원 등록</a> </li>
		<li> <a href="member_list.mo">회원 목록</a> </li>
		<li> <a href="board_index.bo">게시글 메인페이지</a> </li>
		<li> <a href="board_write.bo">게시글 등록</a> </li>
		<li> <a href="board_list.bo">게시글 목록</a> </li>
	</ul>
</div>
<h1>게시글목록</h1>
<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글내용</th>
			<th>글쓴이</th>
			<th>등록날짜</th>
			<th>상세페이지</th>
		</tr>
		<%
		for (BoardDto board : boards) {
		%>
		<tr>
			<td><%=board.getBoard_id()%></td>
			<td><%=board.getBoard_title()%></td>
			<td><%=board.getBoard_content()%></td>
			<td><%=board.getBoard_writer()%></td>
			<td><%=board.getCreate_time()%></td>
			<td><a href="board_detail.bo?board_id=<%=board.getBoard_id()%>">수정</a></td>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>