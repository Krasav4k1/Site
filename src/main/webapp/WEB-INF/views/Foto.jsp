<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="uk"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="uk"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="uk"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="uk9=5211"> <!--<![endif]-->

<head>
    <title>Фотографії</title>
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForFoto.css">
    <script   src="https://code.jquery.com/jquery-2.2.1.min.js" ></script>
</head>
<body >


<div class="container">
    <div class="row">
        <div class="addMenu"><i class="glyphicon glyphicon-plus addPlus"></i>
            <div class="form-group">
                <sf:form cssClass="formm" action="addFileFoto?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post">
                    <h2 class="textAddAlbom"><input type="file" name="file"></h2>
                    <button type="submit" class="btn btn-default addAlbom">Додати</button>
                </sf:form>
            </div>
        </div>
    </div>
</div>

<%--<table>
    <tr>
        <td>
            <form:form action="addFileFoto?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post" >
                <input type="file" name="file">
                <input type="submit" value="add">
            </form:form>
        </td>
    </tr>
</table>--%>



<div class="clr"></div>
<div id="panel" class="panel hide"></div>
</div>
</div>
<div class="container">
    <div class="row">
        <div class="am-container" id="am-container">
            <c:forEach items="${fotos}" var="fotos">
                <a href="#"><img src="${fotos.foto}" class="imgGalary"/></a>
            </c:forEach>
        </div>

        <%--<div id="loadmore" class="loadmore" style="width:100%;">Загрузити ще...</div>--%>
    </div>
</div>
</div>
<script type="text/javascript" src="/resources/allForSite/jsForJsp/jquery.montage.min.js"></script>
<script type="text/javascript">
    $(function() {
        /*
         * just for this demo:
         */
        $('#showcode').toggle(
                function() {
                    $(this).addClass('up').removeClass('down').next().slideDown();
                },
                function() {
                    $(this).addClass('down').removeClass('up').next().slideUp();
                }
        );
        $('#panel').toggle(
                function() {
                    $(this).addClass('show').removeClass('hide');
                    $('#overlay').stop().animate( { left : - $('#overlay').width() + 20 + 'px' }, 300 );
                },
                function() {
                    $(this).addClass('hide').removeClass('show');
                    $('#overlay').stop().animate( { left : '0px' }, 300 );
                }
        );

        // initialize the plugin
        var $container 	= $('#am-container'),
                $imgs		= $container.find('img').hide(),
                totalImgs	= $imgs.length,
                cnt			= 0;

        $imgs.each(function(i) {
            var $img	= $(this);
            $('<img/>').load(function() {
                ++cnt;
                if( cnt === totalImgs ) {
                    $imgs.show();
                    $container.montage({
                        minsize	: true,
                        margin 	: 2
                    });

                    /*
                     * just for this demo:
                     */
                    $('#overlay').fadeIn(500);
                    var imgarr	= new Array();
                    for( var i = 1; i <= 73; ++i ) {
                        imgarr.push( i );
                    }
                    $('#loadmore').show().bind('click', function() {
                        var len = imgarr.length;
                        for( var i = 0, newimgs = ''; i < 15; ++i ) {
                            var pos = Math.floor( Math.random() * len ),
                                    src	= imgarr[pos];
                            newimgs	+= '<a href="#"><img src="........"/></a>';
                        }

                        var $newimages = $( newimgs );
                        $newimages.imagesLoaded( function(){
                            $container.append( $newimages ).montage( 'add', $newimages );
                        });
                    });
                }
            }).attr('src',$img.attr('src'));
        });

    });
</script>



</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="/resources/allForSite/jsForJsp/jquery.montage.min.js"></script>
</html>


