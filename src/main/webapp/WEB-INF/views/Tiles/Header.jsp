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
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForHeadr.css">
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>



<div class="container headerContainer">

    <div class="row">
        <div class="navbar navbar-inverse">
            <div class="col-lg-4 col-md-4 col-sm-4 hidden-xs">

                <security:authorize access="isAuthenticated()">
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/message"><i class="glyphicon glyphicon-envelope"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/friends"><i class="glyphicon glyphicon-user"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/music"><i class="glyphicon glyphicon-headphones"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/video"><i class="glyphicon glyphicon-film"></i></a>
                </div>
                </security:authorize>

            </div>

        <security:authorize access="isAuthenticated()">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#responsive-menu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
        </security:authorize>

            <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="col-lg-4 col-md-4 col-sm-4 hidden-xs"></div>
                <a href="/MainPage" class="navbar-brand">WTable</a></div>
            <div class="col-lg-4 col-md-4 col-sm-4 hidden-xs">

        <security:authorize access="isAuthenticated()">
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/albom"><i class="glyphicon glyphicon-picture"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/seach"><i class="glyphicon glyphicon-search"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <a href="/settings"><i class="glyphicon glyphicon-cog"></i></a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <form method="post" action="/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="buttonLogout"><i class="glyphicon glyphicon-log-out"></i></button>
                    </form>
                </div>
        </security:authorize>

            </div>
        </div>
    </div>
</div>


<div class="collapse navbar-collapse hidden-md hidden-sm hidden-lg" id="responsive-menu">
    <ul class="nav navbar-nav sidebar hidden-md hidden-sm hidden-lg">
        <li><a href="/message"><i class="glyphicon glyphicon-envelope"></i></a></li>
        <li><a href="/friends"><i class="glyphicon glyphicon-user"></i></a></li>
        <li><a href="/music"><i class="glyphicon glyphicon-headphones"></i></a></li>
        <li><a href="/video"><i class="glyphicon glyphicon-film"></i></a></li>
        <li> <a href="/seach"><i class="glyphicon glyphicon-search"></i></a></li>
        <li> <a href="/settings"><i class="glyphicon glyphicon-cog"></i></a></li>
        <li>
            <form method="post" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><button type="submit" style="margin-left:4px" class="buttonLogout"><i class="glyphicon glyphicon-log-out"></i></button></li>
        </form>
    </ul>
</div>

</body>




</html>
