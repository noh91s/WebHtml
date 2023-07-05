<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
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
<h1>회원등록 페이지</h1>
<form action="member_joinOk.mo" method="POST">
	<label for="member_name">이름</label>
	<input type="text" name="member_name" id="member_name" /> </br>
	<label for="member_password">비밀번호</label>
	<input type="text" name="member_password" id="member_password" /> </br>
	<label for="email">이메일</label>
	<input type="text" name="email" id="email" /> 
<!-- <form action="member_check.mo"> <input type="hidden" name="email" id="email" /> <input type="submit" value="중복확인"/> </form> -->
	</br>
	<input type="submit" value="회원등록실행"/>
</form>



</body>
</html>