<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.entity.City" %>
<%@ page import="com.repository.CountryRepository" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
    <!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
    <!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
    <!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Вход</title>
    <style>
        <%@include file='cssForJsp/MainPage.css' %>
    </style>

</head>
<body>


<h1 style="text-align: center; color:#a8a7a8; padding: 40px">WTable</h1>


<c:url value="/login" var="login"/>
<form method="post"  class="login" action="${login}" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" >
    <p>
        <label for="login">E-mail, тел:</label>
        <input type="text" required pattern = "\d{3}\d{3}\d{4}|^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" name="username" id="login" >
    </p>

    <p>
        <label for="password">Пароль:</label>
        <input pattern = "^[a-zA-Z0-9]+$" min = "5" required type="password" name="password" id="password" >
    </p>

    <p class="login-submit">
        <button type="submit" class="login-button">Войти</button>
    </p>
    <p class="forgot-password"><a href="/register">Регістрація</a></p>


</form>
</body>
</html>
