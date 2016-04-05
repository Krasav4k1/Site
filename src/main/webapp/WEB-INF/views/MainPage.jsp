<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->
<head>
    <title>Головна сторінка ${user.firstName} ${user.lastName}</title>
    <style>
        <%@include file="cssForJsp/StyleForMainPage.css"%>

    </style>
    <script   src="https://code.jquery.com/jquery-2.2.1.min.js" ></script>
</head>
<body>


<security:authorize
        access="isAuthenticated() and hasRole('ROLE_ADMIN')">
    <h1>Це буде бачити тільки адмін</h1>
    <%--Це буде бачити тільки адмін--%>
</security:authorize>

<security:authorize access="!isAuthenticated()">
    <%--Це буде бачити користувач який не залогінився--%>
    <h1>Це буде бачити користувач який не залогінився</h1>
</security:authorize>

<security:authorize access="isAuthenticated() and principal.username!='${user.id}' and !hasRole('ROLE_ADMIN')">
    <%--Це буде бачити користувач який залогінився він не являється власником сторінки і він не адмін--%>
    Текущая дата: <%= new java.util.Date()%>


    <div class="container">
        <div class="row rowMain">
            <div class="col-lg-5 col-md-5 wallLeft ">
                <div id="carousel-example-generic" class="carousel slide imgBack" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">

                        <c:forEach items="${user.albomFotoUsers.get(1).fotos}" var="fotos" varStatus="vs">

                            <div class="item <c:if test='${vs.index == 0}'>active</c:if>">
                                <img src="${fotos.foto}" class="caraselImg"><!--https://pp.vk.me/c619824/v619824891/9f4/SCqkDHBblMI.jpg-->
                            </div>
                        </c:forEach>
                    </div>
                    <a href="/"><img src="${user.foto}" id="avatar" class="imgAva"></a>
                </div>


                    <%--<div id="btn-friends">--%>

                        <c:if test="${!friendsPresent}">
                            <button  id="addFriends" frid="${user.id}" type="button" class="btn">
                                Добавити до друзі</button>
                        </c:if>

                        <c:if test="${friendsPresent}">
                            <div></div>
                            <div class="dropup">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    У вас в друзях
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                                    <li><a href="#">Добавити в чорний список</a></li>
                                    <li><a href="#"></a>Подарити подарок</li>
                                    <li ><a href="/daleteFrend/${user.id}">Видалити з друзів</a></li>
                                </ul>
                            </div>
                        </c:if>




                <div class="dropup"  style="display: none" id="addsFriends">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        У вас в друзях
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                        <li><a href="#">Добавити в чорний список</a></li>
                        <li><a href="#"></a>Подарити подарок</li>
                        <li ><a href="/daleteFrend/${user.id}">Видалити з друзів</a></li>
                    </ul>
                </div>







                <div class="row"></div>
                <h3 class="name">${user.firstName} ${user.lastName}</h3>
                <div class="row">
                    <div class="col-lg-6">
                        <h4 class="nameInfo">Місто<h5 class="h5Info">${user.city.name}</h5></h4>
                        <h4 class="nameInfo">Сімейний стан<h5 class="h5Info">В активному пошуку</h5></h4>
                    </div>
                    <div class="lg-6">
                        <h4 class="nameInfo">Мови<h5 class="h5Info">Українська, Російська</h5></h4>
                        <h4 class="nameInfo">Місце навчання<h5 class="h5Info">НУ «ЛП»</h5></h4>
                    </div>
                </div>

                <div class="panel panelMoreInfo">

                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a class="moreInfo" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Дізнатися більше
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">

                            <h4 class="nameInfoMoreAboutGlav">Контакти:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Телефон:</th>
                                    <td class="rezInfoMoreAbout">555 77 854</td>
                                </tr>
                                <tr>
                                    <td class="rezInfoMoreAbout">555 77 855</td>
                                </tr>
                            </table>

                            <h4 class="nameInfoMoreAboutGlav">Освіта:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">ВНЗ:</th>
                                    <td class="rezInfoMoreAbout">НУ «ЛП»</td>
                                </tr>
                            </table>

                            <h4 class="nameInfoMoreAboutGlav">Життєва позиція:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Політ. вподобання:</th>
                                    <td class="rezInfoMoreAbout">Монархiчнi</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Світогляд:</th>
                                    <td class="rezInfoMoreAbout">Вірю в Бога</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Ставл. до паління:</th>
                                    <td class="rezInfoMoreAbout">Різко негативне</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Ставл. до алкоголю:</th>
                                    <td class="rezInfoMoreAbout">Різко негативне</td>
                                </tr>
                            </table>



                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 wallRight col-lg-offset-1 col-md-offset-1"></div>
        </div>
    </div>


