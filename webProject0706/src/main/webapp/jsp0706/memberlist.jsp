<%@page import="java.time.format.DateTimeFormatter"%>
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
<link rel="stylesheet" href="css/memberlist.css">
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
					<div class="memberlist-title">
						<h1 class="category-logo">
							<a href="index.do"><img src="images/category-logo.png"
								alt="category"></a>
						</h1>
						<div class="category">
							<ul>
								<li><a href="#">SPRING</a></li>
								<li><a href="#">SUMMER</a></li>
								<li><a href="#">FALL</a></li>
								<li><a href="#">WINTER</a></li>
								<li><a href="#">BEST</a></li>
							</ul>
						</div>
					</div>
					<div class="memberlist-data">
						<ul>
							<%
							for (MemberDto member : memberList) {
							%>
							<li>
								<div class="data-con">
									<div class="left-con">
										<img
											src="http://via.placeholder.com/200x400/cccccc55/ffffff?text=sample"
											alt="sample">
									</div>
									<div class="right-con">
										<ul>
											<li><span>회원번호</span> <a href="memberdetail.do?member_id=<%=member.getMember_id()%>" style="color:#ffffff;background-color:#ff0000;">상세보기</a></li>
											<li><span>이름</span> <%=member.getName()%></li>
											<li><span>비밀번호</span> <%=member.getPassword()%></li>
											<li><span>이메일</span> <%=member.getEmail()%></li>
											<li><span>전화번호</span> <%=member.getPhone()%></li>
											<li><span>주소</span> <%=member.getAddress()%></li>
											<li><span>등급</span> <%=member.getGrade()%></li>
											<li><span>출신지</span> <%=member.getCity()%></li>
											<li><span>가입일자</span> <%=DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH:mm:ss").format(member.getCreate_time())%></li>
										</ul>
									</div>
								</div>
								
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