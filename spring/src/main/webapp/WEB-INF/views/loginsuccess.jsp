<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<!-- LoginController -......2개 전달(loginVO, loginresult)  - loginsuccess.jsp -->
<h1>loginsuccess.jsp 파일이 보입니다.</h1>
회원님의 아이디는 ${login.id } 입니다.<br>
회원님의 암호 ${login.pw }  입니다.<br>
회원님의 나이는 ${login.age }  입니다.<br>
로그인 상태는 ${loginresult } 입니다.

<!-- 한글 깨지면 web.xml에 encoding 추가 -->
</body>
</html>




