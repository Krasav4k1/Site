<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            if(count <= 5 ){
                count++;
                open(count,evt);
            }else{
                count = 0;
            }
            function open (e,date){
                $('.bodyClass').append(' <div class="glavWindowUvidomlenia glavWindowUvidomleniabottom'+e+'"= style=""><div class="mesegeUvidomInWindUvidom"><h4 class="messegeInUvidom">'+date.data+'</h4></div><div class="imgUserUvidomlenia" ><img src="" class="img"></div> </div>');
                if (e > 1){
                    var bot = (count-1)*120;
                    var bottom ='bottom:'+bot+"px";
                    $('.glavWindowUvidomleniabottom'+e).attr('style',bottom);
                    setTimeout('$(".glavWindowUvidomleniabottom'+e+'").attr("style","bottom:0px")', 4000);
                }
                setTimeout('$(".glavWindowUvidomleniabottom'+e+'").remove()', 5000);
            };
        };
</script>
</html>