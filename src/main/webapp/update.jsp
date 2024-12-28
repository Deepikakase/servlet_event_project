<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rs=(ResultSet) request.getAttribute("rs");%>
<form action="create"> 
<input type="text" name="id" value="<%=rs.getInt(1)%>"  readonly="readonly" placeholder="enter event id">
<br>
<input type="text" name="title"  placeholder="enter event title">
<br>

<input type="text" name="loc" placeholder="enter event location">
<br>

<input type="text" name="date" placeholder="enter event date">
<br>

<input type="text" name="guest" placeholder="enter event cheif guest">
<br>
<button type="submit">CREATE
</button>

</form>

</body>
</html>