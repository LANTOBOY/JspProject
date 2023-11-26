<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.data.api.MovieDTO, com.data.like.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%= request.getContextPath() %>/css/movieInfo.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%
Integer check = (Integer)session.getAttribute("islike");
%>
<body>
<top>
   <%@include file="top.jsp"%>
</top>
<section class="section">
<%
	MovieDTO mvDTO = new MovieDTO();
	mvDTO = (MovieDTO)application.getAttribute("movieInfoInApplication");
	if(mvDTO != null){
	%>
	<div id="container">
	<div class="background">
	<div class="backdrop"><img class="backimg"alt="포스터" src="<%=mvDTO.getMovie_backdropPath()%>"></div>
	<div class="blackwide"></div>
	</div>
	<div class="produce">
		<div class="title"><%=mvDTO.getMovie_title() %></div>
		<div class="day"><%=mvDTO.getMove_release_date() %></div>
		<%if(mvDTO.getLogo_path() !=""){%>
		<a class="movielink" href="<%=mvDTO.getHomepage() %>"><img src="<%=mvDTO.getLogo_path()%>"/></a>
		<%}%>
		<div class="tagline"><%=mvDTO.getTagline() %></div>
		<h2 class="over">줄거리</h2>
		<div class="overview"><%=mvDTO.getMovie_overview()%></div>
		<Button class="like" id="likebtn" onclick="likeButtonClk(<%=mvDTO.getMovie_id()%>,'<%=session.getAttribute("idKey")%>','<%=session.getAttribute("success")%>')">
		<i class="fa-solid fa-heart"></i>
		</Button>
	</div>
	<%
	}
	%>
</section>
<footer>
   <%@include file="footer.jsp"%>
</footer>
<script src="<%= request.getContextPath() %>/js/movieInfo.js"></script>
</body>
</html>