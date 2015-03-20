<%--
  Created by IntelliJ IDEA.
  User: tsv
  Date: 19.03.15
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Просто закажи такси</title>
    <style>
        .fig {
            text-align: center;
        /*/ Выравнивание по центру /*/
        }
    </style>
    <link rel="icon" href="hw9/img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="hw9/img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="hw9/css/style.css">
</head>
<body>

<%--<div class="board">--%>
<%--<form method="get" action="/hello" id="project">--%>
<%--<input id="login" class="board" type="text" name="log" value="" size="50"/><br/>--%>
<%--<input type="password" name="pass" value="" size="50"/><br/>--%>
<%--<input id="button1" type="submit" value="Send Numbers" size="40"><br/>--%>
<%--</form>--%>
<%--</div>--%>
<div class="board">
    <form method="post" action="/auth" class="login">
        <p>
            <label for="login">login:</label>
            <input type="text" name="login" id="login">
        </p>

        <p>
            <label for="password">pwd:</label>
            <input type="password" name="password" id="password">
        </p>

        <p class="login-submit">
            <button type="submit" class="login-button">Войти</button>
        </p>

        <p class="forgot-password"><a href="index.html">Забыл пароль?</a></p>
        <p class="register"><a href="register.jsp">Регистрация</a></p>
        <br>
        <br>
        <p class="fig"><a href="index.jsp"> <img src="hw9/img/header.jpg"></a></p>
    </form>
</div>

<footer class = "fig"><a href=""></a></footer>
</body>
</html>
