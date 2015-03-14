<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>CommandProject</title>
    <style>
        .fig {
            text-align: center; /* Выравнивание по центру */
        }
        .footer {
            text-align: center;
            color: aliceblue;
        }
    </style>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
    <form method="post" action="/Hello" class="login">
        <p>
            <label for="login">Логин:</label>
            <input type="text" name="login" id="login" value="login">
        </p>

        <p>
            <label for="password">Пароль:</label>
            <input type="password" name="password" id="password" value="">
        </p>

        <p class="login-submit">
            <button type="submit" class="login-button" >Войти</button>
        </p>
        <br>
        <br>
        <p class="fig"><a href="index.jsp"> <img src=""></a></p>
    </form>
</div>

<footer class = "footer">made by command 2 © 2015</footer>
</body>
</html>
