<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <title>Альбоми</title>
</head>
<body>
<h1>Albom</h1>


<sf:form action="/albom/addFotoAlbom" modelAttribute="AlbomFoto" method="post">
    <fieldset>
        <table>
            <tr>
                <th>Назва альбома</th>
            </tr>
            <tr>
                <td><sf:input path="albomName"></sf:input></td>
                <td><input type="submit" value="додати альбом"></td>
            </tr>
        </table>
    </fieldset>
</sf:form>

<table>
    <tr>
        <c:forEach items="${AlbomFotoList}" var="albomFotoList">
    <tr>
        <td>
            <c:url value="/albom/${albomFotoList.id}/foto" var="url"/>
            <a href="${url}">${albomFotoList.albomName}</a>
        </td>
    </tr>
    </c:forEach>
    </tr>
</table>



</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script   src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>

</html>
