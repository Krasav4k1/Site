<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <tr>
        <a href="/">exit</a>
    </tr>
</form>
</body>
</html>