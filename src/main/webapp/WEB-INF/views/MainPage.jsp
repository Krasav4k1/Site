<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->
<head>
    <style>
        <%--<%@include file='cssForJsp/MainPage.css' %>--%>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form method="post">
    <h>Main Page</h>
    <table>
        <tr>
            <th>Last Name:</th>
            <td>${firstNameMap}</td>
        </tr>
        <tr>
            <th>First Name:</th>
            <td>${lastNameMap}</td>
        </tr>
        <tr>
            <th>City:</th>
            <td>${cityMap}</td>
        </tr>
        <tr>
            <th>Ragion:</th>
            <td>${ragionMap}</td>
        </tr>
        <tr>
            <th>Oblast:</th>
            <td>${oblastMap}</td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>${countryMap}</td>
        </tr>

        <tr>
            <th>Born birthday:</th>
            <th>${dayMap}</th>
            <th>${mouthMap}</th>
            <th>${yearMap}</th>
            <th>${ageMap}</th>
        </tr>
    </table>
    <c:url value="/logout" var="logout"/>
    <form method="post" action="${logout}?${_csrf.parameterName}=${_csrf.token}">
        <input  type="submit" value="Вихід"/>
    </form>

</form>
</body>
</html>