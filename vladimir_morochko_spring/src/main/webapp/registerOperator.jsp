<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 09.03.2015
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Зарегистрировать оператора</title>

</head>
<body>
<h4>${registerResultMessage}</h4>
<p><a href="index_taxi.jsp"><<< залогиниться</a></p>
<form action="/registerServlet" method="post">
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
    <input type="submit" name="register" value="Зарегистрировать"/>
</form>
</body>
</html>
