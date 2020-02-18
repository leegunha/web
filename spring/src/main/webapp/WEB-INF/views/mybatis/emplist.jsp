<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<!-- servlet,jsp  webcontent\web-inf\lib\jstl.jar, standard.jar   
spring mvc 기본 다운로드
-->
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${list }"   var="vo">
    사번 : ${vo.employee_id } : 성:${vo.last_name } : 이름${vo.first_name }<br>
</c:forEach>

<!-- a(@RequestParam("employee_id") int employee_id) -->
<form action="<%=request.getContextPath() %>/mybatis/detailemp">
사번 : <input type=text name="employee_id">
<input type=submit value="조회">
</form>

</body>
</html>




