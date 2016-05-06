$(document).ready(function(){
        var indexUserResivedGlobal;
        var beginCount = 0;
        $.get('getAllUserForMessegerPage.json',{},function(a){
            for (var i = 0; i < a.length; i++) {
                $('.allFrendsMessege').append('<div class="row showAllUserOnMesseg"> <a id="hrefUserResived'+a[i].id+'" idResived="'+a[i].id+'"> <div class="boxForFrendsInAllMessegeFrends"> <img src="'+a[i].foto+'" class="img-rounded photoForUserInAllFrendsInMesseger"> <h5>'+a[i].firstName+' '+ a[i].lastName+'</h5> <h6 class="lastMessegerForBox"></h6> </div> </a></div>');
                $('#hrefUserResived'+a[i].id).hover(function() {
                    var indexUserResived = $(this).attr('idResived');
                    $.get('getDialog-Resived-'+indexUserResived,{},function(a){
                        $('.lastMessegerForBox').html('');
                        var lastIndex = a.length - 1;
                        $('.lastMessegerForBox').html(a[lastIndex].messager);
                    });
                });
                $('#hrefUserResived'+a[i].id).click(function(){
                    var indexUserResived = $(this).attr('idResived');
                    indexUserResivedGlobal = $(this).attr('idResived');
                    beginCount = 0;
                    $.get('getDialog-Resived-'+indexUserResived+'-'+beginCount,{},function(a){
                        if(a.length == 10) {
                            $('.mainMessegeWindow').html('<div class="loadMore">загрузить ще...</div>');
                                $('.loadMore').css("display","inline-block");
                                $('.loadMore').click(function(){
                                    beginCount += 10;
                                    addAfterMesegger();
                                });
                        }
                        for(var i = a.length-1; i >= 0; i--){
                                if (a[i].userReceivedMessages.id == indexUserResived){
                                    $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                                }else{
                                    $('.mainMessegeWindow').append('<div class="row"> <div class="sendUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoSendMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                                }
                        }
                        setTimeout('document.getElementById("mainMessegeWindow").scrollTop += 10000',50);
                    });
                });
            }

            addAfterMesegger = function(){
                $.get('getDialog-Resived-'+indexUserResivedGlobal+'-'+beginCount,{},function(a){
                    if(a.length != 10) {
                        $('.loadMore').css("display","none");
                    }
                    for(var i = 0; i < a.length; i++){
                        if (a[i].userReceivedMessages.id == indexUserResivedGlobal){
                            $('.loadMore').after('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                        }else{
                            $('.loadMore').after('<div class="row"> <div class="sendUserMesseges"> <a href="id'+a[i].userSentMessager.id+'"><img src="'+a[i].userSentMessager.foto+'" class="img-rounded photoForUserWhoSendMessege"></a> <h4>'+a[i].messager+'</h4> </div> </div>');
                        }
                    }
                });
            }

        });



        sendMessegEventKey = function() {
        submitForm();
        }
            function submitForm() {
                var roles = [$('.inputMessegesLable').val(),indexUserResivedGlobal];
                jQuery.ajax({
                    type: "POST",
                    url: "/sendMessege?${_csrf.parameterName}=${_csrf.token}",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(roles),
                    success: function (a){
                        var firstIndex = 0;
                        $('.mainMessegeWindow').append('<div class="row"> <div class="reciveUserMesseges"> <a href="id'+a[firstIndex].userSentMessager.id+'"><img src="'+a[firstIndex].userSentMessager.foto+'" class="img-rounded photoForUserWhoResiverMessege"></a> <h4>'+a[firstIndex].messager+'</h4> </div> </div>');
                        $('.inputMessegesLable').val('');
                        setTimeout('document.getElementById("mainMessegeWindow").scrollTop += 10000',50);
                    }
                });
            }

    });