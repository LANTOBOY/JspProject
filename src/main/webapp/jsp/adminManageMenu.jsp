<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/css/adminManageMenu.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<ul id="menulist">
		<li><a class="line" href="adminMainPage.jsp?page=adminManageUsers.jsp">유저관리</a></li>
		<li><a class="line" href="#">신고관리</a></li>
		<li><a class="line" href="#">쪽지함</a></li>
	</ul>
	
	
	

</body>
</html>