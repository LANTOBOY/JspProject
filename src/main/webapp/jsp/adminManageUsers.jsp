<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.user.admin.AdminController, com.user.beans.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/css/adminManageUsers.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<container>
	<div id="top-line">
		<span class="page-title">회원목록</span> 
		<button onclick="showUser()">회원조회</button>
	</div>
	<% 
		ArrayList<UserDTO> ulist = (ArrayList<UserDTO>) session.getAttribute("ulist");
	
		if(ulist != null){ %>
			<hr>
			<table class="usertable">
				<colgroup>
					<col style="width : 16.6%;">
					<col style="width : 16.6%;">
					<col style="width : 16.6%;">
					<col style="width : 16.6%;">
					<col style="width : 16.6%;">
					<col style="width : 16.6%;">
				</colgroup>
				<thead>
					<tr>
						<th>유저아이디</th>
						<th>비밀번호</th>
						<th>닉네임</th>
						<th>이름</th>
						<th>이메일</th>
						<th>최초가입일</th>
					</tr>
				</thead>
				<tbody>
					<% 
					for(int i = 0; i < ulist.size(); i++){
						UserDTO regBean = (UserDTO) ulist.get(i); %>
						<tr>
							<td class="id" style='text-align : center;'><%=regBean.getUser_id()%></td>
							<td class="pw" style='text-align : center;'><%=regBean.getUser_password()%></td>
							<td class="nickname" style='text-align : center;'><%=regBean.getUser_nickname()%></td>
							<td class="name" style='text-align : center;'><%=regBean.getUser_name()%></td>
							<td class="email" style='text-align : center;'><%=regBean.getUser_email()%></td>
							<td class="email" style='text-align : center;'><%=regBean.getJoinday()%></td>
							<td style='text-align : center;'>
								<form action="/admin.do" method="get">
									<input type="submit" value="탈퇴">
									<input type="hidden" name="todo" value="drop">
									<input type="hidden" name="drop_user" value="<%=regBean.getUser_id()%>">
								</form> 
							</td>
						</tr>
					<% } %>
				</tbody>
			</table>
		<% } %>
</container>
<script type="text/javascript">
	function showUser(){
		location.href = "/admin.do?todo="+"show";
	}
	
	function regi_out(requestId){
		location.href = "/admin.do?todo="+"drop"+"&requestId="+requestId;
	}
	
</script>

</body>
</html>