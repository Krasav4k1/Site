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

<c:url value="/login" var="login"/>
<form method="post"  class="login" action="${login}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <table align="center">
        <tr>
            <h1 align="center" style="color: red; font-family: Arial;" >Неправильний пароль або логін</h1>
        </tr>

        <tr>
            <th style="color: red; font-family: Arial">E-Mail:</th>
            <td><input type="text" required pattern = "\d{3}\d{3}\d{4}|^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" name="username" id="login" ></td>
        </tr>
        <tr>
            <th style="color: red; font-family: Arial">Password:</th>
            <td><input pattern = "^[a-zA-Z0-9]+$" min = "5" required type="password" name="password" id="password" ></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="add"/></td>
        </tr>
        <tr>
            <th align="right" style="text-align: left"><a href="forgot-password" style="text-align: center">Забыл пароль?</a></th>
        </tr>
        <tr>
        <td align="right" style="text-align: left"><a href="register" style="text-align: center">Register</a></td>
        </tr>
    </table>
</form>
</body>
</html>