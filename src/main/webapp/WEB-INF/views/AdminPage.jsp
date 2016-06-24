<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <h>Admin Page</h>
        <table>
            <td> <a href="AdminPage/AdminDaleteUser">DaleteUser</a></td>
        </table>
</form>
<c:url value="/logout" var="logout"/>
<form method="post" action="${logout}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input  type="submit" value="Вихід"/>
</form>
</body>
</html>
