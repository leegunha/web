<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<%=request.getParameter("id") %> 회원님
<%=request.getParameter("pw") %> 암호를 입력하셨습니다.
<%
boolean status = false;
String logintime = "---";
if(request.getParameter("id").equals("ajax") &&
		request.getParameter("pw").equals("ajax")	){
	status = true;
	logintime = new java.util.Date().toLocaleString();
}
%>
<%=status %><br>
<%=logintime %><br>
</body>
</html>




