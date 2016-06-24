<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForFooter.css">
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-4 col-sm-5 col-md-4 col-sm-5 col-xs-8 col-xs-offset-2 col-sm-offset-4 col-md-offset-4 col-lg-offset-4 " id="firstLine">
            <div class="col-lg-1 hidden-sm"></div>
            <a href="/about" class="navbar-brand aFoot">Про сайт</a>
            <a href="/abs" class="navbar-brand aFoot">Рекалама</a>
            <a href="/help" class="navbar-brand aFoot help">Допомога</a>
            <p class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pFood ">Wtable</p>
            <a class="col-lg-12 col-md-12 col-sm-12 col-xs-12 author aFoot" href="">Близнюк Андрій</a>
        </div>
    </div>
</div>

</body>

</html>