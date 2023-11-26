<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%= request.getContextPath() %>/css/user_register.css" rel="stylesheet" type="text/css"/>

<!-- 폰트 불러오기 -->

</head>
<body>
    <div id="logo"><a href="index.jsp">movieGroup</a></div>

    <div id="registerForm1">
        <!-- Title -->
        <div class = "register-title-container">
            <span class="title-login">이메일 인증</span>
            
            <img class="title-icon" src="../icon/arrow.png"/>
        </div>
        <!-- Contents-->
        <div id="register-content-container">
            <!-- Content 1 -->
            <div class="input-container">
                <div class="icon-container">
                    <img class="login-icon" id="icon1" alt="아이디" src="../icon/email.png" >
                </div>
                <form action="<%= request.getContextPath() %>/sendEmail.do" class="etAndButton" method="get">
                    <input type="tel" name="email" placeholder="이메일을 입력해주세요"/>
                    <input type="submit" value="인증번호 요청" id="btn1" />
                </form>
            </div>
            <!-- Content 2 -->
            <div id="verify_content" class="input-container">
                <div class="icon-container">
                    
                </div>
                <form action="<%= request.getContextPath() %>/codechk.do" method="get" class="etAndButton">
                    <input type="tel" name="code" placeholder="인증번호를 입력해주세요"/>
                    <input type="submit" value="확인">
                </form>
            </div>

        </div>
    </div>




                                                                                                

    <script type="text/javascript">
    
        var opacity = 0;
        var intervalID  = 0;
        document.getElementById("btn1").addEventListener('click', function(){
            intervalID = setInterval(show,200);
            changeValue();
        });
        document.getElementById("btn2").addEventListener('click',function(){
            formChange();
        });

        
        function show(){
            var div = document.getElementById("verify_content");
            opacity = Number(window.getComputedStyle(div).getPropertyValue("opacity"));

            if(opacity < 1){
                opacity = 1;
                div.style.opacity = opacity;
            }
            else{
                clearInterval(intervalID);
            }
        }
        
        function changeValue(){
        	const btn1 = document.getElementById("btn1");
            btn1.value="재전송";
            
        }

        function formChange(){
            var form1 = document.getElementById("registerForm1");
            var form2 = document.getElementById("registerForm2");
            form1.style.backgroundColor  = "yellow";
            form2.style.display = "default";
            
        }
       
    </script>
    

    

    
</body>
</html>




