<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<img src="<%=request.getContextPath() %>/resources/images/google.png"><br>
<input id="btn" type=button value="횟수계산"><br>
<div id="result"></div>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
var cnt=1;
 $("#btn").on('click', function(){
	 $("#result").append("클릭"+ cnt++ + "<br>");
 });
</script>

아이디:<input id="id" type=text ><br>
암호<input id="pw" type="password" ><br>
<input id="ajaxbtn" type=button value="로그인"><br>
<div id="ajaxresult"></div>

<img src="<%=request.getContextPath() %>/resources/images/android.jpg"><br>

<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
var cnt=1;
 $("#ajaxbtn").on('click', function(){
	 $("#ajaxresult").append("클릭2222"+ cnt++ + "<br>");
	 $.ajax({
		 url: '<%=request.getContextPath() %>/ajaxlogin',
		data: {"id":$("#id").val(),"pw":$("#pw").val()},
		type:'get',
		dataType: 'json',
		success:function(server){
			$("#result").append(server.status+":"+server.time);
		}
	 });
 });
</script>

글번호<input id="seq" type=text >
<input id="ajaxboardbtn" type=button value="게시물1개만주세요"><br>
<div id="ajaxboardresult"></div>

<script>
var cnt=1;
 $("#ajaxboardbtn").on('click', function(){
	 $.ajax({
		 url: '<%=request.getContextPath() %>/ajaxboard',
		data: {"seq":$("#seq").val()},
		type:'get',
		dataType: 'json',
		success:function(server){
			$("#ajaxboardresult").append(server.seq+":"+server.title+"<br>");
		}
	 });
 });
</script>
</body>
</html>


