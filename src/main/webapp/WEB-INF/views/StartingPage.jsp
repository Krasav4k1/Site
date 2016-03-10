<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css"></style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="" id="registration">
    <div class="forms">
        <div class="forms_left-block">
            <p><label>Имя</label></p>
            <p><label>Фамилия</label></p>
            <p><label>Город</label></p>	<br>
            <p><label>Эл. почта</label></p>
            <p><label>Пароль</label></p>
            <p><label>Повторите</label></p>
        </div>
        <div class="forms_right-block">
            <input name = "lastNameUser"type="text" required> <span></span><br>
            <input name ="firstNameUser" type="text" required> <span></span><br>
            <input name = "city" type = "text" required> <span></span><br>
            <br>
            <input type="emailUser" type = "text" required> <span></span><br>
            <input type="password" required> <span></span><br>
            <input type="passwordUserReturn" required> <span></span><br>
        </div>
        <div class="forms_bottom-block">
            <p>Введите число с картинки</p>
            <img src="https://zima98g.storage.yandex.net/rdisk/8df92dfcacae06e128e3d4884f4b4a1df0b1f3f7156f482a8b71454e944a510f/inf/uS8mfvgaIR06YJeNFObQefFy31el5D2Un4NFJrG_lMKW1MCntH0In876JrsCh4Jw3MoK8otDVz0V-v98M9fgTg==?uid=0&filename=capcha.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&tknv=v2&rtoken=5a3df8c25a357b02b0c30e201079cfaa&force_default=no" alt="число">
            <div class="capcha">
                <input type="text" required class="number" pattern="[0-9]{4}"> <span></span>
            </div>
        </div>
    </div>
    <div class="submit">
        <button type="submit">Зарегистироваться</button>
    </div>
</form>

</body>