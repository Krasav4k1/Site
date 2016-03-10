<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	<table align="center">
		<h1>Hello</h1>
		<tr>
			<th>E-Mail</th>
			<input name = "emailUser" type="text" required> <span></span><br>
		</tr>
		<tr>
			<th>Password:</th>
			<input name = "password" type="password" required> <span></span><br>
		</tr>
		<tr>
			<input type="submit" value="add"/>
		</tr>
		<tr>
			<a href="Register">Register</a>
		</tr>
	</table>
	</form>
</body>
</html>