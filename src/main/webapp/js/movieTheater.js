function next(pageNum,sort){
        		var pN = Number(pageNum) + 1;
            	location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
		}
        function prev(pageNum,sort){
        	var pN = Number(pageNum);
        	if(pN==1){
        		alert("시작페이지입니다.");
        		pN = 1;
        		location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        	}else{
        	    pN = pN - 1;
        		location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        	}
        }
        function desc(pageNum,sort){
        	alert("내림차순으로 정렬합니다.");
        	var pN = Number(pageNum)
        	var sort = "popularity.desc";
        	location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        }
        function asc(pageNum,sort){
        	alert("오름차순으로 정렬합니다.");
        	var pN = Number(pageNum)
        	var sort = "popularity.asc";
        	location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        }
         function start(pageNum,sort){
        	var pN = Number(pageNum);
        	var pN = Number(pageNum);
        		pN = 1;
        		location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        }
         function done(pageNum,sort){
        	var pN = Number(pageNum);
        		pN = 500;
        		location.href = "/datactl.do?func=movielist&page="+pN+"&sort="+sort;
        }