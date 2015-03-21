<%--
  Created by IntelliJ IDEA.
  User: Chuvychin
  Date: 13.03.2015
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Просто закажи такси - Регистрация</title>
  <style>
    .fig {
      text-align: center; /* Выравнивание по центру */
    }
  </style>
  <link rel="icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="board">
  <form method="post" action="" class="login">
    <p>
      <label for="login">Логин:</label>
      <input type="text" name="login" id="login" value="name@example.com">
    </p>

    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="password" id="password" value="4815162342">
    </p>

    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="passwordRepeat" id="passwordRepeat" value="">
    </p>
    <p class="register"><a href="dashboard.jsp">Зарегистрироваться</a></p>
    <br>
    <br>
    <p class="fig"><img src="img/header.jpg"></p>
  </form>
</div>
<footer class = "fig"><a href="http://www.facebook.com/chuvendoil">made by Eugen Chyvuchyn © 2015</a></footer>
</body>
</html>
