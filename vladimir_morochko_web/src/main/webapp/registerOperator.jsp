<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 03.03.2015
  форма регистрации
  Реализовать авторизацию пользователя системы (оператора).
 Пользователь вводит:
 - логин (должен быть не менее 4 символов, не должен содержать пробелы)
 - идентификационный номер (10 цифр, без букв и других знаков)
 - пароль (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
 - подтверждение пароля
 - пользователь с таким логином должен быть уникальным
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>регистрация пользователя</title>
</head>
<body>
<h4>${registerResultMessage}</h4>
<p><a href="index.jsp"><<< залогиниться</a></p>
<form action="/AuthorizationServlet" method="post">
    <input type="hidden" name="oldPassword" value="${oldPassword}"/>
    <p>Логин:</p>
    <input type="text" name="login" value="${defaultLogin}"/>
    <p>Идентификационный номер:</p>
    <input type="text" name="accessId" value="${defaultAccessId}"/>
    <p>Пароль:</p>
    <input type="text" name="password" value=""/>
    <p>Подтверждение пароля:</p>
    <input type="text" name="passwordConfirm" value=""/>
    <br><br>
    <input type="submit" name="register" value="Зарегистрировать!"/>
</form>
</body>
</html>
