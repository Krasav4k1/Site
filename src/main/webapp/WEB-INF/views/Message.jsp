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

        <div class="mainMessegeWindow">
            <div class="loadMore">загрузить ще...</div>

        </div>

        <div class="row">
            <div class="inputMesseges">
                <textarea class="inputMessegesLable" onkeydown = "if(event.keyCode == 13 && event.ctrlKey )document.getElementById('sendMessege').click()" ></textarea>
                <button class="sendMessege" id="sendMessege" onclick="sendMessegEventKey()" >Надіслати</button>
            </div>
        </div>

    </div>
</div>


<script>
    $(document).ready(function(){
        var indexUserResivedGlobal;
        $.get('getAllUserForMessegerPage.json',{},function(a){
            for (i = 0; i < a.length; i++) {
                $('.allFrendsMessege').append('<div class="row showAllUserOnMesseg"> <a id="hrefUserResived'+a[i].id+'" idResived="'+a[i].id+'"> <div class="boxForFrendsInAllMessegeFrends"> <img src="'+a[i].foto+'" class="img-rounded photoForUserInAllFrendsInMesseger"> <h5>'+a[i].firstName+' '+ a[i].lastName+'</h5> <h6></h6> </div> </a></div>');
                $('#hrefUserResived'+a[i].id).click(function(){
                    var indexUserResived = $(this).attr('idResived');
                    indexUserResivedGlobal = $(this).attr('idResived');
                    $.get('getDialog-Resived-'+indexUserResived,{},function(a){
                        $('.mainMessegeWindow').html('<div class="loadMore">загрузить ще...</div>');
                        for(var i = 0; i < a.length; i++){
                            if (a[i].userReceivedMessages.id == indexUserResived){
                                console.log(+a[i]);
                                $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                            }else{
                                console.log(+a[i]);
                                $('.mainMessegeWindow').append('<div class="row"> <div class="sendUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoSendMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                            }
                        }
                    });
                });
            }
        });



        sendMessegEventKey = function(){
            alert('send');
            var textMessege = $('.inputMessegesLable').val();
            var indexUserResived = indexUserResivedGlobal;
            $.get('MessegerUpdate'+indexUserResived+'-'+textMessege+'.json',{},function(a){
                console.log(a);
                var lastIndex = a.length - 1;
                    $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[lastIndex].userSentMessager.id+'"><img src="'+a[lastIndex].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[lastIndex].messager+'</h4> </div> </div>');
            });
        };
    });
</script>

</body>
</body>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>
