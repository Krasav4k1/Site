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
    <script   src="https://code.jquery.com/jquery-2.2.1.min.js" ></script>

</head>
<body>
<form method="post">
    <table align="center">
        <tr>
            <h1 align="center">Регістрація</h1>
        </tr>
        <tr>
            <th>Ім'я:</th>
            <td><input name = "firstName" type="text"/></td>
        </tr>
        <tr>
            <th>Фамілія:</th>
            <td><input name = "lastName" type="text"/></td>
        </tr>
        <tr>
            <th>E-Mail</th>
            <td><input  pattern = "^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" name = "emailUser" type="text"/></td>
        </tr>
        <tr>
            <th>Пароль:</th>
            <td><input pattern = "^[a-zA-Z0-9]+$" name = "password" type="password"/></td>
           </tr>
        <tr>
            <th>Повторіть пароль:</th>
            <td><input pattern = "^[a-zA-Z0-9]+$" name = "passwordRepid" type="password"/></td>
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
                    <tr>${IdCity}</tr>
                </div>
            </td>

        </tr>
        <tr>
            <th>День народження:</th>
            <td><input name = "day" type="text"/></td>
        </tr>
        <tr>
            <th>Місяць:</th>
            <td><input name = "mouth" type="text"/></td>
        </tr>
        <tr>
            <th>Рік:</th>
            <td><input name = "year" type="text"/></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Зареєструватися"/></td>
        </tr>
    </table>
</form>
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
</body>
</html>