<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="<%= request.getContextPath() %>/css/index.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<header>
        <%@ include file="top.jsp" %>
</header>
<section  class="main-content">
    <div id="slider-container">
        <div id="slider-content">
            <div id="slider-video">
                <video autoplay muted>
                    <source src="<%= request.getContextPath() %>/video/top-gun-maverick-trailer.mp4" 
                    type="video/mp4">
                </video>

                <div id="slider-movieInfo">
                    <div id="movieInfo-container">
                        <div id="title-movieInfo" class="movieInfoText">탑 건</div>
                        <div id="content-movieInfo" class="movieInfoText">
                            감독 : 한재림 <br>
                            배우 : 배성우 정우성
                        </div>
                        <div id="link-movieInfo">
                            <a href="#" class="movieInfoText">시청하기</a>
                            <a href="#" class="movieVolumeBtn"></a>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    
    <div class="popularMovie-container">
        <h2 class="title">스트리밍 | 극장 인기영화</h2>
            <button class="pre-btn"><i class="fa-solid fa-arrow-left"></i></button>
            <button class="nxt-btn"><i class="fa-solid fa-arrow-right"></i></button>
        <div class="movie">
                <div class="movie2">
                        <div class="movie-img">
                            <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                            <button class="movie-btn" onclick="window.location.href='https://www.netflix.com/kr/title/80214497'">바로가기</button>
                            </div>
                            <div class="movie-info">
                                <h2 class="movie-name" id="left">1899</h2>
                                <p class="movie-sub">2022년 8월 9일</p>
                            </div>
                        </div>
                <div class="movie2">
                    <div class="movie-img">
                        <img src="<%= request.getContextPath() %>/img/az.jpg" class="img" alt="1899">
                        <button class="movie-btn" onclick="window.location.href='https://www.netflix.com/kr/title/81078578'">바로가기</button>
                        </div>
                        <div class="movie-info">
                            <h2 class="movie-name">악인전</h2>
                            <p class="movie-sub">2020년 8월 9일</p>
                        </div>
                    </div>
                    <div class="movie2">
                    <div class="movie-img">
                        <img src="<%= request.getContextPath() %>/img/mE.jpg" class="img" alt="1899">
                        <button class="movie-btn" onclick="window.location.href='https://www.wavve.com/player/movie?movieid=MV_CD01_WR0000011715'">바로가기</button>
                        </div>
                        <div class="movie-info">
                            <h2 class="movie-name">블랙아담</h2>
                            <p class="movie-sub">2021년 8월 9일</p>
                        </div>
                    </div> 
                    <div class="movie2">
                    <div class="movie-img">
                        <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                        <button class="movie-btn">바로가기</button>
                        </div>
                        <div class="movie-info">
                            <h2 class="movie-name">1899</h2>
                            <p class="movie-sub">2022년 8월 9일</p>
                        </div>
                    </div> 
                    <div class="movie2">
                    <div class="movie-img">
                        <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                        <button class="movie-btn">바로가기</button>
                        </div>
                        <div class="movie-info">
                            <h2 class="movie-name">1899</h2>
                            <p class="movie-sub">2022년 8월 9일</p>
                        </div>
                    </div>
                    <div class="movie2">
                        <div class="movie-img">
                            <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                            <button class="movie-btn">바로가기</button>
                            </div>
                            <div class="movie-info">
                                <h2 class="movie-name">1899</h2>
                                <p class="movie-sub">2022년 8월 9일</p>
                            </div>
                        </div>
                        <div class="movie2">
                            <div class="movie-img">
                                <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                                <button class="movie-btn">바로가기</button>
                                </div>
                                <div class="movie-info">
                                    <h2 class="movie-name">1899</h2>
                                    <p class="movie-sub">2022년 8월 9일</p>
                                </div>
                            </div>
                            <div class="movie2">
                                <div class="movie-img">
                                    <img src="<%= request.getContextPath() %>/img/8KGvYHQNOamON6ufQGjyhkiVn1V.jpg" class="img" alt="1899">
                                    <button class="movie-btn">바로가기</button>
                                    </div>
                                    <div class="movie-info">
                                        <h2 class="movie-name">1899</h2>
                                        <p class="movie-sub">2022년 8월 9일</p>
                                    </div>
                                </div>   
            </div>          
    </div>
    <div class="introduce">
        <div class="title-box">
            <h2 class="title1">movieGroup</h2>
            <h2 class="title2">소개</h2>
        </div>
        <p class="sub">영화를 보고 싶을때 어떤걸 봐야 할지 고민이시라구요?</p>
        <div class="introduce-box">
            <h2 class="title3">movieGroup</h2>
            <p class="sub-box">스트리밍,극장에서 많은 관람객들이 추천한 영화와 시청율을 분석하여<br>
            최고의 영화를 여러분들께 선물 할수 있습니다.</p>
            <p class="sub-box2">지금! 본인에게 맞는 영화를 찾아서 즐거운 하루가 되시기 바랍니다.</p>
        </div>
    </div>
</section>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
<script src="<%= request.getContextPath() %>/js/index.js"></script>
</body>
</html>


