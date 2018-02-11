<%@page import="com.DMS.ghb.entity.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="login">
<input name="name" type="text">
<input name="psw" type="text">
<input type="submit" value="提交">
<%Students students = (Students)request.getSession().getAttribute("user");
  if(students!=null){%>
<%=students.getName() %>
<%  }

%>
</form>
<a href="choiceTeacher">aaaaaaa</a>
<a href="changePassword">bbbbbbbb</a>
<a href="downLoadFile?fileName=4992e011-acff-4b7b-8d5d-6e4a68cf3555---a.xlsx">cccccccccc</a>
</body>
</html>