<%@page import="edu.multi.mybatis.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
${login.employee_id} 사원님 로그인되었습니다.<br>
<%=((EmpVO)session.getAttribute("login")).getEmployee_id() %>
사원님 로그인되었습니다.2<br>
<a href="/mvc/mybatis/mypage">내정보보기</a><br>
<a href="/mvc/mybatis/logout">로그아웃</a><br>
</body>
</html>