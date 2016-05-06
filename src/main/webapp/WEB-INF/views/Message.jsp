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
    <title>Повідомлення</title>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
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
        </div>

        <div class="mainMessegeWindow" id ="mainMessegeWindow">
            <div class="loadMore" beginCount="" >загрузить ще...</div>
        </div>

        <div class="row">
            <div class="inputMesseges">
                <textarea class="inputMessegesLable" onkeydown = "if(event.keyCode == 13 && event.ctrlKey )document.getElementById('sendMessege').click()" ></textarea>
                <button class="sendMessege" id="sendMessege" onclick="sendMessegEventKey()" >Надіслати</button>
            </div>
        </div>

    </div>
</div>

<%--<script src="/resources/allForSite/jsForJsp/jsForMessegerJSP.js"/>--%>
<script>
    $(document).ready(function(){
        var indexUserResivedGlobal;
        var beginCount = 0;
        $.get('getAllUserForMessegerPage.json',{},function(a){
            for (var i = 0; i < a.length; i++) {
                $('.allFrendsMessege').append('<div class="row showAllUserOnMesseg"> <a id="hrefUserResived'+a[i].id+'" idResived="'+a[i].id+'"> <div class="boxForFrendsInAllMessegeFrends"> <img src="'+a[i].foto+'" class="img-rounded photoForUserInAllFrendsInMesseger"> <h5>'+a[i].firstName+' '+ a[i].lastName+'</h5> <h6 class="lastMessegerForBox"></h6> </div> </a></div>');
                $('#hrefUserResived'+a[i].id).hover(function() {
                    var indexUserResived = $(this).attr('idResived');
                    $.get('getDialog-Resived-'+indexUserResived,{},function(a){
                        $('.lastMessegerForBox').html('');
                        var lastIndex = a.length - 1;
                        $('.lastMessegerForBox').html(a[lastIndex].messager);
                    });
                });
                $('#hrefUserResived'+a[i].id).click(function(){
                    var indexUserResived = $(this).attr('idResived');
                    indexUserResivedGlobal = $(this).attr('idResived');
                    beginCount = 0;
                    $.get('getDialog-Resived-'+indexUserResived+'-'+beginCount,{},function(a){
                        if(a.length == 10) {
                            $('.mainMessegeWindow').html('<div class="loadMore">загрузить ще...</div>');
                            $('.loadMore').css("display","inline-block");
                            $('.loadMore').click(function(){
                                beginCount += 10;
                                addAfterMesegger();
                            });
                        }
                        for(var i = a.length-1; i >= 0; i--){
                            if (a[i].userReceivedMessages.id == indexUserResived){
                                $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                            }else{
                                $('.mainMessegeWindow').append('<div class="row"> <div class="sendUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoSendMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                            }
                        }
                        setTimeout('document.getElementById("mainMessegeWindow").scrollTop += 10000',50);
                    });
                });
            }

            addAfterMesegger = function(){
                $.get('getDialog-Resived-'+indexUserResivedGlobal+'-'+beginCount,{},function(a){
                    if(a.length != 10) {
                        $('.loadMore').css("display","none");
                    }
                    for(var i = 0; i < a.length; i++){
                        if (a[i].userReceivedMessages.id == indexUserResivedGlobal){
                            $('.loadMore').after('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                        }else{
                            $('.loadMore').after('<div class="row"> <div class="sendUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoSendMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                        }
                    }
                });
            }

        });

        sendMessegEventKey = function() {
            submitForm();
        }
        function submitForm() {
            var roles = [$('.inputMessegesLable').val(),indexUserResivedGlobal];
            jQuery.ajax({
                type: "POST",
                url: "/sendMessege?${_csrf.parameterName}=${_csrf.token}",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(roles),
                success: function (a){
                    var firstIndex = 0;
                    $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[firstIndex].userSentMessager.id+'"><img src="'+a[firstIndex].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[firstIndex].messager+'</h4> </div> </div>');
                    $('.inputMessegesLable').val('');
                    setTimeout('document.getElementById("mainMessegeWindow").scrollTop += 10000',50);
                }
            });
        }

    });
</script>
</body>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>
