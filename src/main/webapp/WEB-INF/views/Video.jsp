<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->
<head>
    <title>Відео</title>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>


<h1>Video</h1>


</body>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>


<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Realtime Guestbook</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
    <%--<p>Write a message:</p>--%>
    <%--<textarea id="message"></textarea>--%>
    <%--<button type="button" id="send">Send</button>--%>
<%--</div>--%>
<%--<div>--%>
    <%--<h3>Messages:</h3>--%>
    <%--<ol id="messages"></ol>--%>
<%--</div>--%>

<%--<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>--%>
<%--<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>--%>

<%--<script type="text/javascript">--%>
    <%--$(document).ready(function() {--%>
        <%--var messageList = $("#messages");--%>

        <%--var getMessageString = function(message) {--%>
            <%--return "<li>" + message.content + "</li>";--%>
        <%--};--%>

        <%--var socket = new SockJS('/guestbook');--%>
        <%--var stompClient = Stomp.over(socket);--%>

        <%--stompClient.connect({ }, function(frame) {--%>
            <%--// subscribe to the /topic/entries endpoint which feeds newly added messages--%>
            <%--stompClient.subscribe('/topic/entries', function(data) {--%>
                <%--// when a message is received add it to the end of the list--%>
                <%--var body = data.body;--%>
                <%--var message = JSON.parse(body);--%>
                <%--messageList.append(getMessageString(message));--%>
            <%--});--%>
        <%--});--%>

        <%--$("#send").on("click", function() {--%>
            <%--// send the message--%>
            <%--stompClient.send("/app/guestbook", {}, $("#message").val());--%>
            <%--$("#message").val("");--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>

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