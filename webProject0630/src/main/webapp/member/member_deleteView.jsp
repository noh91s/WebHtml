<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 페이지</title>
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
<h1>회원 탈퇴</h1>
<form action="member_deleteOk.mo" method="POST">
회원번호 : <input type="text" name="member_id" /> <br/>
이름 : <input type="text" name="member_name" /> <br/>
비밀번호 : <input type="text" name="mebmer_password" /> <br/>
<input type="submit" value="회원탈퇴" /> <br/>

</body>
</html>