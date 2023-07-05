<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 페이지</title>
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
<h1>게시글등록 페이지</h1>
<form action="board_writeOk.bo" method="POST">
	<label for="board_title">글제목</label>
	<input type="text" name="board_title" id="board_title" /> </br>
	<label for="board_content">글내용</label>
	<input type="text" name="board_content" id="board_content" /> </br>
	<label for="email">이메일</label>
	<input type="board_writer" name="board_writer" id="board_writer" /> </br>
	<input type="submit" value="게시글등록실행"/>
</form>

</body>
</html>