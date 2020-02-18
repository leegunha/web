<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- html태그 : 구성요소 
      css :  구성요소(배치,색상,크기조정)
      javascript/jquery : 구성요소동적
      ===> HTML5 
-->
<h1 > 이미지 보고 있는 중입니다.</h1>
<h1 class="c"> 이미지 보고 있는 중입니다.</h1>
<h1 id="me" > 이미지 보고 있는 중입니다.</h1>
<h1 class="c"> 이미지 보고 있는 중입니다.</h1>
<h1 class="c"> 이미지 보고 있는 중입니다.</h1>
<input id="btn" type=button value="클릭횟수계산"><div id="result"></div>

<form action="/a" >
아이디<input=text  id="a2" name="a" ><a>
<!-- 서버전송파라미터명:name--request.get..("a") -->
<!-- jquery 태그 가져가서 후속 처리 동작 :id ---$("#a2").val()-->
<input id="btn2" type=button value="전송" >
</form>

<img src="<%=request.getContextPath() %>/resources/images/google.png">
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js" >
</script>
<script>
  var cnt=1;
	//$(".c").css("color", "blue");
/* 	$("#btn").on('click', function () {  
		$("#result").append("<h3>추가합니다"+ cnt++  +"</h3>");
		//cnt++;
	}  ); */

	$("#btn2").on('click', function(){
		location.href="/a?a="+$("#a2").val();
		//$("form").submit();// submit 버튼 역할
	});
</script>

</body>
</html>



