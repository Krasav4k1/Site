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
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
</head>
<body class="bodyClass">

</body>
<script>


        var chatClient = new WebSocket("ws://localhost:8080/activation");
        var count = 0;
        chatClient.onmessage = function (evt) {
            var JSONObject = JSON.parse(evt.data);
            var d = new Date();
            var nowTime = time_format(d);
            count++;
            if(count <= 5 ){
                open(count,JSONObject);
            }else{
                count = 1;
                open(count,JSONObject);
            }
            function open (e,data){
                $('.bodyClass').append(' <div class="glavWindowUvidomlenia glavWindowUvidomleniabottom'+e+'"= style=""><div class="mesegeUvidomInWindUvidom"><h4 class="nameUser">'+data["firstName"]+' '+data["lastName"]+'</h4><h5 class="messegeInUvidom">'+data["messager"]+'</h5></div><div class="imgUserUvidomlenia" ><img src="'+data["userAvatar"]+'" class="img"></div><h6 class="timeMesseg">'+nowTime+'</h6></div>');
                if (e > 1){
                    var bot = (count-1)*120;
                    var bottom ='bottom:'+bot+"px";
                    $('.glavWindowUvidomleniabottom'+e).attr('style',bottom);
                    setTimeout('$(".glavWindowUvidomleniabottom'+e+'").attr("style","bottom:0px")', 4000);
                }
                setTimeout('$(".glavWindowUvidomleniabottom'+e+'").remove()', 5000);
            };

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