    <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <style>
        .errorblock{
            width: 400px;
            color:#000;
            background-color: #b74c4c;
            border: 2px solid #333;
            padding: 8px;
            margin: auto;
            margin-top: 10px;
        }
        .error{
            color: red;
            font-size: 20px;
            text-align: left;
        }
    </style>
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>


<sf:form method="post" modelAttribute="userObject" action="/register=user+add" >
    <sf:input path="id" id="id" type ="hidden"/>
<fieldset>
        <table align="center">
            <sf:errors path="*" element="div" cssClass="errorblock"/>
            <tr>
                <h1 align="center">Регістрація</h1>
            </tr>
            <tr>
                <th>Ім'я:</th>
                <td><sf:input path="firstName"/><sf:errors cssClass="error" path="firstName"/></td>
            </tr>
            <tr>
                <th>Фамілія:</th>
                <td><sf:input path="lastName"/><sf:errors cssClass="error" path="lastName"/></td>
            </tr>
            <tr>
                <th>E-Mail</th>
                <td><sf:input  path="email"/><sf:errors cssClass="error" path="email"/></td>
            </tr>
            <tr>
                <th>Пароль:</th>
                <td><sf:input path="password" type="password"/><sf:errors cssClass="error" path="password"/> </td>
            </tr>
            <tr>
                <th>Країна</th>
                <td>
                    <div id="countryDiv">
                        <select id="option" name = "IdCountry">
                            <c:forEach var="countryModel" items="${countryModel}">
                                <option value="${countryModel.id}">${countryModel.name}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <div id="select"></div>
                        <div id="selectObl"></div>
                        <div id="selectCity"></div>
                        <div id="selectId"></div>
            <%--<tr>${IdCit}</tr>--%>
            </div>
            </td>

            </tr>
            <tr>
                <th>День народження:</th>
                <td><sf:input path= "day" type="text"/><sf:errors cssClass="error" path="day"/><td>
            </tr>
            <tr>
                <th>Місяць:</th>
                <td><sf:input path="mouth" type="text"/><sf:errors cssClass="error" path="mouth"/> </td>
            </tr>
            <tr>
                <th>Рік:</th>
                <td><sf:input path="year" type="text"/><sf:errors cssClass="error" path="year"/></td>
            </tr>
            <tr>
                <td align="right"><input type="submit" value="Зареєструватися"/></td>
            </tr>
        </table>
        </fieldset>
</sf:form>


<script>

    $("#option").change(function(){
//        $.ajax({url: "searchRegionyByIdCountry", success: function(result){
//            $("#countryDiv").append(result);
//        }});
        var id = $("#option").val();
        index = "obl";
        $.get("searchRegionyByIdCountry" + index + "/"+ id, {}, function(result){
            $("#select").html(result);

        });
    });

</script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</body>
</html>