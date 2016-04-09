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
    <title>Альбоми</title>
    <link rel="stylesheet" href="/resources/allForSite/cssForJsp/StyleForAlbom.css">
    <script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
    <link href="<c:url value="/resources/allForSite/bootstrap-3.3.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="addMenu"><i class="glyphicon glyphicon-plus addPlus"></i>
            <div class="form-group">
                    <sf:form cssClass="formm" action="/albom/addFotoAlbom" modelAttribute="AlbomFoto" method="post">
                <h2 class="textAddAlbom">Назва альбома</h2>
                <sf:input path="albomName" type="text" class="form-control seachInput"/>
                <button class="btn btn-default addAlbom">Додати</button>
                </sf:form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="am-container" id="am-container">
            <c:forEach items="${AlbomFotoList}" var="albomFotoList">
                <c:forEach items="${albomFotoList.fotos}" var="foto" varStatus="vs">
                    <c:if test="${vs.index == 0}">
                    <c:url value="/albom/${albomFotoList.id}/foto" var="url"/>
                    <a href="${url}"><img src="${foto.foto}" class="imgGalary"><div class="boxForAlbom "><h1>${albomFotoList.albomName}</h1><h3>${vs.index}</h3>
                        <form action="/albom/daleteById${albomFotoList.id}">
                        <div class="divRemove"><button type="submit" class="buttonRemove"><i class="glyphicon glyphicon-remove removeAlbom"></i></button></div></div></a>
                        </form>
                    </c:if>
                </c:forEach>
            </c:forEach>
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
<script src="/resources/allForSite/bootstrap-3.3.6-dist/jquery/jquery-2.2.3.min.js"></script>
<script src="/resources/allForSite/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/allForSite/jsForJsp/jquery.montage.min.js"></script>
</html>
