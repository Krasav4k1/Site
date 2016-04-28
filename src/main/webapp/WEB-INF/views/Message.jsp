<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <title>Повідомлення</title>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForMessege.css">
</head>
<body>


<div class="container">
    <div class="row">
        <div class="frendsStartMesseger">
            <span class="badge allCountNoReadMesseges">659</span>
            <div class="containerForLikeAndDisLikeUser">
                <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"><span class="badge countMotReadyMessege">164</span></a>
            </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"><span class="badge countMotReadyMessege">1</span></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"><span class="badge countMotReadyMessege">14</span></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"></a>
        </div><div class="containerForLikeAndDisLikeUser">
            <a href="#"><img src="nurGQMK2C8I%20(1).jpg" alt="..." class="img-circle putLikeAndDisLikeUser active"><span class="badge countMotReadyMessege">14</span></a>
        </div>
        </div>


        <div class="allFrendsMessege">
            <div class="row">
                <input type="text" placeholder="Пошук" class="form-control seachInput"/>
            </div>

            <c:forEach items="${getAllUserForMessegerPage}" var="userFrend">
            <div class="row">
                <a href="">
                    <div class="boxForFrendsInAllMessegeFrends">
                        <img src="${userFrend.foto}" class="img-rounded photoForUserInAllFrendsInMesseger">
                        <h5>${userFrend.firstName} ${userFrend.lastName}</h5>
                        <h6>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta vero consequuntur earum inventore veniam voluptas alias eum odio, repellat tempore odit dolorem, aspernatur ut totam fugit, voluptatibus dolore, doloribus labore.</h6>
                    </div>
                </a>
            </div>
            </c:forEach>


        </div>

        <div class="mainMessegeWindow">

            <div class="row">
                <div class="reciveUserMesseges">
                    <a href=""><img src="P5TnMJYgJM0.jpg" class="img-rounded photoForUserWhoResiverMessege"></a>
                    <h4>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    </h4>
                </div>
            </div>

            <div class="row">
                <div class="reciveUserMesseges">
                    <a href=""><img src="P5TnMJYgJM0.jpg" class="img-rounded photoForUserWhoResiverMessege"></a>
                    <h4>
                        Lorem ipsum dolor sit Lorem ipsum dolor sit.
                    </h4>
                </div>
            </div>

            <div class="row">
                <div class="sendUserMesseges">
                    <a href=""><img src="nurGQMK2C8I.jpg" class="img-rounded photoForUserWhoSendMessege"></a>
                    <h4>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    </h4>
                </div>
            </div>

            <div class="row">
                <div class="reciveUserMesseges">
                    <a href=""><img src="P5TnMJYgJM0.jpg" class="img-rounded photoForUserWhoResiverMessege"></a>
                    <h4>
                        Lorem ipsum dolor sit Lorem ipsum dolor sit. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    </h4>
                </div>
            </div>

            <div class="row">
                <div class="sendUserMesseges">
                    <a href=""><img src="nurGQMK2C8I.jpg" class="img-rounded photoForUserWhoSendMessege"></a>
                    <h4>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero ut, dolorum veritatis obcaecati delectus iure cupiditate minus quasi, impedit consequatur qui aspernatur, alias ipsam placeat esse. Laboriosam aliquam dolores delectus quis harum iure officia culpa velit consectetur assumenda doloribus quisquam aut, mollitia explicabo impedit rerum expedita eveniet voluptate accusamus sapiente.
                    </h4>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="inputMesseges">
                <textarea class="inputMessegesLable" ></textarea>
                <button class="sendMessege">Надіслати</button>
            </div>
        </div>

    </div>
</div>



</body>
</body>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>
