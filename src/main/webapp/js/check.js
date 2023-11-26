
function idCheck(id){
	if(id == ""){
		alert("아이디를 확인해주세요.");
		document.check.user_id.focus();
	}else{
		url="IdCheck.jsp?user_id=" + id;
		window.open(url,"post","width=300,height=170");
	}
}

function inputCheck(){
	var str=document.check.user_email.value;	   
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.'); 
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if(document.check.user_id.value==""){
		window.alert("아이디를 입력해주세요.");
		document.check.user_id.focus();
	}else if(document.check.user_nickname.value==""){
		window.alert("닉네임를 입력해주세요.");
	}else if(document.check.user_name.value==""){
		window.alert("이름를 입력해주세요.");
	}else if(document.check.user_password.value==""){
		window.alert("암호를 입력해주세요.");
	}else if(document.check.user_repassword.value==""){
		window.alert("암호 확인을 입력하세요..");
	}else if(document.check.user_introduce.value==""){
		window.alert("자기소개를 입력해주세요.");
	}else if(document.check.user_password.value != document.check.user_repassword.value){
		window.alert("암호가 일치하지 않습니다.");
	}else{
		document.check.submit();
	}
	
}

function nextToPw(){
    document.getElementById("nextPw").focus();
}

function loginInputCheck() {
	if(document.loginCheck.user_id.value==""){
	    window.alert("아이디를 입력해주세요.");
		document.check.user_id.focus();
	}else if(document.loginCheck.user_password.value==""){
		window.alert("암호를 입력해주세요.");
	}else{
		document.loginCheck.submit();
	}
	
}