<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.data.api.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/movieTheater1.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <top>
       	<%@include file="top.jsp"%>
    </top>
    <section class="section">
    <div id="container">
        <section id="content-container">
            <%@include file="movieList.jsp" %>
        </section>
        <div id="leftFilter">
        <div class="sort">
    	<button class="check" onclick="asc( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')">오름차순 정렬</button>
    	<button class="check" onclick="desc( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')">내림차순 정렬</button>
    	</div>
    	<div class="direction">
    	    <div class="prev" onclick="start( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')"><i class="fa-solid fa-angles-left"></i></div>
    		<div class="prev" onclick="prev( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')"><i class="fa-solid fa-angle-left"></i></div>
    		<p class="pageNum"><%=session.getAttribute("pageNum")%></p>
    		<div class="next" onclick="next( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')"><i class="fa-solid fa-angle-right"></i></div>
    		<div class="next" onclick="done( '<%=session.getAttribute("pageNum")%>','<%=session.getAttribute("sortWay")%>')"><i class="fa-solid fa-angles-right"></i></div>
    	</div>
    	</section>
    	<footer>
       	<%@include file="footer.jsp"%>
        </footer>
<script src="<%= request.getContextPath() %>/js/movieTheater.js"></script>
</body>
</html>