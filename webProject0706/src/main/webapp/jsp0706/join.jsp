<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 페이지</title>
    <link rel="stylesheet" href="css/join.css">
    <script src="js/joinOk.js" defer></script>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <div class="nav">
                <h1 class="logo">
                    <a href="index.do">
                        <img src="images/logo.png" alt="logo_120*60">
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
        <div class="join">
            <div class="join-con">
                <form action="joinOk.do" method="post">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">Sign Up</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label for="name">이름</label></td>
                            <td><input type="text" name="name" id="name" class="s1"></td>
                        </tr>
                        <tr>
                            <td><label for="password">비밀번호</label></td>
                            <td><input type="password" name="password" id="password" class="s1"></td>
                        </tr>
                        <tr>
                            <td><label for="email">이메일</label></td>
                            <td class="email">
                                <input type="email" name="email" id="email">
                                <input type="button" value="E-Checked" id="emailChecked">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="phone">전화번호</label></td>
                            <td><input type="text" name="phone" id="phone" class="s1"></td>
                        </tr>
                        <tr>
                            <td><label for="address">주소</label></td>
                            <td><input type="text" name="address" id="address" class="s1"></td>
                        </tr>
                        <tr>
                            <td><label for="city">출생지</label></td>
                            <td><select name="city" id="city" class="s3">
                                <option value="">::출생지::</option>
                                <option value="서울">서울</option>
                                <option value="인천">인천</option>
                                <option value="대전">대전</option>
                                <option value="대구">대구</option>
                                <option value="부산">부산</option>
                            </select></td>
                        </tr>                   
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2">
                                <div class="sub">
                                <a href="index.do" class="t1">HOME</a>
                                <input type="reset" value="초기화" class="t1">
                                <input type="submit" value="회원가입실행" class="t1">
                                </div>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </form>
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