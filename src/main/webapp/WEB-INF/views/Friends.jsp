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
    <title>Друзі ${user.firstName} ${user.lastName}</title>
</head>
<style>
    <%@include file="cssForJsp/StyleForFrend.css"%>
</style>
<body>


<div class="container">
    <div class="row">
        <c:forEach items="${friends}" var="fr" varStatus="vs">
        <div class="col-lg-4 col-md-4 col-md-offset-1 col-sm-7 col-sm-offset-2 col-lg-offset-1 col-xs-7 col-xs-offset-1 boxFrend">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 boxImgFriend">
                <a href="/id${fr.id}"><img src="${fr.foto}" class="imgFriend"></a>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 infoFrend">
                <a href="/id${fr.id}"><p class="nameFrend">${fr.firstName} ${fr.lastName}</p></a>
                <p>${fr.city.name}</p>
                <p>тел. 380964106766</p>
                <p class="sendMassege"><a class="sendMassege" data-toggle="modal" data-target="#exampleModal" data-whatever="${fr.firstName} ${fr.lastName}" >Hадіслати</a></p>
            </div>
        </div>


        </c:forEach>
    </div>
</div>






<%--modalMassege--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">Надіслати повідомнення</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">Кому:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">Повідомлення:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
                <button type="button" class="btn btn-primary">Надіслати</button>
            </div>
        </div>
    </div>
</div>


<script>
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    })

</script>

</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script   src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>

</html>

