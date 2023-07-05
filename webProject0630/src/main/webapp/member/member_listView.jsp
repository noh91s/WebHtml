<%@page import="org.web.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<MemberDto> members=
(ArrayList<MemberDto>) request.getAttribute("members");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 페이지</title>
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
<h1>회원 목록</h1>
<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
<!-- 		<th>비밀번호</th> -->
			<th>이메일</th>
			<th>등록날짜</th>
<!-- 		<th>수정</th> -->
		</tr>
		<%
		for (MemberDto member : members) {
		%>
		<tr>
			<td><%=member.getMember_id()%></td>
			<td><%=member.getMember_name()%></td>
<!-- 		<td><%=member.getMember_password()%></td> -->
			<td><%=member.getEmail()%></td>
			<td><%=member.getCreat_time()%></td>
<!--		<td><a href="member_update.mo?member_id=<%=member.getMember_id()%>">수정</a></td> -->
		</tr>
		<%
		}
		%>
		
	</table>
<a href="member_delete.mo">회원탈퇴</a>

</body>
</html>