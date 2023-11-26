function likeButtonClk(mvid, usId, ckid){
			if(ckid=="null"){
			window.alert("로그인후 이용해 주십시요");
			}else{
			document.getElementById("likebtn").classList.toggle("check");	
			location.href = "/likectl.do?movieId="+mvid+"&userId="+usId;
			}
}

