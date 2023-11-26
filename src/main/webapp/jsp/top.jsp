<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>hi</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/top.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%
String id = (String) session.getAttribute("idKey");
String success = (String) session.getAttribute("success");
%>
</head>
<body>
    <div class="container">
<nav class="navbar">
    <div class="navlogo">
        <a href="<%= request.getContextPath() %>/jsp/index.jsp">movieGroup</a>
    </div>
    <ul class="navmenu" id="dropmenu">
        <li><a class="line" id="left" href="/datactl.do?func=movielist&page=1&sort=popularity.desc">스트리밍</a></li>
        <li><a class="line" id="left" href="#">극장</a></li>
    </ul>
    <div class="searchBox">
        <input class="searchInput"type="text" name="" placeholder="Search">
        <button class="searchButton" href="#">
            <i class="fa-solid fa-magnifying-glass">
            </i>
        </button>
    </div>
    <ul class="navbutton">
        <div class="dropdown2">
            <button class="dropbtn2">
            <%
            if(success == null){
            %>
            <label for="check2" class="user">
                <input type="checkbox" id="check2"  onclick="userFunction()" class="dropbtn2"/> 
                <img src="<%= request.getContextPath() %>/img/user48.png">
            </label>
            </button>
            <span class="login-check">로그인을 하십시오.</span>
            <div id="userDropdown" class="dropdown-content2">
                <a href="#">내정보</a>
                <a href="<%= request.getContextPath() %>/jsp/user_login.jsp">로그인</a>
            </div>
            </div>
            <%
            }
            %>
            <%
            if(success != null){
            %>
            <label for="check2" class="user">
                <input type="checkbox" id="check2"  onclick="userFunction()" class="dropbtn2"/> 
                <img src="<%= request.getContextPath() %>/img/user48.png">
            </label>
            </button>
            <span class="login-check"><%=id %>님</span>
            <div id="userDropdown" class="dropdown-content2">
                <a href="#">내정보</a>
                <form action="<%= request.getContextPath() %>/logout.do" method="post">
                <button class="logout">로그아웃</button>
                </form>
            </div>
            </div>
            <%
            }
            %>
        <div class="dropdown">
            <button class="dropbtn">
            <label for="check">
                <input type="checkbox" id="check"  onclick="myFunction()" class="dropbtn1"/> 
                <span></span>
                <span></span>
                <span></span>
            </label>
            </button>
            <div id="myDropdown" class="dropdown-content">
                <a href="./index.jsp?CONTENTPAGE=section.jsp">스트리밍</a>
                <a href="./index.jsp?CONTENTPAGE=section2.jsp">극장</a>
                <a href="#">역대명작</a>
                <a href="#">장르별영화</a>
                <a href="#">토론</a>
            </div>
            </div>
    </ul>
</nav>
</div>
<script src="<%= request.getContextPath() %>/js/top.js"></script>
</body>
</html>