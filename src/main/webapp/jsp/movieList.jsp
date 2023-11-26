<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , com.data.api.*"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/movieList.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	ArrayList<MovieDTO> mvList = new ArrayList<MovieDTO>();

	mvList = (ArrayList<MovieDTO>) session.getAttribute("movielist");
	if(mvList != null){
%>
		<div class="movielist-container">
		<%
		for(int i=0; i < mvList.size(); i++){
			MovieDTO mvDTO = mvList.get(i);
		%>
				<div class="movie-container" onclick="showMvInfo(<%=mvDTO.getMovie_id()%>)">
					<div class="content-container">
						<img src="<%=mvDTO.getMovie_posterPath() %>"/>
						<div class="mvname"><%=mvDTO.getMovie_title().toUpperCase() %></div><br>
						<input id="mv<%=i%>" type="hidden" value="<%=mvDTO.getMovie_id()%>"/>
					</div>
					<div class="mvdate"><%=mvDTO.getMove_release_date() %></div>
					<%
					if(mvDTO.getLogo_path() !=""){%>
					<div class="logo"><img src="<%=mvDTO.getLogo_path()%>"/></div>
					<%}%>
				</div>
		<%}%>
		</div>
	<%}%>
	

	<script>
	function showMvInfo(id){
		location.href = "/datactl.do?func=movieinfo&mvid="+id;
	}
	
	
	</script>
</body>
</html>