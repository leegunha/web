<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<form action="/mvc/ajaxlogin" >
아이디<input type=text name="id"  id="id" ><br>
암호<input type="password" name="pw"  id="pw" ><br>
<input type=submit value="로그인">
<input id="ajaxbtn" type=button value="ajax로그인">
</form>

<div></div>
<img src="/mvc/resources/images/google.png" ><br>

<script src="/mvc/resources/jquery-3.2.1.min.js" ></script>
<script>
$("#ajaxbtn").on('click' , function(){
	$.ajax( {  
		url: '/mvc/ajaxlogin2' , 
		data: { 'id' : $("#id").val() , 'pw' : $("#pw").val() } ,
		type: 'get' ,
		dataType: 'json' ,
		success:function( serverdata ){
			//serverdata = {"status" : true , "time" : "2020년 2월 ...."}
			$("div").html(serverdata.status + " - " + serverdata.time);
			$("div").css("color" , "red");
			$("div").css("border", "2px solid blue");
		}
	}  );//ajax end
});//on end
</script>

<input type=text id="seq" >
<input type=button id="ajaxboardbtn" value="게시물1개만주세요">
<div id="boarddiv"></div>
<script>
$("#ajaxboardbtn").on('click' , function(){
	$.ajax( {  
		url: '/mvc/ajaxboard' , 
		data: { 'seq' : $("#seq").val() } ,
		type: 'get' ,
		dataType: 'json' ,
		success:function( serverdata ){//배열 [] BoardVO --jsOn 변경(JA.....)
			//serverdata = {"seq":1,"title":"1번게시물","contents":"공지사항입니다","writer":"user1","time":"2020-02-04 11:42:44","password":0,"viewcount":6}
			$("#boarddiv").append(serverdata.seq + " - " + serverdata.title 
					+ "-" + serverdata.contents + "-" + serverdata.time
					+ "-" + serverdata.writer + "-" + serverdata.viewcount+"<br>");
			$("div").css("color" , "red");
			$("div").css("border", "2px solid blue");
		}
	}  );//ajax end
});//on end
</script>


</body>
</html>





