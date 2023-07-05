<%@page import="org.web.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BoardDto boardDetail 
= (BoardDto) request.getAttribute("boardDetail");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
</head>
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
<h1>게시글 상세조회</h1>
<form action="board_update.bo" method="POST">
		글번호: <input type="text" name="board_id" id="board_id"
			value="<%=boardDetail.getBoard_id()%>" readonly="true" /> <br /> 
			글제목: <input type="text" name="board_title" id="board_title"
			value="<%=boardDetail.getBoard_title()%>" /> <br /> 
			글내용: <input type="text" name="board_content" id="board_content"
			value="<%=boardDetail.getBoard_content()%>" /> <br /> 
			글쓴이: <input type="text" name="board_writer" id="board_writer"
			value="<%=boardDetail.getBoard_writer()%>" readonly="true" /> <br /> 
			작성일: <span><%=boardDetail.getCreate_time()%></span>
		<br /> <input type="submit" value="게시글수정실행" />
	</form>
	<form action="board_delete.bo" method="POST">
		<input type="hidden" name="board_id" id="board_id"
			value="<%=boardDetail.getBoard_id()%>" readonly="true" />
	  <input type="submit" value="게시글삭제실행" />
	</form>

	<div>

</body>
</html>