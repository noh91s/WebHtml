<%@page import="org.web.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<MemberDto> memberList = (ArrayList<MemberDto>) request.getAttribute("memberList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원목록</title>
<link rel="stylesheet" href="css/join.css">
<script src="js/joinOk.js" defer></script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="nav">
				<h1 class="logo">
					<a href="index.do"> <img src="images/logo.png"
						alt="logo_120*60">
					</a>
				</h1>
				<div class="gnb">
					<ul>
						<li><a href="index.do">HOME</a></li>
						<li><a href="memberlist.do">MEMBERLIST</a></li>
						<li><a href="#">ADMIN</a></li>
						<li><a href="join.do">MEMBERJOIN</a></li>
						<li><a href="login.do">LOGIN</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="memberlist">
				<div class="memberlist-con">
				
						<ul>
							<%
							for (MemberDto member : memberList) {
							%>
							<li>
								<table border="1">
									<tr>
										<td>회원번호</td>
										<td><%=member.getMember_id()%></td>
									</tr>
									<tr>
										<td>회원이름</td>
										<td><%=member.getName()%></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><%=member.getPassword()%></td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><%=member.getEmail()%></td>
									</tr>
									<tr>
										<td>전화번호</td>
										<td><%=member.getPhone()%></td>
									</tr>
									<tr>
										<td>주소</td>
										<td><%=member.getAddress()%></td>
									</tr>
									<tr>
										<td>등급</td>
										<td><%=member.getGrade()%></td>
									</tr>
									<tr>
										<td>출생지</td>
										<td><%=member.getCity()%></td>
									</tr>
								</table>
							</li>
							<%
							}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="fcon">
				<ul>
					<li>
						<h1 class="title">ADDRESS</h1>
						<p>서울특별시 노원구 상계동 어딘가</p>
					</li>
					<li>
						<h1 class="title">COPYRIGHT</h1>
						<p>Lorem ipsum dolor sit amet consectetur</p>
					</li>
				</ul>
			</div>
		</div>
	</div>


</body>
</html>