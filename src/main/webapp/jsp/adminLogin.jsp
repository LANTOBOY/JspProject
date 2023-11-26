<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>"Admin Login Page"</title>
</head>
<body>
	<form action="../admin.do" method="post">
		<span>관리자 아이디</span><input name="admin_id" required type="text"><br>
		<span>관리자 비밀번호</span><input name="admin_pw" required type="password"><br>
		<input type="submit" value="로그인">
		<input type="hidden" name="todo" value="adlogin">
	</form>
</body>
</html>