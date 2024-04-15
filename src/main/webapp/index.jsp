<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is HTML code</h1>
	<% System.out.println(" This is Java Code"); %>
	<%
		int a=5;
		System.out.println(a + " is the number");
	%>
	<%! int b = 8; %>
	<h1> <%=b %>  is the number</h1>
	<h3 style ="color:blue"> The local time is <%=LocalDate.now()%></h3>
	<h1><%=a+b %> is the sum of a and b </h1>
	<%@include file="insert.html" %>
	<h1> <%=this %>  is the object address</h1>
	
</body>
</html>