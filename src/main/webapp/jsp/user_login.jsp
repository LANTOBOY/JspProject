<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/user_login.css" rel="stylesheet" type="text/css"/>


<!-- 폰트 불러오기 -->

</head>
<body>
     <form name="loginCheck" action="<%= request.getContextPath() %>/loginCheck.do" method="post">
    <div id="loginForm">
        <span class="title-login">로그인</span>
        <div id="loginForm-container">
            <div class="input-container">
                <div class="icon-container">
                    <img class="login-icon" id="icon1" alt="아이디" src="<%=request.getContextPath()%>/icon/user.png" >
                </div>
                <input type="text" placeholder="아이디를 먼저 입력해주세요" onkeypress="nextToPw()" name="user_id"/><br>
            </div>
            <div class="input-container">
                <div class="icon-container">
                    <img class="login-icon" id="icon2" alt="비밀번호" src="<%=request.getContextPath()%>/icon/unlock.png">
                </div>
                <input id="nextPw" type="password" placeholder="아이디 먼저입력" name="user_password"/><br>  
            </div>
            
            <div id="loginForm-subButton">
                <ul>
                    <li><a class="underbar-text" href="account-find.jsp">계정찾기</a></li>
                    <li><a class="underbar-text" href="<%=request.getContextPath()%>/jsp/user_register.jsp">회원가입</a></li>
                </ul>
            </div>
              <button type="button" onclick="loginInputCheck()">로그인</button><br>
        </div>
    </div>
    </form>
 <script language="JavaScript" src="<%= request.getContextPath() %>/js/check.js"></script>
</body>
</html>
    