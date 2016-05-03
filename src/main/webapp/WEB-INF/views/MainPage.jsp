<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->
<head>
    <title>Головна сторінка ${user.firstName} ${user.lastName}</title>
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForMainPage.css">
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
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
                <div class="container">
                    <div class="row rowMain">
                        <div class="col-lg-5 col-md-5 wallLeft ">
                            <div id="carousel-example-generic" class="carousel slide imgBack" data-ride="carousel">
                                <div class="carousel-inner" role="listbox">


                                    <c:forEach items="${caruselPhoto.fotos}" var="fotos" varStatus="vs">
                                        <div class="item <c:if test='${vs.index == 0}'>active</c:if>">
                                            <img src="${fotos.foto}" class="caraselImg">
                                        </div>
                                    </c:forEach>

                                </div>
                                <a  data-toggle="modal" data-target=".bs-example-modal-sm"><img src="${user.foto}" id="avatar" class="imgAva"></a>
                            </div>








                                <%--MOdalAvatar--%>
                            <div class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                                <div class="modal-dialog modal-sm contentForModal">
                                    <div class="modal-content contentForModal">


                                        <div class="sideBarMenuHidden likeCount">
                                            <div class="countLikeAndDisLike countLikeDiv"></div>

                                            <div statyss="none" class="sidebarMy">

                                                <div class="containerForLikeAndDisLikeUser">
                                                    <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
                                                    <div class="nameUserPutLikeAndDisLike">
                                                        <h4 class="h4NameUserPutLikeAndDisLike acive">Andrii Blzniuk </h4>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>


                                        <div class="divForImgContent">
                                            <div id="myCarousel" class="carousel">
                                                <!-- Carousel items -->
                                                <div class="carousel-inner">
                                                    <div class="active item boxAva">
                                                        <button class="buutonLikeAva"><i class="glyphicon glyphicon-thumbs-up likeAva"></i></button>
                                                        <button class="buutonDisLikeAva"><i class="glyphicon glyphicon-thumbs-down likeAva"></i></button>
                                                        <img src="${avatarPhoto.get(0).foto}" dti="0" idAvatarPhoto="${avatarPhoto.get(0).id}" class="imgInModal">

                                                    </div>

                                                </div>
                                                <!-- Carousel nav -->
                                                <a class="carousel-control left  controlLeft" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                                                <a class="carousel-control right controlRight" href="#myCarousel" data-slide="next">&rsaquo;</a>
                                            </div>
                                        </div>
                                        <div class="panel ">
                                            <div class="panel-heading panelMoreForModalAva" role="tab" id="headingOne">

                                                <h1 class="countPhoto"></h1>
                                                <h1 class="countPhotoFinish"></h1>

                                                <button class="moreForModal" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne1" aria-expanded="true" aria-controls="collapseOne">
                                                    Більше...
                                                </button>
                                            </div>
                                            <div id="collapseOne1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOne">
                                                <div class="panel-body">
                                                    <div class="row">
                                                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 coomentBlock">
                                                            <h4 class="commentWords">Коменти</h4>
                                                        </div>
                                                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 optionBlock">
                                                            <h4 class="optionWords">Опції</h4>
                                                            <button class="buttonOption">Надіслати</button>
                                                            <br>
                                                            <button class="buttonOption">Опублікувати</button>
                                                            <br>
                                                            <button  type="button" data-toggle="modal" data-target=".bs-example-modal-lg" class="buttonOption" >
                                                                Редагувати
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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


    <div class="container">
        <div class="row rowMain">
            <div class="col-lg-5 col-md-5 wallLeft ">
                <div id="carousel-example-generic" class="carousel slide imgBack" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">

                        <c:forEach items="${caruselPhoto.fotos}" var="fotos" varStatus="vs">
                            <div class="item <c:if test='${vs.index == 0}'>active</c:if>">
                                <img src="${fotos.foto}" class="caraselImg">
                            </div>
                        </c:forEach>

                    </div>
                    <a  data-toggle="modal" data-target=".bs-example-modal-sm"><img src="${user.foto}" id="avatar" class="imgAva"></a>
                </div>








                <%--MOdalAvatar--%>
                <div class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog modal-sm contentForModal">
                        <div class="modal-content contentForModal">



                            <div class="sideBarMenuHidden likeCount">
                                <div class="countLikeAndDisLike countLikeDiv"></div>
                                <div statyss="none" class="sidebarMy">

                                    <div class="morLikeAndDisLikeFrends">
                                        <button class="buttomMOreLikeAndDisLikeFrends">
                                            <i class="glyphicon glyphicon-menu-hamburger iMoreLikeAndDisLikeFrends"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>






                            <div class="divForImgContent">
                                <div id="myCarousel" class="carousel">
                                    <!-- Carousel items -->
                                    <div class="carousel-inner">
                                            <div class="active item boxAva">
                                            <button class="buutonLikeAva"><i class="glyphicon glyphicon-thumbs-up likeAva"></i></button>
                                            <button class="buutonDisLikeAva"><i class="glyphicon glyphicon-thumbs-down likeAva"></i></button>
                                            <img src="${avatarPhoto.get(0).foto}" dti="0" idAvatarPhoto="${avatarPhoto.get(0).id}" class="imgInModal">

                                        </div>

                                    </div>
                                    <!-- Carousel nav -->
                                    <a class="carousel-control left  controlLeft" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                                    <a class="carousel-control right controlRight" href="#myCarousel" data-slide="next">&rsaquo;</a>
                                </div>
                            </div>
                            <div class="panel ">
                                <div class="panel-heading panelMoreForModalAva" role="tab" id="headingOne">

                                    <h1 class="countPhoto"></h1>
                                    <h1 class="countPhotoFinish"></h1>

                                    <button class="moreForModal" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne1" aria-expanded="true" aria-controls="collapseOne">
                                        Більше...
                                    </button>
                                </div>
                                <div id="collapseOne1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 coomentBlock">
                                                <h4 class="commentWords">Коменти</h4>
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 optionBlock">
                                                <h4 class="optionWords">Опції</h4>
                                                <button class="buttonOption">Надіслати</button>
                                                <br>
                                                <button class="buttonOption">Опублікувати</button>
                                                <br>
                                                <button  type="button" data-toggle="modal" data-target=".bs-example-modal-lg" class="buttonOption" >
                                                    Редагувати
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--MOdalRedaguv--%>
                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg redagyvatuModal">
                        <div class="modal-content">
                            <div class="headerModalRedag">
                                Редагування основної фотографії
                            </div>
                            <div class="containerRedagModel">
                                <br>
                                Загрузка фото
                                <sf:form action="/id${user.id}/addFileAvatarFoto?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post" >
                                    <input type="file" name="file" class="selectPhoto">
                                    <button type="submit" class="addAvatarPhoto"><a type="submit">Загрузити</a></button>
                                </sf:form>
                                <br>
                                <br>
                                Видалити дане фото
                                <br>
                                    <button class="daleteUserButto">Видалити</button>
                            </div>
                        </div>
                    </div>
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

