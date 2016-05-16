<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<sec:authentication var="principal" property="principal" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForUvedomlenia.css">
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
</head>
<body class="bodyClass">

    <div class="forUvidom"></div>

</body>
<script>


        var chatClient = new WebSocket("ws://localhost:8080/activation");
        var count = 0;
        var idElement;
        chatClient.onmessage = function (evt) {
            var JSONObject = JSON.parse(evt.data);
            var d = new Date();
            var nowTime = time_format(d);
            if ($('.forUvidom').text().length == 0) count = 0;

            count++;
            if(count <= 5 ){
                open(count,JSONObject);
            }else{
                count = 1;
                open(count,JSONObject);
            }
            function open (e,data){
                $('.forUvidom').append('<div class="glavWindowUvidomlenia glavWindowUvidomleniabottom'+e+'"= style=""  id="'+e+'" ><div class="mesegeUvidomInWindUvidom"  id="'+e+'" ><h4 class="nameUser"  id="'+e+'" >'+data["firstName"]+' '+data["lastName"]+'</h4><i class="glyphicon glyphicon-remove closeUvidomlenia" id="'+e+'"></i><h5 class="messegeInUvidom"  id="'+e+'" >'+data["messager"]+'</h5></div><div class="imgUserUvidomlenia"  id="'+e+'" ><a href="id'+data["id"]+'"><img src="'+data["userAvatar"]+'"  id="'+e+'" class="img"></a></div><h6 class="timeMesseg">'+nowTime+'</h6></div><audio src="/resources/allForSite/default/recivedMessage.mp3" autoplay></audio>');
                if (e > 1){
                    var bot = (count-1)*120;
                    var bottom ='bottom:'+bot+"px";
                    $('.glavWindowUvidomleniabottom'+e).attr('style',bottom);
                }
                $('.glavWindowUvidomlenia').hover(function(){
                    $(document.body).bind('mouseover', function(e) {
                        if (e.target.tagName.toLowerCase() == 'div') idElement = e.target.id;
                        $('#'+idElement).css("background","white");
                        $('.closeUvidomlenia').click(function(){
                            $('#'+idElement).remove();
                        });
                    });
                }, function(){
                    $('#'+idElement).css("background","rgba( 255, 255, 255, 0.439 )");
                    setTimeout('$(".glavWindowUvidomleniabottom'+e+'").remove()', 5000);
                    setTimeout('$(".glavWindowUvidomleniabottom'+e+'").attr("style","bottom:0px")', 4000);
                });
                setTimeout('$(".glavWindowUvidomleniabottom'+e+'").attr("style","bottom:0px")', 19000);
                setTimeout('$(".glavWindowUvidomleniabottom'+e+'").remove()', 20000);
            };

            TimeOutForCount = function(){
                count = 0;
            }

            function time_format(d) {
                hours = format_two_digits(d.getHours());
                minutes = format_two_digits(d.getMinutes());
                seconds = format_two_digits(d.getSeconds());
                return hours + ":" + minutes + ":" + seconds;
            }

            function format_two_digits(n) {
                return n < 10 ? '0' + n : n;
            }

        };
</script>
</html>