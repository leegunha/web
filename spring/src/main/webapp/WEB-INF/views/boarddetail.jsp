<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>

</head>
<body>
<form action="http://localhost:8081/mvc/boardupdate" >
번호 :  <input type=text name="seq" value="${detail.seq }" readonly > <br>
제목 : <input type=text name="title" value="${detail.title }"><br>
내용 : <input type=text name="contents" value="${detail.contents }"><br>
작성자 : <input type=text name="writer" value="${detail.writer }"><br>
작성시간:<input type=text name="time" value="${detail.time }" readonly ><br>
조회수 :<input type=text name="viewcount" value="${detail.viewcount}" readonly><br>
<input type=submit value="수정">
</form>

<form action="http://localhost:8081/mvc/boarddelete" >
<input type=hidden name="seq" value="${detail.seq }" readonly > 
<input type=submit value="삭제">
</form>

</body>
</html>



