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


<script src="/resources/allForSite/webSockets/sockjs-0.3.4.js"></script>
<script src="/resources/allForSite/webSockets/stomp.js"></script>
<script src="/resources/allForSite/webSockets/jquery-2.1.0.min.js"></script>
<script>
    $(document).ready(function() {
        connect();
    });
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function(frame) {
            var whoami = frame.headers['user-name'];
            stompClient.subscribe('/user/queue/messages', function(message) {
                showMessage(JSON.parse(message.body));
            });
            stompClient.subscribe('/topic/active', function(activeMembers) {
                stompClient.send('/app/activeUsers', {}, '');
            });
        });
    }

        var count = 0;
        var idElement;
        function showMessage (evt) {
            var JSONObject = evt;
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
                $('.forUvidom').append('<div class="glavWindowUvidomlenia glavWindowUvidomleniabottom'+e+'"= style=""  id="'+e+'" ><div class="mesegeUvidomInWindUvidom"  id="'+e+'" ><h4 class="nameUser"  id="'+e+'" >'+data["firstNameAndLastName"] +'</h4><i class="glyphicon glyphicon-remove closeUvidomlenia" id="'+e+'"></i><h5 class="messegeInUvidom"  id="'+e+'" >'+data["message"]+'</h5></div><div class="imgUserUvidomlenia"  id="'+e+'" ><a href="id'+data["sender"]+'"><img src=" '+data["fotoSender"]+' "  id="'+e+'" class="img"></a></div><h6 class="timeMesseg">'+nowTime+'</h6></div><audio src="/resources/allForSite/default/recivedMessage.mp3" autoplay></audio>');
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


<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Chat</title>--%>
    <%--<script src="/resources/allForSite/webSockets/sockjs-0.3.4.js"></script>--%>
    <%--<script src="/resources/allForSite/webSockets/stomp.js"></script>--%>
    <%--<script src="/resources/allForSite/webSockets/jquery-2.1.0.min.js"></script>--%>
    <%--<link href="/resources/allForSite/webSockets/chat.css" rel="stylesheet" type="text/css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
    <%--<div id="userList">--%>
    <%--</div>--%>
<%--</div>--%>
<%--<script type="text/javascript">--%>
    <%--var stompClient = null;--%>
    <%--var socket = null;--%>
    <%--var whoami = null;--%>

    <%--function connect() {--%>
        <%--socket = new SockJS('/chat');--%>
        <%--stompClient = Stomp.over(socket);--%>
        <%--stompClient.connect('', '', function(frame) {--%>
            <%--whoami = frame.headers['user-name'];--%>
            <%--console.log('Connected: ' + frame);--%>
            <%--stompClient.subscribe('/user/queue/messages', function(message) {--%>
                <%--showMessage(JSON.parse(message.body));--%>
            <%--});--%>
            <%--stompClient.subscribe('/topic/active', function(activeMembers) {--%>
                <%--showActive(activeMembers);--%>
            <%--});--%>
        <%--});--%>
    <%--}--%>

    <%--function showActive(activeMembers) {--%>
        <%--renderActive(activeMembers.body);--%>
        <%--stompClient.send('/app/activeUsers', {}, '');--%>
    <%--}--%>

    <%--function renderActive(activeMembers) {--%>
        <%--var previouslySelected = $('.user-selected').text();--%>
        <%--var usersWithPendingMessages = new Object();--%>
        <%--$.each($('.pending-messages'), function(index, value) {--%>
            <%--usersWithPendingMessages[value.id.substring(5)] = true; // strip the user---%>
        <%--});--%>
        <%--var members = $.parseJSON(activeMembers);--%>
        <%--var userDiv = $('<div>', {id: 'users'});--%>
        <%--$.each(members, function(index, value) {--%>
            <%--if (value === whoami) {--%>
                <%--return true;--%>
            <%--}--%>
            <%--var userLine = $('<div>', {id: 'user-' + value});--%>
            <%--userLine.addClass('user-entry');--%>
            <%--if (previouslySelected === value) {--%>
                <%--userLine.addClass('user-selected');--%>
            <%--}--%>
            <%--else {--%>
                <%--userLine.addClass('user-unselected');--%>
            <%--}--%>
            <%--var userNameDisplay = $('<span>');--%>
            <%--userNameDisplay.html(value);--%>
            <%--userLine.append(userNameDisplay);--%>
            <%--userLine.click(function() {--%>
                <%--var foo = this;--%>
                <%--$('.chat-container').hide();--%>
                <%--$('.user-entry').removeClass('user-selected');--%>
                <%--$('.user-entry').addClass('user-unselected');--%>
                <%--userLine.removeClass('user-unselected');--%>
                <%--userLine.removeClass('pending-messages');--%>
                <%--userLine.addClass('user-selected');--%>
                <%--userLine.children('.newmessage').remove();--%>
                <%--var chatWindow = getChatWindow(value);--%>
                <%--chatWindow.show();--%>
            <%--});--%>
            <%--if (value in usersWithPendingMessages) {--%>
                <%--userLine.append(newMessageIcon());--%>
                <%--userLine.addClass('pending-messages');--%>
            <%--}--%>
            <%--userDiv.append(userLine);--%>
        <%--});--%>
        <%--$('#userList').html(userDiv);--%>
    <%--}--%>

    <%--function disconnect() {--%>
        <%--stompClient.disconnect();--%>
        <%--console.log("Disconnected");--%>
    <%--}--%>

    <%--function sendMessageTo(user) {--%>
        <%--var chatInput = '#input-chat-' + user;--%>
        <%--var message = $(chatInput).val();--%>
        <%--if (!message.length) {--%>
            <%--return;--%>
        <%--}--%>
        <%--stompClient.send("/app/chat", {}, JSON.stringify({--%>
            <%--'recipient': user,--%>
            <%--'message' : message--%>
        <%--}));--%>
        <%--$(chatInput).val('');--%>
        <%--$(chatInput).focus();--%>
    <%--}--%>

    <%--function getChatWindow(userName) {--%>
        <%--var existingChats = $('.chat-container');--%>
        <%--var elementId = 'chat-' + userName;--%>
        <%--var containerId = elementId + '-container';--%>
        <%--var selector = '#' + containerId;--%>
        <%--var inputId = 'input-' + elementId;--%>
        <%--if (!$(selector).length) {--%>
            <%--var chatContainer = $('<div>', {id: containerId, class: 'chat-container'});--%>
            <%--var chatWindow = $('<div>', {id: elementId, class: 'chat'});--%>
            <%--var chatInput = $('<textarea>', {id: inputId, type: 'text', class: 'chat-input', rows: '2', cols: '75',--%>
                <%--placeholder: 'Enter a message.  Something deep and meaningful.  Something you can be proud of.'});--%>
            <%--var chatSubmit = $('<button>', {id: 'submit-' + elementId, type: 'submit', class: 'chat-submit'})--%>
            <%--chatSubmit.html('Send');--%>

            <%--chatInput.keypress(function(event) {--%>
                <%--if (event.which == 13) {--%>
                    <%--var user = event.currentTarget.id.substring(11); // gets rid of 'input-chat-'--%>
                    <%--event.preventDefault();--%>
                    <%--sendMessageTo(user);--%>
                <%--}--%>
            <%--});--%>

            <%--chatSubmit.click(function(event) {--%>
                <%--var user = event.currentTarget.id.substring(12); // gets rid of 'submit-chat-'--%>
                <%--sendMessageTo(user);--%>
            <%--});--%>

            <%--chatContainer.append(chatWindow);--%>
            <%--chatContainer.append(chatInput);--%>
            <%--chatContainer.append(chatSubmit);--%>

            <%--if (existingChats.length) {--%>
                <%--chatContainer.hide();--%>
            <%--}--%>

            <%--$('body').append(chatContainer);--%>
        <%--}--%>
        <%--return $(selector);--%>
    <%--}--%>

    <%--function showMessage(message) {--%>
        <%--var chatWindowTarget = (message.recipient === whoami) ? message.sender : message.recipient;--%>
        <%--var chatContainer = getChatWindow(chatWindowTarget);--%>
        <%--var chatWindow = chatContainer.children('.chat');--%>
        <%--var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});--%>
        <%--userDisplay.html(message.sender + ' says: ');--%>
        <%--var messageDisplay = $('<span>');--%>
        <%--messageDisplay.html(message.message);--%>
        <%--chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');--%>
        <%--chatWindow.animate({ scrollTop: chatWindow[0].scrollHeight}, 1);--%>
        <%--if (message.sender !== whoami) {--%>
            <%--var sendingUser = $('#user-' + message.sender);--%>
            <%--if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {--%>
                <%--sendingUser.append(newMessageIcon());--%>
                <%--sendingUser.addClass('pending-messages');--%>
            <%--}--%>
        <%--}--%>
    <%--}--%>

    <%--function newMessageIcon() {--%>
        <%--var newMessage = $('<span>', {class: 'newmessage'});--%>
        <%--newMessage.html('&#x2709;');--%>
        <%--return newMessage;--%>
    <%--}--%>

    <%--$(document).ready(function() {--%>
        <%--connect();--%>
    <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>