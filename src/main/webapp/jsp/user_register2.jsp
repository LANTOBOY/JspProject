<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.email.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
     String requestedEmail = (String)request.getAttribute("requestedEmail");
	String getEmail = (String)session.getAttribute("requestedEmail");
 
%>  
</head>
<body>
    <form name="check" action="<%= request.getContextPath() %>/register.do" method="post">
        아이디 : <input required autofocus type="text" name="user_id"><input type="button" value="중복체크" onclick="idCheck(this.form.user_id.value)"><br>
        비밀번호 : <input required type="password" name="user_password"> <br>
        비밀번호 확인: <input  type="password" name="user_repassword"> <br>
        닉네임 : <input  type="text" name="user_nickname"> <br>
        이름 : <input type="text" name="user_name"> <br>
        이메일 : <input readonly type="text" value="<%=getEmail %>" name="user_email"> <br>
        <textarea required placeholder="Input some text." name="user_introduce"></textarea>
        <button type="button" onclick="inputCheck()">회원가입</button>
    </form>
    <script language="JavaScript" src="<%= request.getContextPath() %>/js/check.js"></script>
</body>
</html>