<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function(){
        $("#avatar").stop().fadeOut(3000);
        $(".imgBack").hover(function(e){
            $("#avatar").stop().fadeIn(800);
        }, function(e){
            $("#avatar").stop().fadeOut(800);
        });

    var countPhotoFinish;

    $('.imgAva').click(function(){
        $.get('/countPhoto-user-'+'${user.id}',{},function(e){
            lol = $('.imgInModal');
            var img = lol;
            countPhotoFinish = parseInt(e);
            $('.countPhotoFinish').text(e);
            $('.countPhoto').text(parseInt(img.attr('dti'))+1);
        });
        if ($('.sidebarMy').attr('statyss') == 'disLike' || $('.sidebarMy').attr('statyss') == 'like'){
            $(".sidebarMy").toggleClass("sidebarForAvaModel");
            $('.sidebarMy').attr('statyss','none')
        }
    });

    $('.controlRight').click(function(){
            lol = $('.imgInModal');
        var img = lol;
        var index = parseInt(img.attr('dti'));
        var countPhoto;
            $.get('/getFoto/user='+"${user.id}"+"/foto="+ index + "/right",{}, function(e){
                countPhoto = e[1]-1;
                if (index == parseInt(countPhoto)){
                    img.attr('dti', parseInt(0));
                    img.attr('src', e[0]);
                    img.attr('idAvatarPhoto', e[2]);
                }else{
                    img.attr('src', e[0]);
                    img.attr('dti', parseInt(index+1));
                    img.attr('idAvatarPhoto', e[2]);
                }
//               $('.carousel-inner').append('<div class="item boxAva"> <button class="buutonLikeAva"><i class="glyphicon glyphicon-thumbs-up likeAva"></i></button> <button class="buutonDisLikeAva"><i class="glyphicon glyphicon-thumbs-down likeAva"></i></button> <img src="'+e+'"  ind="'+ index2 +'"  class="imgInModal"> </div> ');
            });


            if ((parseInt(img.attr('dti'))+1) >= countPhotoFinish){
                $('.countPhoto').text(1);
            }else{
                $('.countPhoto').text((parseInt(img.attr('dti'))+1)+1);
            }
        if ($('.sidebarMy').attr('statyss') == 'disLike' || $('.sidebarMy').attr('statyss') == 'like'){
            $(".sidebarMy").toggleClass("sidebarForAvaModel");
            $('.sidebarMy').attr('statyss','none')
        }
        });

      $('.controlLeft').click(function(){
          lol1 = $('.imgInModal');
          var img1 = lol1;
          var index1 = parseInt(img1.attr('dti'));
          var countPhoto1;
          $.get('/getFoto/user='+"${user.id}"+"/foto="+ index1 + "/left",{}, function(e) {
              countPhoto1 = parseInt(e[1]-1);
              if (index1 == 0){
                  img1.attr('dti', parseInt(countPhoto1));
                  img1.attr('src', e[0]);
                  img1.attr('idAvatarPhoto', e[2]);
              }else{
                  img1.attr('src', e[0]);
                  img1.attr('dti', parseInt(index1-1));
                  img1.attr('idAvatarPhoto', e[2]);
              }
        });
          if ((parseInt(img1.attr('dti'))+1) <= 1){
              $('.countPhoto').text(countPhotoFinish);
          }else{
              $('.countPhoto').text((parseInt(img1.attr('dti'))+1)-1);
          }
          if ($('.sidebarMy').attr('statyss') == 'disLike' || $('.sidebarMy').attr('statyss') == 'like'){
              $(".sidebarMy").toggleClass("sidebarForAvaModel");
              $('.sidebarMy').attr('statyss','none')
          }
      });


        $('.buutonLikeAva').click(function(){
            $('.containerForLikeAndDisLikeUser').remove();
            var lol = $('.imgInModal');
            var img = lol;
            var nomerPhoto = parseInt(img.attr('idAvatarPhoto'));
            $.get('/addLikeForPhoto'+nomerPhoto+'/user-'+'${user.id}',{},function(e){
                $('.countLikeAndDisLike').text(e);
            $.get('/photoUserPutLike-foto-'+nomerPhoto+'.json',{},function(e){
                for(i=0 ;i <= e.length;i++){
                 $(".sidebarMy").append('<div class="containerForLikeAndDisLikeUser"> <a href="#"><img class="img-circle putLikeAndDisLikeUser active" src="'+ e[i].foto+'"/></a> <div class="nameUserPutLikeAndDisLike"> <h4 class="h4NameUserPutLikeAndDisLike acive">'+e[i].firstName+ ' '+e[i].lastName+' </h4> </div> </div>');
                 $(".putLikeAndDisLikeUser").removeClass("active");
                    console.log(i)
             }
            });
            });
            if ($('.sidebarMy').attr('statyss') == 'like'){
                $(".sidebarMy").toggleClass("sidebarForAvaModel");
            }
            if ($('.sidebarMy').attr('statyss') == 'like' || $('.sidebarMy').attr('statyss') == 'none' ){
                if($('.sidebarMy').attr('statyss') == 'like'){
                    setTimeout('$(".sidebarMy").toggleClass("sidebarForAvaModel")', 1000);
                    setTimeout('$(".putLikeAndDisLikeUser").toggleClass("active")', 1000);
                    $('.sidebarMy').attr('statyss','disLike')
                }else{
                    $(".sidebarMy").toggleClass("sidebarForAvaModel");
                    $('.sidebarMy').attr('statyss','disLike')
                }
            }

        });


        $('.buutonLikeAva').hover(function(){
            var lol = $('.imgInModal');
            var img = lol;
            var nomerPhoto = parseInt(img.attr('idAvatarPhoto'));
            $.get('/likeForFoto='+nomerPhoto,{},function(e){
                $('.countLikeAndDisLike').text(e);
            });
            $(".likeCount").toggleClass("likeBox");
        });


        $('.buutonDisLikeAva').click(function(){
            $('.containerForLikeAndDisLikeUser').remove();
            var lol = $('.imgInModal');
            var img = lol;
            var nomerPhoto = parseInt(img.attr('idAvatarPhoto'));
            $.get('/addDisLikeForPhoto'+nomerPhoto+'/user-'+'${user.id}',{},function(e){
                $('.countLikeAndDisLike').text(e);
                $.get('/photoUserPutDisLike-foto-'+nomerPhoto+'.json',{},function(e){
                    for(i=0 ;i <= e.length;i++){
                        $(".sidebarMy").append(' <div class="containerForLikeAndDisLikeUser"> <a href="#"><img class="img-circle putLikeAndDisLikeUser active" src="'+ e[i].foto+'"/></a> <div class="nameUserPutLikeAndDisLike"> <h4 class="h4NameUserPutLikeAndDisLike acive">'+e[i].firstName+ ' '+e[i].lastName+' </h4> </div> </div>');
                        $(".putLikeAndDisLikeUser").removeClass("active");
                        console.log(i)
                    }
                });
            });
            if ($('.sidebarMy').attr('statyss') == 'disLike'){
                $(".sidebarMy").toggleClass("sidebarForAvaModel");
            }
            if ($('.sidebarMy').attr('statyss') == 'disLike' || $('.sidebarMy').attr('statyss') == 'none'){
                if ($('.sidebarMy').attr('statyss') == 'disLike') {
                    setTimeout('$(".sidebarMy").toggleClass("sidebarForAvaModel")', 1000);
                    setTimeout('$(".putLikeAndDisLikeUser").toggleClass("active")', 1000);
                    $('.sidebarMy').attr('statyss','like')
                }else{
                    $(".sidebarMy").toggleClass("sidebarForAvaModel");
                    $('.sidebarMy').attr('statyss','like')
                }
            }
        });


        $('.buutonDisLikeAva').hover(function(){
            var lol = $('.imgInModal');
            var img = lol;
            var nomerPhoto = parseInt(img.attr('idAvatarPhoto'));
            $.get('/disLikeForFoto='+nomerPhoto,{},function(e){
                $('.countLikeAndDisLike').text(e);
            });
            $(".likeCount").toggleClass("likeBox");
        });


        $('.addAvatarPhoto').click(function(){
            $('.countPhotoFinish').text(countPhotoFinish+1);
        });

        $('.daleteUserButto').click(function(){
            lol = $('.imgInModal');
            var img = lol;
            var indexDaletePhoto = parseInt(img.attr('idAvatarPhoto'));
            var index = parseInt(img.attr('dti'));
            var countPhoto;
            $.get('/id'+'${user.id}'+'/deleFileAvatarFoto'+indexDaletePhoto,{},function(){
                $.get('/getFoto/user='+"${user.id}"+"/foto="+ index + "/right",{}, function(e){
                    countPhoto = e[1]-1;
                    if (index == parseInt(countPhoto)){
                        img.attr('dti', parseInt(0));
                        img.attr('src', e[0]);
                        img.attr('idAvatarPhoto', e[2]);
                    }else{
                        img.attr('src', e[0]);
                        img.attr('dti', parseInt(index+1));
                        img.attr('idAvatarPhoto', e[2]);
                    }
                    $('.countPhotoFinish').text(countPhotoFinish-1);
            });
            });
        });


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
        });
    });
</script>



</html>