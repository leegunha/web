<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<h1>loginform.jsp 파일이 보입니다.</h1>

<form action="http://localhost:8081/mvc/login"  method="post" >
아이디<input type=text name=id ><br>
암호<input type="password" name="pw" ><br>
나이<input type="text" name="age" ><br> <!-- 20세 -->
<input type=submit value="로그인">
</form>

</body>
</html>




