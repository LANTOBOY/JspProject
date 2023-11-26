<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.user.beans.*" %>
 
<%
   request.setCharacterEncoding("utf-8");
   String user_id = request.getParameter("user_id");
   boolean check = UserDAO.checkId(user_id);
%>

<html>
<head>
<title>ID중복체크</title>
<link href="<%=request.getContextPath()%>/css/idcheck.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>

<body bgcolor="#FFFFCC">
<br>
<center class="center">
<h2>movieGroup</h2>
<b><%=user_id%></b>
<%
  if(check){
     out.println("는 이미 존재한는 ID입니다.<p>");
}else{    
     out.println("는 사용 가능 합니다.<p>");
}
%>
<a href="javascript:this.close();">닫기</a>
</center>
</body>
</html>