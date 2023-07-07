<%@page import="org.web.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDto Memberdetail 
= (MemberDto) request.getAttribute("Memberdetail");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<link rel="stylesheet" href="css/memberdetail.css">
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
			        <div class="memberdetail">

            <div class="memberdetail-con">

                <div class="memberdetail-title">
                    <h1 class="category-logo">
                        <a href="index.do"><img src="images/category-logo.png" alt="category"></a>
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
                <div class="memberdetail-data">
                   
                            <div class="data-con">
                                <div class="left-con">
                                    <img src="http://via.placeholder.com/200x400/cccccc55/ffffff?text=sample" alt="sample">
                                </div>
                                <div class="right-con">
                                <a href="update.do">수정</a>
                                    <form action="/jsp0706/update.do" method="POST">
                                            회원번호: <input type="text" name="member_id" id="member_id"
                                            value="<%=Memberdetail.getMember_id()%>" readonly="true" /> <br /> 
                                            이름: <input type="text" name="name" id="name"
                                            value="<%=Memberdetail.getName()%>" /> <br /> 
                                            비밀번호: <input type="text" name="password" id="password"
                                            value="<%=Memberdetail.getPassword()%>" /> <br /> 
                                            이메일: <input type="text" name="email" id="email"
                                            value="<%=Memberdetail.getEmail()%>" readonly="true" /> <br />
                                            전화번호: <input type="text" name="phone" id="phone"
                                            value="<%=Memberdetail.getPhone()%>" /> <br /> 
                                            주소: <input type="text" name="address" id="address"
                                            value="<%=Memberdetail.getAddress()%>" /> <br /> 
                                            등급: <input type="text" name="grade" id="grade"
                                            value="<%=Memberdetail.getGrade()%>" readonly="true" /> <br /> 
                                            출신지: <input type="text" name="city" id="city"
                                            value="<%=Memberdetail.getCity()%>" /> <br /> 
                                            작성일: <input type="text" name="Create_time" id="Create_time"
                                            value="<%=Memberdetail.getCreate_time()%>" readonly="true" /> <br /> 
                                        <br /> <input type="submit" value="회원정보수정실행" />
                                    </form>
                                    <form action="memberdelete.do" method="POST">
                                        <input type="hidden" name="member_id" id="member_id"
                                            value="<%=Memberdetail.getMember_id()%>" readonly="true" />
                                      <input type="submit" value="회원정보삭제실행" />
                                    </form>
                                </div>
                            </div>
                 
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