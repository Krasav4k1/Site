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
    <title>Друзі ${user.firstName} ${user.lastName}</title>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForFrend.css">
</head>
<body>

<div class="container">
    <div class="col-lg-4 col-md-5 col-sm-12 col-xs-12 headerFriend boxLeft">
        <button class="btn btn-default">Мої друзі</button>
        <button class="btn btn-default">Друзі онлайн</button>
        <button class="btn btn-default">Друзі друзів </button>
        <button class="btn btn-default">Заяви</button>
        <button class="btn btn-default">Всі</button>

    </div>
    <div class="col-lg-5 col-md-4 col-sm-7 col-xs-7 headerFriend seach boxCenter">
        <div class="form-group">
            <input type="text" class="form-control seachInput"/>
            <button class="btn btn-default">Пошук</button>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5 headerFriend boxRight">
        <select name="FrendGrup" class="form-control selectGrupFriend " id="">
            <option value="" class="optionGrup">Групи друзів</option>
            <option value="" class="optionGrup">Однокласники</option>
            <option value="" class="optionGrup">Рідні</option>
            <option value="" class="optionGrup">Любимі</option>
        </select>
    </div>
</div>

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
                <p class="sendMassege"><button class="buttomSendMessege"><a class="sendMassege" data-toggle="modal" data-target="#exampleModal" data-whatever="${fr.firstName} ${fr.lastName}" >Hадіслати</a></button></p>
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
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</html>

