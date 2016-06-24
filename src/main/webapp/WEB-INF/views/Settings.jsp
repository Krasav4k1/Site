<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->
<head>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>


<%--
<sf:form action="/settings/addGrup" method="post" modelAttribute="User">
<fieldset>
    <sf:input path="id" id="id" type="hidden"/>
    <table>
   <tr>
   <td><sf:select multiple="4" path="grups">
       <c:forEach items="${grupList}" var="gr" varStatus="vs">
       <sf:option  value="${gr.id}" >${gr.nameGrup}</sf:option>
       </c:forEach>
   </sf:select>
    </td>
   </tr>
    </table>
</fieldset>
    <table>
        <tr>
        <c:forEach items="${grupList}" var="g">
            <tr>
        <td>${g.nameGrup}</td>
            </tr>
        </c:forEach> </td>
        </tr>
    </table>
    <input type="submit" value="add"/>
</sf:form>
--%>

<form action="/settings/daleteUser" method="GET">
    <input type="submit" value="remove me">
</form>


</body>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>