</security:authorize>

<security:authorize access="isAuthenticated() and principal.username =='${user.id}'">
    <%--Це буде бачити користувач який є власником сторінки--%>
    Текущая дата: <%= new java.util.Date()%>

    <div class="container">
        <div class="row rowMain">
            <div class="col-lg-5 col-md-5 wallLeft ">
                <div id="carousel-example-generic" class="carousel slide imgBack" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">

                        <c:forEach items="${user.albomFotoUsers.get(1).fotos}" var="fotos" varStatus="vs">


                            <div class="item <c:if test='${vs.index == 0}'>active</c:if>">
                                <img src="${fotos.foto}" class="caraselImg"><!--https://pp.vk.me/c619824/v619824891/9f4/SCqkDHBblMI.jpg-->
                            </div>

                            </c:forEach>
                    </div>
                    <a href="/"><img src="${user.foto}" id="avatar" class="imgAva"></a>
                </div>



                <div class="row"></div>
                <h3 class="name">${user.firstName} ${user.lastName}</h3>
                <div class="row">
                    <div class="col-lg-6">
                        <h4 class="nameInfo">Місто<h5 class="h5Info">${user.city.name}</h5></h4>
                        <h4 class="nameInfo">Сімейний стан<h5 class="h5Info">В активному пошуку</h5></h4>
                    </div>
                    <div class="lg-6">
                        <h4 class="nameInfo">Мови<h5 class="h5Info">Українська, Російська</h5></h4>
                        <h4 class="nameInfo">Місце навчання<h5 class="h5Info">НУ «ЛП»</h5></h4>
                    </div>
                </div>

                <div class="panel panelMoreInfo">

                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a class="moreInfo" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Дізнатися більше
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">

                            <h4 class="nameInfoMoreAboutGlav">Контакти:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Телефон:</th>
                                    <td class="rezInfoMoreAbout">555 77 854</td>
                                </tr>
                                <tr>
                                    <td class="rezInfoMoreAbout">555 77 855</td>
                                </tr>
                            </table>

                            <h4 class="nameInfoMoreAboutGlav">Освіта:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">ВНЗ:</th>
                                    <td class="rezInfoMoreAbout">НУ «ЛП»</td>
                                </tr>
                            </table>

                            <h4 class="nameInfoMoreAboutGlav">Життєва позиція:</h4>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Політ. вподобання:</th>
                                    <td class="rezInfoMoreAbout">Монархiчнi</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Світогляд:</th>
                                    <td class="rezInfoMoreAbout">Вірю в Бога</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Ставл. до паління:</th>
                                    <td class="rezInfoMoreAbout">Різко негативне</td>
                                </tr>
                            </table>

                            <table style="width:100%" class="tableInMoreAbout">
                                <tr>
                                    <th rowspan="3" class="nameInfoMoreAbout">Ставл. до алкоголю:</th>
                                    <td class="rezInfoMoreAbout">Різко негативне</td>
                                </tr>
                            </table>



                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 wallRight col-lg-offset-1 col-md-offset-1"></div>
        </div>
    </div>
</security:authorize>




</body>

<script   src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script>
    $(document).ready(function(){
        $("#avatar").stop().fadeOut(3000);
        $(".imgBack").hover(function(e){
            $("#avatar").stop().fadeIn(800);
        }, function(e){
            $("#avatar").stop().fadeOut(800);
        })
    });
</script>

<script>
    $( document ).ready(function() {
        $("#addFriends").click(function () {
            var id = $(this).attr("frid");
            $.get("/addFriends/"+id,{},function () {
              $("#addFriends").css("display","none");
                $("#addsFriends").css("display","block");
            })
        })
    });
</script>



</html>