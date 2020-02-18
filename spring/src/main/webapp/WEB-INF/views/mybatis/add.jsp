<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
회원가입을 시작합니다.
<form action="/mvc/session/addprocess" >
	아이디 <input type=text  id="a"  name="userid" ><br>
	암호 <input type="password" id="b"  name="password" ><br>
	이름 <input type="text" id="c"  name="name" ><br>
	전화번호 <input type="text" id="d"  name="phone" ><br>
	<input type=submit value="회원가입">
</form>
</body>
</html>