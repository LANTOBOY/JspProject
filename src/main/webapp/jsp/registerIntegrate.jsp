<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/RegisterIntegrate.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
<%
     String requestedEmail = (String)request.getAttribute("requestedEmail");
	String getEmail = (String)session.getAttribute("requestedEmail");
 
%>  
</head>
<body>
<div id="loginForm">
        <span class="title-login" color="skyblue">회원가입</span>
        <div id="loginForm-container">
            <form name="check" action="<%= request.getContextPath() %>/register.do" method="post">
            <div class="input-container">
            <div class="icon-container">
                    <img class="login-icon" id="icon1" alt="아이디" src="<%=request.getContextPath()%>/icon/user.png" >
                </div>
            <div class="etAndButton">
                <input required autofocus type="text" name="user_id" placeholder="아이디를 먼저 입력해주세요."/><input id="idcheck" type="button" value="중복체크" onclick="idCheck(this.form.user_id.value)"><br>
                <input  type="text" name="user_nickname" placeholder="닉네임을 입력해주세요."/><br>
                <input type="text" name="user_name" placeholder="이름을 입력해주세요."/><br>
            </div>
                <br><br>
            </div>
            <div class="input-container">
                <div class="icon-container">
                        <img class="login-icon" id="icon2" alt="비밀번호" src="<%=request.getContextPath()%>/icon/lock.png" >
                </div>
            <div class="etAndButton">
                <input required type="password" name="user_password" placeholder="비밀번호를 입력하세요."/><br>
                <input input  type="password" name="user_repassword" placeholder="비밀번호확인"/><br>
            </div>
                <br><br>
            </div>
            <div class="input-container">
                <div class="icon-container">
                        <img class="login-icon" id="icon3" alt="이메일" src="<%=request.getContextPath()%>/icon/letter.png" >
                </div>
            <div class="etAndButton">
                <input readonly type="text" value="<%=getEmail %>" name="user_email">
            </div>
                <br><br>
            </div>
            <div class="input-container">
                <div class="icon-container">
                        <img class="login-icon" id="icon4" alt="자기소개" src="<%=request.getContextPath()%>/icon/moon.png" >
                </div>
            <div class="etAndButton">
                <textarea required placeholder="자기소개를 입력하세요." name="user_introduce"></textarea>
            </div>
                <br><br>
            </div>
            <div class="submitButton">
            <button type="button" onclick="inputCheck()"><img class="login-icon" id="icon5" alt="전송" src="<%=request.getContextPath()%>/icon/check.png" ></button>
            </form>
            </div>
                
</div>
    <script language="JavaScript" src="<%= request.getContextPath() %>/js/check.js"></script>
</body>
</html>