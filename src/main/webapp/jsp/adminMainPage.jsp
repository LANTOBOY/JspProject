<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String Page = request.getParameter("page"); 
	if(Page == null){
		Page = "admin.do";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/adminMainPage1.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<header id="head-container">
		<span id="adpgTitle">관리자페이지</span><span>관리자님 환영합니다.</span>
		</header>
		<content>
	        <div id="menu-container">
				<%@ include file="adminManageMenu.jsp" %>
	        </div>
	        <div id="content-container">
				<%@ include file="adminManageUsers.jsp" %>
	        </div>
	    </content>
    </div>

</body>
</html>