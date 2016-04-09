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
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
</head>
<body>
<c:choose>

<c:when test="${index.equals('obl')}">
    <select id="optionObl" name = "CountryId">
        <c:forEach var="oblastCountry" items="${oblastCountry}">
            <option >${oblastCountry}</option>
        </c:forEach>
    </select>
</c:when>

    <c:when test="${index.equals('ray')}">
        <select id="optionReg" name = "oblastName">
            <c:forEach var="ragionOblast" items="${ragionOblast}">
                <option >${ragionOblast}</option>
            </c:forEach>
        </select>
    </c:when>

    <c:when test="${index.equals('city')}">
        <select id="optionCity" name = "cityName">
            <c:forEach var="cityRegion" items="${cityRegion}">
                <option>${cityRegion}</option>
            </c:forEach>
        </select>
    </c:when>



</c:choose>

<script>
    $("#optionObl").change(function(){

        var id = $("#optionObl").val();
        index = "ray";
        $.get("searchRegionyByIdCountry" + index + "/"+ id, {}, function(result){
            $("#selectObl").html(result);
        });
    });
    $("#optionReg").change(function(){

        var id = $("#optionReg").val();
        index = "city";
        $.get("searchRegionyByIdCountry" + index + "/"+ id, {}, function(result){
            $("#selectCity").html(result);
        });
    });
    $("#optionCity").change(function(){
        index = "cityId";
        var id = $("#optionCity").val();
        $.get("searchRegionyByIdCountry" + index + "/"+ id, {}, function(result){
            $("#selectId").html(result);
        });
    });
</script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</body>
</html>
