<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
span.error{
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	<table align="center">
		<tr>
			<h1 align="center">Hello</h1>
		</tr>

		<tr>
			<th>E-Mail</th>
			<td><input name = "emailUser" type="text"/></td>
			<td><span class="error"><form:errors path="emailUser"/></span></td>
		</tr>
		<tr>
			<th>Password:</th>
			<td><input name = "password" type="password"/></td>
			<td><span class="error"><form:errors path="password"/></span></td>
		</tr>
		<tr>
			<td align="right"><input type="submit" value="add"/></td>
		</tr>
		<tr>
			<td align="right"><a href="Register">Register</a></td>
		</tr>
	</table>
	</form>
</body>
</html>