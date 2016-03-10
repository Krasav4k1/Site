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
            <input name = "lastNameUser"type="text" required> <span></span><br>
            <p><label>Фамилия</label></p>
            <input name ="firstNameUser" type="text" required> <span></span><br>
            <p><label>Город</label></p>	<br>
            <input name = "city" type = "text" required> <span></span><br>
            <p><label>Эл. почта</label></p>
            <input type="emailUser" type = "text" required> <span></span><br>
            <p><label>Пароль</label></p>
            <input type="password" required> <span></span><br>
            <p><label>Повторите</label></p>
            <input type="passwordUserReturn" required> <span></span><br>
            <button type="submit">Зарегистироваться</button>
        </div>
    </div>


</form>

</body>